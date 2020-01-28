import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
public class Duke {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Task> list = new ArrayList<>();
        try {
            list = printFileContents("data/duke.txt");
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
        System.out.println("-----------------------------------");
        System.out.println("Hello! I'm Cat");
        System.out.println("What can I do for you?");
        System.out.println("-----------------------------------");
        System.out.println();
        String command = sc.nextLine();
        while (!command.equals("bye")) {
            System.out.println("-----------------------------------");
            if (command.equals("list")) {
                System.out.println("Here are the tasks in your list:");
                int i = 1;
                for (Task t : list) {
                    System.out.println(i + "." + t);
                    i++;
                }
            } else if (command.indexOf("done") == 0) {
                int index = Integer.parseInt(command.split(" ")[1]) - 1;
                if (index < list.size() && index >= 0) {
                    System.out.println("Nice! I've marked this task as done:");
                    Task task = list.get(index);
                    task.markAsDone();
                    writeToFile("data/duke.txt", list);
                    System.out.println(task);
                } else {
                    System.out.println("This task does not exist in your list");
                }
            } else if (command.indexOf("delete") == 0) {
                int index = Integer.parseInt(command.split(" ")[1]) - 1;
                if (index < list.size() && index >= 0) {
                    System.out.println("Noted. I've removed this task: ");
                    Task task = list.remove(index);
                    writeToFile("data/duke.txt", list);
                    System.out.println(task);
                    System.out.println("Now you have " + list.size() + " tasks in the list.");
                } else {
                    System.out.println("This task does not exist in your list");
                }
            } else if (command.indexOf("todo") == 0) {
                int emptyIndex = command.indexOf(" ");
                if (command.trim().equals("todo")) {
                    System.out.println("☹ OOPS!!! The description of a todo cannot be empty.");
                } else {
                    Todo todo = new Todo(command.substring(emptyIndex + 1));
                    list.add(todo);
                    writeToFile("data/duke.txt", list);
                    System.out.println("Got it. I've added this task: ");
                    System.out.println(todo);
                    System.out.println("Now you have " + list.size() + " tasks in the list." );
                }
            } else if (command.indexOf("deadline") == 0) {
                int emptyIndex = command.indexOf(" ");
                int slashIndex = command.indexOf("/");
                if (command.trim().equals("deadline")) {
                    System.out.println("☹ OOPS!!! The description of a deadline cannot be empty.");
                } else if (slashIndex == -1) {
                    System.out.println("☹ OOPS!!! The deadline of a deadline cannot be empty.");
                } else {
                    Deadline deadline = new Deadline(command.substring(emptyIndex + 1, slashIndex - 1), LocalDate.parse(command.substring(slashIndex + 4)));
                    list.add(deadline);
                    writeToFile("data/duke.txt", list);
                    System.out.println("Got it. I've added this task: ");
                    System.out.println(deadline);
                    System.out.println("Now you have " + list.size() + " tasks in the list.");
                }
            } else if (command.indexOf("event") == 0) {
                int emptyIndex = command.indexOf(" ");
                int slashIndex = command.indexOf("/");
                if (command.trim().equals("event")) {
                    System.out.println("☹ OOPS!!! The description of a event cannot be empty.");
                } else if (slashIndex == -1) {
                    System.out.println("☹ OOPS!!! The time of a event cannot be empty.");
                } else {
                    Event event = new Event(command.substring(emptyIndex + 1, slashIndex - 1), LocalDate.parse(command.substring(slashIndex + 4)));
                    list.add(event);
                    writeToFile("data/duke.txt", list);
                    System.out.println("Got it. I've added this task: ");
                    System.out.println(event);
                    System.out.println("Now you have " + list.size() + " tasks in the list." );
                }
            } else {
                System.out.println("☹ OOPS!!! I'm sorry, but I don't know what that means :-(");
            }
            System.out.println("-----------------------------------");
            System.out.println();
            command = sc.nextLine();
        }
        System.out.println("-----------------------------------");
        System.out.println("Bye. Hope to see you again soon!");
        System.out.println("-----------------------------------");
    }

    private static ArrayList<Task> printFileContents(String filePath) throws FileNotFoundException {
        ArrayList<Task> tasks = new ArrayList<>();
        File f = new File(filePath); // create a File for the given file path
        Scanner s = new Scanner(f); // create a Scanner using the File as the source
        while (s.hasNext()) {
            String[] data = s.nextLine().split("\\|");
            String type = data[0].trim();
            String isDone = data[1].trim();
            if (type.equals("T")){
                Todo todo = new Todo(data[2].trim());
                if (isDone.equals("1")) {
                    todo.markAsDone();
                }
                tasks.add(todo);
            } else if (type.equals("D")) {
                Deadline deadline = new Deadline(data[2].trim(), LocalDate.parse(data[3].trim()));
                if (isDone.equals("1")) {
                    deadline.markAsDone();
                }
                tasks.add(deadline);
            } else {
                Event event = new Event(data[2].trim(), LocalDate.parse(data[3].trim()));
                if (isDone.equals("1")) {
                    event.markAsDone();
                }
                tasks.add(event);
            }
        }
        return tasks;
    }

    private static void writeFileContent(String filePath, ArrayList<Task> tasks) throws IOException {
        FileWriter fw = new FileWriter(filePath);
        for (Task task : tasks) {
            String type = task instanceof Todo ? "T" : task instanceof Deadline ? "D" : "E";
            String status = task.isDone ? "1" : "0";
            String description = task.description;
            String text = type + " | " + status + " | " + description;
            if (task instanceof Deadline) {
                text += " | " + ((Deadline) task).by.format(DateTimeFormatter.ofPattern("MMM d yyyy"));
            }
            if (task instanceof Event) {
                text += " | " + ((Event) task).at.format(DateTimeFormatter.ofPattern("MMM d yyyy"));
            }
            fw.write(text + System.lineSeparator());
        }
        fw.close();
    }

    private static void writeToFile(String filePath, ArrayList<Task> tasks) {
        try {
            writeFileContent(filePath, tasks);
        } catch (IOException e) {
            System.out.println("Something went wrong: " + e.getMessage());
        }
    }
}

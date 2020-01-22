import java.util.Scanner;
import java.util.ArrayList;
public class Duke {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Task> list = new ArrayList<>();
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
                if (index < list.size()) {
                    System.out.println("Nice! I've marked this task as done:");
                    Task task = list.get(index);
                    task.markAsDone();
                    System.out.println(task);
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
                    Deadline deadline = new Deadline(command.substring(emptyIndex + 1, slashIndex - 1), command.substring(slashIndex + 4));
                    list.add(deadline);
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
                    Event event = new Event(command.substring(emptyIndex + 1, slashIndex - 1), command.substring(slashIndex + 4));
                    list.add(event);
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
}

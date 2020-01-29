package duke;

import java.util.Scanner;
import java.util.ArrayList;
import java.io.FileNotFoundException;
import java.time.LocalDate;
public class Duke {
    public static void main(String[] args) {
        System.out.println("hi");
        Scanner sc = new Scanner(System.in);
        Ui ui = new Ui();
        Parser parser = new Parser();
        Storage storage = new Storage("data/duke.txt");
        ui.greeting();
        ArrayList<Task> tasks = new ArrayList<>();
        try {
            tasks = storage.printFileContents();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
        TaskList taskList = new TaskList(tasks);
        String input = sc.nextLine();
        String command = parser.parseCommand(input);
        while (!command.equals("bye")) {
            ui.printBarrier();
            if (command.equals("list")) {
                taskList.listTask();
            } else if (command.equals("done")) {
                int index = Integer.parseInt(input.split(" ")[1]) - 1;
                if (index < tasks.size() && index >= 0) {
                    taskList.markTaskDone(index);
                    storage.writeToFile(tasks);
                } else {
                    ui.taskNotExist();
                }

            } else if (command.equals("delete")) {
                int index = Integer.parseInt(input.split(" ")[1]) - 1;
                if (index < tasks.size() && index >= 0) {
                    taskList.deleteTask(index);
                    storage.writeToFile(tasks);
                } else {
                    ui.taskNotExist();
                }

            } else if (command.equals("todo")) {
                int emptyIndex = input.indexOf(" ");
                if (input.trim().equals("todo")) {
                    ui.emptyDescription();
                } else {
                    taskList.addToDo(input.substring(emptyIndex + 1));
                    storage.writeToFile(tasks);
                }
            } else if (command.equals("deadline")) {
                int emptyIndex = input.indexOf(" ");
                int slashIndex = input.indexOf("/");
                if (input.trim().equals("deadline")) {
                    ui.emptyDescription();
                } else if (slashIndex == -1) {
                    ui.emptyDate();
                } else {
                    taskList.addDeadline(input.substring(emptyIndex + 1, slashIndex - 1), LocalDate.parse(input.substring(slashIndex + 4)));
                    storage.writeToFile(tasks);
                }
            } else if (command.equals("event")) {
                int emptyIndex = input.indexOf(" ");
                int slashIndex = input.indexOf("/");
                if (input.trim().equals("event")) {
                    ui.emptyDescription();
                } else if (slashIndex == -1) {
                    ui.emptyDate();
                } else {
                    taskList.addEvent(input.substring(emptyIndex + 1, slashIndex - 1), LocalDate.parse(input.substring(slashIndex + 4)));
                    storage.writeToFile(tasks);
                }
            }  else if (command.equals("find")) {
                String keyword = input.split(" ")[1];
                taskList.findTask(keyword);
            } else {
                ui.invalidCommand();
            }
            ui.printBarrier();
            System.out.println();
            input = sc.nextLine();
            command = parser.parseCommand(input);
        }
        ui.sayBye();
    }


}


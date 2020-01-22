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
            }  else if (command.contains("done")) {
                int index = Integer.parseInt(command.split(" ")[1]) - 1;
                if (index < list.size()) {
                    System.out.println("Nice! I've marked this task as done:");
                    Task task = list.get(index);
                    task.markAsDone();
                    System.out.println(task);
                } else {
                    System.out.println("This task does not exist in your list");
                }

            } else {
                list.add(new Task(command));
                System.out.println("added: " + command);
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

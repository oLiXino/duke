import java.util.Scanner;
public class Duke {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("-----------------------------------");
        System.out.println("Hello! I'm Cat");
        System.out.println("What can I do for you?");
        System.out.println("-----------------------------------");
        System.out.println();
        String command = sc.nextLine();
        while (!command.equals("bye")) {
            System.out.println("-----------------------------------");
            System.out.println(command);
            System.out.println("-----------------------------------");
            System.out.println();
            command = sc.nextLine();
        }
        System.out.println("-----------------------------------");
        System.out.println("Bye. Hope to see you again soon!");
        System.out.println("-----------------------------------");
    }
}

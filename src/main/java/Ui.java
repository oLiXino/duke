public class Ui {
    public Ui () {}
    protected void greeting() {
        System.out.println("-----------------------------------");
        System.out.println("Hello! I'm Cat");
        System.out.println("What can I do for you?");
        System.out.println("-----------------------------------");
        System.out.println();
    }

    protected void taskNotExist() {
        System.out.println("This task does not exist in your list");
    }

    protected void emptyDescription() {
        System.out.println("☹ OOPS!!! The description of the task cannot be empty.");
    }

    protected void emptyDate() {
        System.out.println("☹ OOPS!!! The date of the task cannot be empty.");
    }

    protected void invalidCommand() {
        System.out.println("☹ OOPS!!! I'm sorry, but I don't know what that means :-(");
    }

    protected void printBarrier() {
        System.out.println("-----------------------------------");
    }

    protected void sayBye() {
        System.out.println("-----------------------------------");
        System.out.println("Bye. Hope to see you again soon!");
        System.out.println("-----------------------------------");
    }
}

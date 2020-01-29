package duke;

/**
 * Represents a user interface to interact with the user.
 */
public class Ui {

    public Ui () {}

    /**
     * Prints the greeting message when starting up the project.
     */
    protected void greeting() {
        System.out.println("-----------------------------------");
        System.out.println("Hello! I'm Cat");
        System.out.println("What can I do for you?");
        System.out.println("-----------------------------------");
        System.out.println();
    }

    /**
     * Prints the error message when the task that user is looking for does not exist in the list.
     */
    protected void taskNotExist() {
        System.out.println("This task does not exist in your list");
    }

    /**
     * Prints the error message when the input of description for the new task to be created is empty.
     */
    protected void emptyDescription() {
        System.out.println("☹ OOPS!!! The description of the task cannot be empty.");
    }

    /**
     * Prints the error message when the input of date for the new task to be created is empty.
     */
    protected void emptyDate() {
        System.out.println("☹ OOPS!!! The date of the task cannot be empty.");
    }

    /**
     * Prints the error message when the user command input cannot be recognized.
     */
    protected void invalidCommand() {
        System.out.println("☹ OOPS!!! I'm sorry, but I don't know what that means :-(");
    }

    /**
     * Prints the barrier message.
     */
    protected void printBarrier() {
        System.out.println("-----------------------------------");
    }

    /**
     * Prints the goodbye message when user exit the program.
     */
    protected void sayBye() {
        System.out.println("-----------------------------------");
        System.out.println("Bye. Hope to see you again soon!");
        System.out.println("-----------------------------------");
    }
}


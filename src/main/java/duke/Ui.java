package duke;

/**
 * Represents a user interface to interact with the user.
 */
public class Ui {

    public Ui () {}

    /**
     * Prints the greeting message when starting up the project.
     */
    protected String greeting() {
        String str = "-----------------------------------\n"
                + "Hello! I'm Cat\n"
                + "What can I do for you?\n"
                + "-----------------------------------\n";
        return str;
//        System.out.println("-----------------------------------");
//        System.out.println("Hello! I'm Cat");
//        System.out.println("What can I do for you?");
//        System.out.println("-----------------------------------");
//        System.out.println();
    }

    /**
     * Prints the error message when the task that user is looking for does not exist in the list.
     */
    protected String taskNotExist() {
        return "This task does not exist in your list\n";
        //System.out.println("This task does not exist in your list");
    }

    /**
     * Prints the error message when the input of description for the new task to be created is empty.
     */
    protected String emptyDescription() {
        return "☹ OOPS!!! The description of the task cannot be empty.\n";
        //System.out.println("☹ OOPS!!! The description of the task cannot be empty.");
    }

    /**
     * Prints the error message when the input of date for the new task to be created is empty.
     */
    protected String emptyDate() {
        return "☹ OOPS!!! The date of the task cannot be empty.\n";
        //System.out.println("☹ OOPS!!! The date of the task cannot be empty.");
    }

    /**
     * Prints the error message when the user command input cannot be recognized.
     */
    protected String invalidCommand() {
        //System.out.println("☹ OOPS!!! I'm sorry, but I don't know what that means :-(");
        return "☹ OOPS!!! I'm sorry, but I don't know what that means :-(\n";
    }

    /**
     * Prints the barrier message.
     */
    protected String printBarrier() {
        //System.out.println("-----------------------------------");
        return "-----------------------------------\n";
    }

    /**
     * Prints the goodbye message when user exit the program.
     */
    protected String sayBye() {
        String str = "-----------------------------------\n"
                + "Bye. Hope to see you again soon!\n"
                + "-----------------------------------\n";
        return str;
//        System.out.println("-----------------------------------");
//        System.out.println("Bye. Hope to see you again soon!");
//        System.out.println("-----------------------------------");
    }
}


package duke;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Contains the task list which contains the tasks created by the user.
 */
public class TaskList {

    ArrayList<Task> tasks;

    public TaskList(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    /**
     * Displays all tasks in the task list.
     */
    protected void listTask() {
        System.out.println("Here are the tasks in your list:");
        int i = 1;
        for (Task t : tasks) {
            System.out.println(i + "." + t);
            i++;
        }
    }

    /**
     * Marks the status of a specific task in the task list to be done.
     *
     * @param index the index of the task in the task list.
     */
    protected void markTaskDone(int index) {
        System.out.println("Nice! I've marked this task as done:");
        Task task = tasks.get(index);
        task.markAsDone();
        System.out.println(task);
    }

    /**
     * Adds a new todo task to the task list.
     *
     * @param description the description of the new task.
     */
    protected void addToDo(String description) {
        Todo todo = new Todo(description);
        tasks.add(todo);
        System.out.println("Got it. I've added this task: ");
        System.out.println(todo);
        System.out.println("Now you have " + tasks.size() + " tasks in the list." );
    }

    /**
     * Adds a new deadline task to the task list.
     *
     * @param description the description of the new task.
     * @param date the date of the new task.
     */
    protected void addDeadline(String description, LocalDate date) {
        Deadline deadline = new Deadline(description, date);
        tasks.add(deadline);
        System.out.println("Got it. I've added this task: ");
        System.out.println(deadline);
        System.out.println("Now you have " + tasks.size() + " tasks in the list.");
    }

    /**
     * Adds a new event task to the task list.
     *
     * @param description the description of the new task.
     * @param date the date of the new task.
     */
    protected void addEvent(String description, LocalDate date) {
        Event event = new Event(description, date);
        tasks.add(event);
        System.out.println("Got it. I've added this task: ");
        System.out.println(event);
        System.out.println("Now you have " + tasks.size() + " tasks in the list." );
    }

    /**
     * Removes a specific task from the task list.
     *
     * @param index the index of the task in the task list.
     * @throws Exception if index > the number of tasks in the task list or index < 0.
     */
    protected void deleteTask(int index) throws Exception{
        if (index >= tasks.size() || index < 0) {
            throw new Exception("The task does not exist on the list");
        }
        System.out.println("Noted. I've removed this task: ");
        Task task = tasks.remove(index);
        System.out.println(task);
        System.out.println("Now you have " + tasks.size() + " tasks in the list.");
    }

    /**
     * Searches the tasks that contains the keyword and displays these tasks.
     *
     * @param keyword the keyword used to search for the tasks.
     */
    protected void findTask(String keyword) {
        ArrayList<Task> result = new ArrayList<>();
        for (Task task : tasks) {
            if (task.description.contains(keyword)) {
                result.add(task);
            }
        }
        if (result.size() == 0) {
            System.out.println("Sorry! I can't find any task regarding " + keyword);
        } else {
            System.out.println("Here are the matching tasks in your list:");
            for (Task task : result) {
                System.out.println(task);
            }
        }
    }
}


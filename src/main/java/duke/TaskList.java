package duke;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Contains the task list which contains the tasks created by the user.
 */
public class TaskList {

    ArrayList<Task> tasks;
    String taskMessage;

    public TaskList(ArrayList<Task> tasks) {
        this.tasks = tasks;
        this.taskMessage = "";
    }

    /**
     * Displays all tasks in the task list.
     */
    protected void listTask() {
        taskMessage = "Here are the tasks in your list:\n";
        int i = 1;
        for (Task t : tasks) {
            this.taskMessage += i + "." + t + "\n";
            i++;
        }
    }

    /**
     * Marks the status of a specific task in the task list to be done.
     *
     * @param index the index of the task in the task list.
     */
    protected void markTaskDone(int index) {
        taskMessage = "Nice! I've marked this task as done:\n";
        Task task = tasks.get(index);
        task.markAsDone();
        taskMessage += task;
    }

    /**
     * Adds a new todo task to the task list.
     *
     * @param description the description of the new task.
     */
    protected void addToDo(String description) {
        Todo todo = new Todo(description);
        tasks.add(todo);
        taskMessage = "Got it. I've added this task: \n";
        taskMessage += todo + "\n";
        taskMessage += "Now you have " + tasks.size() + " tasks in the list.\n";
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
        taskMessage = "Got it. I've added this task: \n";
        taskMessage += deadline + "\n";
        taskMessage += "Now you have " + tasks.size() + " tasks in the list.\n";
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
        taskMessage = "Got it. I've added this task: \n";
        taskMessage += event + "\n";
        taskMessage += "Now you have " + tasks.size() + " tasks in the list.\n";
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
        Task task = tasks.remove(index);
        taskMessage = "Got it. I've removed this task: \n";
        taskMessage += task + "\n";
        taskMessage += "Now you have " + tasks.size() + " tasks in the list.\n";
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
            taskMessage = "Sorry! I can't find any task with the keyword " + keyword + "\n";
        } else {
            taskMessage += "Here are the matching tasks in your list:\n";
            for (Task task : result) {
                taskMessage += task + "\n";
            }
        }
    }
}


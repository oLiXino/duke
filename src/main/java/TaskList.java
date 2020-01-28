import java.time.LocalDate;
import java.util.ArrayList;
public class TaskList {

    ArrayList<Task> tasks = new ArrayList<>();

    public TaskList(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    protected void listTask() {
        System.out.println("Here are the tasks in your list:");
        int i = 1;
        for (Task t : tasks) {
            System.out.println(i + "." + t);
            i++;
        }
    }

    protected void markTaskDone(int index) {
        System.out.println("Nice! I've marked this task as done:");
        Task task = tasks.get(index);
        task.markAsDone();
        System.out.println(task);
    }

    protected void addToDo(String description) {
        Todo todo = new Todo(description);
        tasks.add(todo);
        System.out.println("Got it. I've added this task: ");
        System.out.println(todo);
        System.out.println("Now you have " + tasks.size() + " tasks in the list." );
    }

    protected void addDeadline(String description, LocalDate date) {
        Deadline deadline = new Deadline(description, date);
        tasks.add(deadline);
        System.out.println("Got it. I've added this task: ");
        System.out.println(deadline);
        System.out.println("Now you have " + tasks.size() + " tasks in the list.");
    }

    protected void addEvent(String description, LocalDate date) {
        Event event = new Event(description, date);
        tasks.add(event);
        System.out.println("Got it. I've added this task: ");
        System.out.println(event);
        System.out.println("Now you have " + tasks.size() + " tasks in the list." );
    }

    protected void deleteTask(int index) {
        System.out.println("Noted. I've removed this task: ");
        Task task = tasks.remove(index);
        System.out.println(task);
        System.out.println("Now you have " + tasks.size() + " tasks in the list.");
    }
}

package duke;

import java.io.File;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Represents the hard disk storage at a specific file location.
 */
public class Storage {

    String filePath;

    public Storage(String filePath) {
        this.filePath = filePath;
    }

    /**
     * Returns the list of task retrieved from the given file location.
     *
     * @return the task list that retrieved from the file.
     * @throws FileNotFoundException If file is not found.
     */
    public ArrayList<Task> printFileContents() throws FileNotFoundException {
        ArrayList<Task> tasks = new ArrayList<>();
        File f = new File(filePath); // create a File for the given file path
        Scanner s = new Scanner(f); // create a Scanner using the File as the source
        while (s.hasNext()) {
            String[] data = s.nextLine().split("\\|");
            String type = data[0].trim();
            String isDone = data[1].trim();
            if (type.equals("T")){
                Todo todo = new Todo(data[2].trim());
                if (isDone.equals("1")) {
                    todo.markAsDone();
                }
                tasks.add(todo);
            } else if (type.equals("D")) {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM d yyyy");
                Deadline deadline = new Deadline(data[2].trim(), LocalDate.parse(data[3].trim(), formatter));
                if (isDone.equals("1")) {
                    deadline.markAsDone();
                }
                tasks.add(deadline);
            } else {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM d yyyy");
                Event event = new Event(data[2].trim(), LocalDate.parse(data[3].trim(), formatter));
                if (isDone.equals("1")) {
                    event.markAsDone();
                }
                tasks.add(event);
            }
        }
        return tasks;
    }

    /**
     * Writes content of a task list to a special file location on the hard disk
     *
     * @param tasks the task list to be written to the file.
     * @throws IOException if encounter issue writing content to the file.
     */
    public void writeFileContent(ArrayList<Task> tasks) throws IOException {
        FileWriter fw = new FileWriter(filePath);
        for (Task task : tasks) {
            String type = task instanceof Todo ? "T" : task instanceof Deadline ? "D" : "E";
            String status = task.isDone ? "1" : "0";
            String description = task.description;
            String text = type + " | " + status + " | " + description;
            if (task instanceof Deadline) {
                text += " | " + ((Deadline) task).by.format(DateTimeFormatter.ofPattern("MMM d yyyy"));
            }
            if (task instanceof Event) {
                text += " | " + ((Event) task).at.format(DateTimeFormatter.ofPattern("MMM d yyyy"));
            }
            fw.write(text + System.lineSeparator());
        }
        fw.close();
    }

    /**
     * Calls writeFileContent method to write content to a specific file.
     *
     * @param tasks the task list to be written to the file.
     */
    public String writeToFile(ArrayList<Task> tasks) {
        String status;
        try {
            writeFileContent(tasks);
            status = "Successful saved to file";
        } catch (IOException e) {
            status = "Failed to saved to file";
        }
        return status;
    }
}

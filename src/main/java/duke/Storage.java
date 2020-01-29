package duke;

import java.io.File;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Storage {
    String filePath;
    public Storage(String filePath) {
        this.filePath = filePath;
    }

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

    public void writeToFile(ArrayList<Task> tasks) {
        try {
            writeFileContent(tasks);
        } catch (IOException e) {
            System.out.println("Something went wrong: " + e.getMessage());
        }
    }
}


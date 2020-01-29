package duke;

public class Parser {

    public Parser() {};

    public String parseCommand(String input) {
        String command = null;
        if (input.equals("bye")) {
            command = input;
        } else if (input.equals("list")) {
            command = input;
        } else if (input.indexOf("done") == 0) {
            command = "done";
        } else if (input.indexOf("delete") == 0) {
            command = "delete";
        } else if (input.indexOf("todo") == 0) {
            command = "todo";
        } else if (input.indexOf("deadline") == 0) {
            command = "deadline";
        } else if (input.indexOf("event") == 0) {
            command = "event";
        } else if (input.indexOf("find") == 0) {
            command = "find";
        } else {
            command = input;
        }
        return command;
    }

}


# Setting Up

**Prerequisites**

* JDK 11
* Recommended: IntelliJ IDE
* Fork this repo to your GitHub account and clone the fork to your computer

**Importing the project into IntelliJ**

1. Open IntelliJ (if you are not in the welcome screen, click `File` > `Close Project` to close the existing project dialog first).
1. Set up the correct JDK version.
   * Click `Configure` > `Structure for new Projects` (in older versions of Intellij:`Configure` > `Project Defaults` > `Project Structure`).
   * If JDK 11 is listed in the drop down, select it. If it is not, click `New...` and select the directory where you installed JDK 11.
   * Click `OK`.
1. Click `Import Project`.
1. Locate the project directory and click `OK`.
1. Select `Create project from existing sources` and click `Next`.
1. Rename the project if you want. Click `Next`.
1. Ensure that your src folder is checked. Keep clicking `Next`.
1. Click `Finish`.

# Command List
* list - To list all tasks on the task list.
* done {task ID(s)} - To mark one more tasks as done.
* todo {task description} - To add new todo task to the task list.
* deadline {task description} /by {YYYY-MM-DD} - To add new deadline task to the task list.
* event {task description} /at {YYYY-MM-DD} - To add new event task to the task list.
* delete {task ID(s)} - To delete one more tasks from the task list.
* find {key word} - To search for task(s) that contain the key word.
* bye - To exit the program.

# Tutorials 

Duke Increment | Tutorial
---------------|---------------
`A-Gradle` | [Gradle Tutorial](tutorials/gradleTutorial.md)
`A-TextUiTesting` | [Text UI Testing Tutorial](tutorials/textUiTestingTutorial.md)
`Level-10` | JavaFX tutorials:<br>→ [Part 1: Introduction to JavaFX][fx1]<br>→ [Part 2: Creating a GUI for Duke][fx2]<br>→ [Part 3: Interacting with the user][fx3]<br>→ [Part 4: Introduction to FXML][fx4]

[fx1]: <tutorials/javaFxTutorialPart1.md>
[fx2]: <tutorials/javaFxTutorialPart2.md>
[fx3]: <tutorials/javaFxTutorialPart3.md>
[fx4]: <tutorials/javaFxTutorialPart4.md>

# Feedback, Bug Reports

* If you have feedback or bug reports, please post in [se-edu/duke issue tracker](https://github.com/se-edu/duke/issues).
* We welcome pull requests too.

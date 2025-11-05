Of course! Here is a comprehensive, detailed `README.md` file that explains your `TaskManager` Java code. This is perfect for documenting your project on GitHub or for your own learning.

---

# **Task Manager - Console Application** 📝

## **1. Overview**

This is a simple, console-based **Task Manager** application written in Java. It allows users to manage a personal to-do list by adding tasks, viewing them, marking them as completed, and deleting them. The application runs entirely in the command line and uses an in-memory `ArrayList` to store tasks for the duration of the session.

---

## **2. Features**

- ✅ **Add a new task**: Users can input a task description to add it to the list.
- 📋 **View all tasks**: Displays all current tasks with their completion status.
- ☑️ **Mark task as completed**: Users can mark an existing task as done.
- 🗑️ **Delete a task**: Users can remove a task from the list.
- 🚪 **Exit the application**: A clean way to close the program.

---

## **3. Code Structure & Explanation**

The application is contained within a single Java class: `TaskManager.java`.

### **3.1. Class and Global Variables**

```java
public class Main {
    private static ArrayList<String> tasks = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    // ... rest of the code
}
```

- **`tasks`**: This is an `ArrayList<String>` that acts as the in-memory database for storing all tasks. Each task is stored as a `String` with a prefix indicating its status (`[ ] ` for pending, `[✓] ` for completed).
- **`scanner`**: A `Scanner` object is declared globally to read user input from the console (`System.in`) throughout the application, avoiding the need to create a new one in every method.

### **3.2. The `main` Method**

```java
public static void main(String[] args) {
    System.out.println("📝 Welcome to the Simple Task Manager!");
    while (true) {
        displayMenu();
        int choice = getUserChoice();
        // ... switch statement to handle user choice
    }
}
```

- This is the **entry point** of the application.
- It displays a welcome message and enters an **infinite loop** (`while (true)`), which keeps the program running until the user explicitly chooses to exit (option 5).
- Inside the loop, it continuously displays the menu, gets the user's choice, and uses a `switch` statement to execute the corresponding functionality.

### **3.3. The `displayMenu` Method**

```java
public static void displayMenu() {
    System.out.println("\n===== Task Manager Menu =====");
    System.out.println("1. Add a new task");
    // ... other options
    System.out.print("👉 Please choose an option (1-5): ");
}
```

- This method **prints the user interface** to the console.
- It presents a numbered list of actions the user can take.

### **3.4. The `getUserChoice` Method**

```java
public static int getUserChoice() {
    try {
        return Integer.parseInt(scanner.nextLine());
    } catch (NumberFormatException e) {
        return -1; // Invalid input
    }
}
```

- This method is responsible for **safely reading the user's numerical input**.
- It uses `scanner.nextLine()` to read the entire input as a `String`.
- It then attempts to **parse** that `String` into an `int` using `Integer.parseInt()`.
- **Error Handling:** If the user enters something that isn't a number (e.g., "abc"), `parseInt()` will throw a `NumberFormatException`. The `try-catch` block handles this gracefully by returning `-1`, which the `switch` statement in `main` will interpret as an invalid option.

### **3.5. The `addTask` Method**

```java
public static void addTask() {
    System.out.print("Enter the task: ");
    String task = scanner.nextLine().trim();
    if (!task.isEmpty()) {
        tasks.add("[ ] " + task);
        System.out.println("✅ Task added successfully!");
    } else {
        System.out.println("❌ Task cannot be empty.");
    }
}
```

- **Prompts the user** to type a task description.
- **`.trim()`** is used to remove any accidental leading or trailing spaces from the input.
- **Validation:** Checks if the input is not empty (`!task.isEmpty()`).
- If valid, it **adds the task** to the `ArrayList`, prefixing it with `"[ ] "` to indicate it's not completed.
- Provides clear **success or error feedback** to the user.

### **3.6. The `viewTasks` Method**

```java
public static void viewTasks() {
    if (tasks.isEmpty()) {
        System.out.println("📭 No tasks available.");
    } else {
        System.out.println("\n📋 Your Tasks:");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ". " + tasks.get(i));
        }
    }
}
```

- **Checks if the list is empty** to avoid confusing the user with an empty list.
- If there are tasks, it **iterates through the `ArrayList`** using a `for` loop.
- It prints each task with a **number (index + 1)** for easy reference in other operations like marking or deletion.

### **3.7. The `markTaskAsCompleted` Method**

```java
public static void markTaskAsCompleted() {
    viewTasks(); // Show tasks first
    if (tasks.isEmpty()) return; // Exit if no tasks

    System.out.print("Enter task number to mark as completed: ");
    try {
        int index = Integer.parseInt(scanner.nextLine()) - 1;
        if (index >= 0 && index < tasks.size()) {
            String task = tasks.get(index);
            if (task.startsWith("[ ]")) {
                tasks.set(index, "[✓] " + task.substring(4));
                System.out.println("✅ Task marked as completed!");
            } else {
                System.out.println("⚠️ Task is already completed.");
            }
        } else {
            System.out.println("❌ Invalid task number.");
        }
    } catch (NumberFormatException e) {
        System.out.println("❌ Please enter a valid number.");
    }
}
```

1.  **Calls `viewTasks()`** to show the user the current list and the numbers associated with each task.
2.  **Exits early** if the list is empty.
3.  **Prompts the user** for the task number they want to mark.
4.  **Converts the input to a zero-based index** (`-1`).
5.  **Validation:** Checks if the index is within the valid range (`0` to `tasks.size()-1`).
6.  **Checks the task's current status** by looking at its prefix using `.startsWith("[ ]")`.
7.  **Updates the task** using `tasks.set(index, newValue)`. It constructs the new value by taking the existing description (using `.substring(4)` to remove the old `"[ ] "` prefix) and adding the new `"[✓] "` prefix.
8.  **Robust Error Handling:** Uses a `try-catch` block to handle non-numeric input and provides clear feedback for all possible error cases.

### **3.8. The `deleteTask` Method**

```java
public static void deleteTask() {
    viewTasks(); // Show tasks first
    if (tasks.isEmpty()) return;

    System.out.print("Enter task number to delete: ");
    try {
        int index = Integer.parseInt(scanner.nextLine()) - 1;
        if (index >= 0 && index < tasks.size()) {
            tasks.remove(index);
            System.out.println("🗑️ Task deleted successfully!");
        } else {
            System.out.println("❌ Invalid task number.");
        }
    } catch (NumberFormatException e) {
        System.out.println("❌ Please enter a valid number.");
    }
}
```

- The logic is very similar to `markTaskAsCompleted`.
- The key difference is the use of **`tasks.remove(index)`** to delete the element at the specified position from the `ArrayList`.

---

## **4. How to Run the Application**

1.  **Prerequisites:** Ensure you have the Java Development Kit (JDK) installed on your system.
2.  **Save the Code:** Copy the code into a file named `TaskManager.java`.
3.  **Compile:** Open your terminal or command prompt, navigate to the directory containing the file, and run:
    ```bash
    javac TaskManager.java
    ```
    This will compile the code and generate a `TaskManager.class` file.
4.  **Run:** Execute the program with the following command:
    ```bash
    java TaskManager
    ```
5.  **Use the App:** Follow the on-screen menu prompts to manage your tasks!

package project2;

import static project2.Main.scanner;
import static project2.Main.tasks;

public class CrudTask {

    // Method to add a new task
    public static void addTask() {
        System.out.print("Enter the task: ");
        String task = scanner.nextLine().trim();

        if (!task.isEmpty()) {
            tasks.add("[ ] " + task); // [ ] means not completed
            System.out.println("✅ Task added successfully!");
        } else {
            System.out.println("❌ Task cannot be empty.");
        }
    }

    // Method to view all tasks
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

    // Method to mark a task as completed
    public static void markTaskAsCompleted() {
        viewTasks(); // Show tasks first
        if (tasks.isEmpty()) return;

        System.out.print("Enter task number to mark as completed: ");
        try {
            int index = Integer.parseInt(scanner.nextLine()) - 1;

            if (index >= 0 && index < tasks.size()) {
                String task = tasks.get(index);
                if (task.startsWith("[ ]")) {
                    tasks.set(index, "[✓] " + task.substring(4)); // Replace checkbox
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

    // Method to delete a task
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
}

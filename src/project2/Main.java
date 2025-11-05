package project2;

import java.util.ArrayList;
import java.util.Scanner;

import static project2.CrudTask.*;
import static project2.DisplayMenu.displayMenu;
import static project2.GetUserChoice.getUserChoice;

public class Main {

    // ArrayList to store tasks (we'll use Strings for simplicity)
    static final ArrayList<String> tasks = new ArrayList<>();
    static final Scanner scanner = new Scanner(System.in);




    // Main method - Entry poin1t of the app
    public static void main(String[] args) {
        System.out.println("Welcome to the Simple Task Manager!");

        while (true) {
            displayMenu();
            int choice = getUserChoice();

            switch (choice) {
                case 1:
                    addTask();
                    break;
                case 2:
                    viewTasks();
                    break;
                case 3:
                    markTaskAsCompleted();
                    break;
                case 4:
                    deleteTask();
                    break;
                case 5:
                    System.out.println("👋 Goodbye!");
                    return;
                default:
                    System.out.println("❌ Invalid option. Please try again.");
            }
        }
    }







}
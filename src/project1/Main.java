package project1;

import java.util.Scanner;

public class Main {

    private static final Scanner SCAN = new Scanner(System.in);
    private static int operationCount = 1;

    public static void main(String[] args) {
        boolean keepGoing = true;
        while (keepGoing) {
            String rawChoice = readMenuChoice();
            if (rawChoice.equalsIgnoreCase("q")) {
                keepGoing = false;
                continue;
            }
            int choice = Integer.parseInt(rawChoice);
            try {
                switch (choice) {
                    case 1 -> doAddition();
                    case 2 -> doSubtraction();
                    case 3 -> doMultiplication();
                    case 4 -> doDivision();
                    case 5 -> doSquare();
                    case 6 -> doSquareRoot();
                    default -> System.out.println("Unexpected choice.");
                }
            } catch (IllegalArgumentException | ArithmeticException ex) {
                System.out.println("Error: " + ex.getMessage());
            }
        }
        System.out.println("Good-bye!");
        SCAN.close();
    }

    /* ----------  menu ---------- */
    private static String readMenuChoice() {
        while (true) {
            System.out.println("""
                Advanced Calculator
                1. Addition
                2. Subtraction
                3. Multiplication
                4. Division
                5. Square
                6. Square Root""");
            System.out.print("Enter your choice (1-6 or q to quit): ");
            String line = SCAN.nextLine().trim();
            if (line.matches("[1-6qQ]")) return line;
            System.out.println("Invalid input – please enter 1-6 or q to quit.\n");
        }
    }

    /* ----------  result printer ---------- */
    private static void printResult(double value) {
        System.out.printf("[#%d]  Result: %.6g%n", operationCount++, value);
    }

    /* ----------  operations ---------- */
    private static void doAddition() {
        double[] nums = readDoubles("Enter numbers to add (separated by spaces): ");
        printResult(Operations.add(nums));
    }

    private static void doSubtraction() {
        double a = readDouble("Enter first number: ");
        double b = readDouble("Enter second number: ");
        printResult(Operations.subtract(a, b));
    }

    private static void doMultiplication() {
        double[] nums = readDoubles("Enter numbers to multiply (separated by spaces): ");
        printResult(Operations.multiply(nums));
    }

    private static void doDivision() {
        double a = readDouble("Enter first number: ");
        double b;
        while (true) {
            b = readDouble("Enter second number (non-zero): ");
            if (b != 0) break;
            System.out.println("Division by zero – try again.");
        }
        printResult(Operations.divide(a, b));
    }

    private static void doSquare() {
        double n = readDouble("Enter a number: ");
        printResult(Operations.square(n));
    }

    private static void doSquareRoot() {
        double n;
        while (true) {
            n = readDouble("Enter a non-negative number: ");
            if (n >= 0) break;
            System.out.println("Square root of negative – try again.");
        }
        printResult(Operations.squareRoot(n));
    }

    /* ----------  robust number readers ---------- */
    private static double readDouble(String prompt) {
        while (true) {
            System.out.print(prompt);
            String line = SCAN.nextLine().trim();
            try {
                return Double.parseDouble(line);
            } catch (NumberFormatException ex) {
                System.out.println("Invalid number – try again.");
            }
        }
    }

    private static double[] readDoubles(String prompt) {
        while (true) {
            System.out.print(prompt);
            String[] parts = SCAN.nextLine().trim().split("\\s+");
            try {
                double[] nums = new double[parts.length];
                for (int i = 0; i < parts.length; i++) {
                    nums[i] = Double.parseDouble(parts[i]);
                }
                return nums;
            } catch (NumberFormatException ex) {
                System.out.println("One or more entries are not valid numbers – try again.");
            }
        }
    }}
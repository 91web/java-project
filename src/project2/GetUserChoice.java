package project2;

import static project2.Main.scanner;

public class GetUserChoice {
    public static int getUserChoice() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1; // Invalid input
        }
    }
}

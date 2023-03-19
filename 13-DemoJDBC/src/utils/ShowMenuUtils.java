package utils;

import java.util.Scanner;

public class ShowMenuUtils {
    static Scanner sc = new Scanner(System.in);
    public int getChoice() {
        while (true) {
            System.out.println("\n----------- GROUP CRUD ACTION -----------");
            System.out.println("0. Exit the program!");
            System.out.println("1. Add new Group");
            System.out.println("2. Update Group");
            System.out.println("3. Delete Group");
            System.out.println("4. Show Group Information");
            System.out.println("5. Drop the table");
            System.out.println("6. Rename the table");
            System.out.println("7. Create new table");
            System.out.println("8. Not available");
            System.out.println("9. Not available");
            System.out.print("Your choice (0 → 9): ");
            try {
                String input = sc.next();
                int choice = Integer.parseInt(input);
                if (choice < 0 || choice > 9) {
                    throw new Exception();
                } else {
                    return choice;
                }
            } catch (Exception e) {
                System.out.println("Invalid choice! Try again....");
            }
        }
    }
}

package java_systechtraining;

import java.util.Scanner;


public class calc {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("===Simple Calculator===");
            System.out.println("1. Addition (+)");
            System.out.println("2. Subtraction (-)");
            System.out.println("3. Multiplication (*)");
            System.out.println("4. Division (/)");
            System.out.println("5. Exit");
            System.out.println("=======================");

            int num1, num2;
            int choice;

            System.out.print("Enter first number: ");
            num1 = scanner.nextInt();

            System.out.print("Enter second number: ");
            num2 = scanner.nextInt();

            System.out.print("Enter your choice (1-5): ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Result: " + num1 + " + " + num2 + " = " + (num1 + num2));
                    break;

                case 2:
                    System.out.println("Result: " + num1 + " - " + num2 + " = " + (num1 - num2));
                    break;

                case 3:
                    System.out.println("Result: " + num1 + " * " + num2 + " = " + (num1 * num2));
                    break;

                case 4:
                    if (num2 != 0) {
                        System.out.println("Result: " + num1 + " / " + num2 + " = " + (num1 / num2));
                    } else {
                        System.out.println("Error: Division by zero");
                    }
                case 5:
                    System.out.println("Exiting the calculator. Goodbye!");
                    System.exit(0);

                    break;

                default:
                    System.out.println("Invalid choice! Please select a valid operation.");
                    break;
            }

            System.out.println("Would you like to perform another calculation? (yes/no): ");
            scanner.nextLine(); // Consume newline
            String again = scanner.nextLine().trim().toLowerCase();
            if (!again.equals("yes")) {
                System.out.println("Exiting the calculator. Goodbye!");
                break;
            }
            System.out.println();

        }
        scanner.close();
    }
}
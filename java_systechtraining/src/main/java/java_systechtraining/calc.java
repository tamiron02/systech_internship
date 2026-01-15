package java_systechtraining;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class calc {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num1, num2;
        System.out.print("Enter first number: ");
        num1 = scanner.nextInt();

        System.out.print("Enter second number: ");
        num2 = scanner.nextInt();

        System.out.print("Enter an operator (+, -, *, /): ");
        char operator = scanner.next().charAt(0);

        switch (operator) {
            case '+':
                System.out.println("Sum: " + (num1 + num2));
                break;

            case '-':
                System.out.println("Difference: " + (num1 - num2));
                break;

            case '*':
                System.out.println("Product: " + (num1 * num2));
                break;

            case '/':
                if (num2 != 0) {
                    System.out.println("Quotient: " + (num1 / num2));
                } else {
                    System.out.println("Error: Division by zero");
                }
                break;

            default:
                break;
        }

        scanner.close();
    }
}
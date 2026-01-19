// Created by Christine Tamiron Kipchumba

package java_systechtraining.Assessment;

import java.util.Scanner;

public class Assessment1_ChristineTamiron {

    private Scanner scanner = new Scanner(System.in);

    // quiz problem 1
    public static void main(String[] args) {

        // Calling quiz problem 1
        Assessment1_ChristineTamiron quiz1 = new Assessment1_ChristineTamiron();
        quiz1.quiz_problem_1();

        // Calling quiz problem 2
        quiz1.grade_calculator();

        // Calling quiz problem 3
        quiz1.number_sequence();

        // Calling quiz problem 4
        quiz1.input_validation();

        // Calling quiz problem 5
        quiz1.pattern_printing();

        quiz1.scanner.close();
    }

    // Quiz problem 1
    public void quiz_problem_1() {
        // variable declaration
        int a = 15, b = 4, c = 7;
        // sum
        int sum = a + b + c;
        // product
        int product = a * b;
        // expression
        int expression = (a + b) * c;
        // modulus
        int remainder = a % b;

        System.out.println("---------- Quiz Problem 1 -----------");
        System.out.println("Sum: " + (sum));
        System.out.println("Product: " + (product));
        System.out.println("Expression Result: " + (expression));
        System.out.println("Remainder: " + (remainder));
        System.out.println("***************************************");
    }

    // Quiz 2 problem 2
    public void grade_calculator() {
        System.out.println("---------- Quiz Problem 2 -----------");
        System.out.print("Enter student score : ");
        int score = scanner.nextInt();

        if (score >= 90 && score <= 100) {
            System.out.println("Grade: A");
        } else if (score >= 80 && score < 90) {
            System.out.println("Grade: B");
        } else if (score >= 70 && score < 80) {
            System.out.println("Grade: C");
        } else if (score >= 60 && score < 70) {
            System.out.println("Grade: D");
        } else if (score < 60 && score >= 0) {
            System.out.println("Grade: F");
        } else {
            System.out.println("Error: Score must be between 0 and 100");
        }

        System.out.println("***************************************");
    }

    // quiz problem 3
    public void number_sequence() {
        System.out.println("---------- Quiz Problem 3 -----------");
        for (int i = 1; i <= 20; i++) {
            if (i % 5 == 0 && i % 2 != 0) {
                System.out.print("\n" + i + " - Multiple Of 5, Odd");
            } else if (i % 5 == 0 && i % 2 == 0) {
                System.out.print("\n" + i + " - Multiple Of 5, Even");
            } else if (i % 2 == 0) {
                System.out.print("\n" + i + " - Even");
            } else {
                System.out.print("\n" + i + " - Odd");
            }
        }
        System.out.println("\n***************************************");
    }

    public void input_validation() {
        System.out.println("---------- Quiz Problem 4 -----------");
        System.out.print("Enter a positive integer: ");
        int number = scanner.nextInt();

        while (number <= 0) {
            System.out.print("Invalid input. Please enter a positive integer: ");
            number = this.scanner.nextInt();
        }

        // Calculate factorial
        long factorial = 1;
        for (int i = 1; i <= number; i++) {
            factorial *= i;
        }
        System.out.println("Factorial of " + number + " is: " + factorial);
        System.out.println("***************************************");
    }

    // int result;
    // if (number <= 1) {
    // result = 1;
    // } else {
    // result = number * input_validation(scanner, number - 1);
    // }
    // return result;
    // }

    // quiz problem 5
    public void pattern_printing() {
        System.out.println("---------- Quiz Problem 5 -----------");
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        System.out.println("***************************************");
    }

}

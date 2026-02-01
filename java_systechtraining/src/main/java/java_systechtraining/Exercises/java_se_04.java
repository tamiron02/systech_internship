package java_systechtraining.Exercises;

import java.util.Scanner;

public class java_se_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter number:");
        int number = scanner.nextInt();
        System.out.println("Multiplication Table for " + number + ":");
        for(int i = 1; i <= 10; i++) {
            System.out.println(number + " x " + i + " = " + (number * i));
        }
        scanner.close();
    }
    
}

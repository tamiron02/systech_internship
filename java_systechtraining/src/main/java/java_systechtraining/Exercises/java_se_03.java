package java_systechtraining.Exercises;

import java.util.Scanner;

public class java_se_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Age:");
        int age = scanner.nextInt();
        

        if( age <= 2){
             System.out.println("Category: Infant");
        } else if (age <= 12) {
            System.out.println("Category: Child");
        }else if (age <= 19) {
            System.out.println("Category: Teenager");
        }else if (age <= 64) {
            System.out.println("Category: Adult");

        }else if (age >= 65) {
            System.out.println("Category: Senior");

        }else {
            System.out.println("Invalid age");


    
} 
        trafficLight();
    }

    public static void trafficLight() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter traffic light color (red, yellow, green): ");
        String color = scanner.nextLine().trim().toLowerCase();

        switch (color) {
            case "red":
                System.out.println("Action: Stop");
                break;
            case "yellow":
                System.out.println("Action: Caution");
                break;
            case "green":
                System.out.println("Action: Go");
                break;
            case "blinkingRed":
                System.out.println("Treat as a stop sign");
                break;

            case "blinkingYellow":
                System.out.println("Proceed with caution");
                break;


            default:
                System.out.println("Invalid color! Please enter red, yellow, or green.");
                break;
        }

        scanner.close();
    }
}
package java_systechtraining.Exercises;

import java.util.Scanner;

public class java_se_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Fisrt Number:");
        double num1 = scanner.nextDouble();

        System.out.println("Enter Second Number:");
        double num2 = scanner.nextDouble();

        double sum = num1 + num2;
        System.out.println(num1 + "+" + num2 + "=" + sum);

        double subtract = num1 - num2;
        System.out.println(num1 + "-" + num2 + "=" + subtract);

        double multiply = num1 * num2;
        System.out.println(num1 + "*" + num2 + "=" + multiply);

        double divide = num1 / num2;
        System.out.println(num1 + "/" + num2 + "=" + divide);

        double modulus = num1 % num2;
        System.out.println(num1 + "%" + num2 + "=" + modulus);


        studentDetails();

        
    }

    //*************** Prc 2 ***************//

    public static void studentDetails() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Student Details ===");

        String name = scanner.nextLine();
        System.out.println("Name: " + name);

        int age = scanner.nextInt();
        System.out.println("Age: " + age);

        char grade = scanner.next().charAt(0);
        System.out.println("Grade: " + grade);
       
        double GPA = scanner.nextDouble();
        System.out.println("GPA: " + GPA);    
        
        boolean isGraduating = scanner.nextBoolean();
        System.out.println("Is Graduating: " + isGraduating);   

        scanner.close();
    }
}

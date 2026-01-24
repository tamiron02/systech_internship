// Created by Christine Tamiron

1. What is the difference between method overloading and method overriding? 

Method overloading occurs when there's multiple methods in the same name but have diferent numbers of parameters while method overriding is using a method from the parent class in the child class with the same signature and return type 

Overloading example

 public int add(int a, int b) {
        return a + b;
    }

    public double add(double a, double b) {
        return a + b;
    }

public static void main(String[] args) {
        Calculator calc = new Calculator();
        System.out.println("add(int, int): " + calc.add(2, 3));
        System.out.println("add(double, double): " + calc.add(2.5, 3.5));
}

Overriding example

// Parent class
class Calculator {

    // Method to sum two integers
    int my_Sum(int a, int b){

        System.out.println("Parent class sum method:");
        return a + b;
    }
}

// Child class
class ScientificCalculator extends Calculator{

    // Overriding the my_Sum method
    @Override int my_Sum(int a, int b){

        System.out.println(
            "Child class overridden sum method:");
        // Adding custom behavior
        return a + b
           
    }
}

2. Why should fields be declared private in a class?
Fields should be declared private to restrict the visibilty of fields,methods, and constructing to the defining class.

Example
public class Person {
    private String name;
}

 3. When should you use the super keyword?
 The super keyword should be used during inheritance to accesses parent class members and constructors.

 Example
 // Base class vehicle
class Vehicle {
    int maxSpeed = 120;
}

// sub class Car extending vehicle
class Car extends Vehicle {
    int maxSpeed = 180;

    void display()
    {
        // print maxSpeed from the vehicle class 
        // using super
        System.out.println("Maximum Speed: "
                           + super.maxSpeed);
    }
}

4.  What is the purpose of the @Override annotation?
The @Override annotation indicates that the child class method overrides its parent class method

Example
// Class 1
// Helper  class
public class Vehicle {

    // Calling this method
    public  void method();
}

// Class 2
// Helper class
class Car extends Vehicle {

    // @Override
    // Method of Car class
    public void method()
    {

        // Print statement whenever this method is called
        System.out.println("This is Car");
    }
}

5. How does encapsulation improve code maintainability?
It  organizes and protects how data and behavior are accessed and modified within a program and the internal working of a class or module are hidden from outside code.

Example
public class BankAccount {
    private double balance; // Encapsulated data

    // Public method to deposit money
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    // Public method to get balance
    public double getBalance() {
        return balance;
    }
}

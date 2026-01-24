//Created by Christine Tamiron

package java_systechtraining.Assessments.Assessment2_ChristineTamiron;

public class Calculator {

    // Method overloading (instance methods for inheritance demo)
    public int add(int a, int b) {
        return a + b;
    }

    public double add(double a, double b) {
        return a + b;
    }

    public int add(int a, int b, int c) {
        return a + b + c;
    }

    public String add(String a, String b) {
        return a + b;
    }

    public static void main(String[] args) {
        Calculator calc = new Calculator();
        System.out.println("add(int, int): " + calc.add(2, 3));
        System.out.println("add(double, double): " + calc.add(2.5, 3.5));
        System.out.println("add(int, int, int): " + calc.add(1, 2, 3));
        System.out.println("add(String, String): " + calc.add("I'm ", "Tired!"));

        ScientificCalculator scalc = new ScientificCalculator();
        System.out.println("\nUsing ScientificCalculator:");
        System.out.println("add(int, int) with log: " + scalc.add(5, 7));
        System.out.println("power(2, 3): " + scalc.power(2, 3));
        System.out.println("squareRoot(16): " + scalc.squareRoot(16));

        
    }
}

class ScientificCalculator extends Calculator {
    // Overriding
    @Override
    public int add(int a, int b) {
        System.out.println("[LOG] ScientificCalculator: Adding two integers");
        return super.add(a, b);
    }

    // New methods
    public double power(double base, double exponent) {
        return Math.pow(base, exponent);
    }

    public double squareRoot(double num) {
        return Math.sqrt(num);
    }
}

package java_systechtraining.Exercises;



public class java_se_06 {

    public int add(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b){
        return a - b;
    }

    public int multiply(int a, int b){
        return a * b;
    }

    public int divide(int a, int b){
        if(b == 0){
            System.out.println("Error: Division by zero");
            return 0;
        }
        return a / b;
    }

    public static void main(String[] args) {
        System.out.println("Addition: 5 + 3 = " + new java_se_06().add(5, 3));
        System.out.println("Subtraction: 5 - 3 = " + new java_se_06().subtract(5, 3));
        System.out.println("Multiplication: 5 * 3 = " + new java_se_06().multiply(5, 3));
        System.out.println("Division: 5/ 3 = " + new java_se_06().divide(5, 3));

        //Test temperature converter
        System.out.println("20C = " + celsiusToFahrenheit(20) + "F");
        System.out.println("68F = " + fahrenheitToCelsius(68) + "C");

        //print table
        printTemperatureTable();
    }

//temperature converter

    public static double celsiusToFahrenheit(double celsius) {
        return (celsius * 9/5) + 32;
    }

    public static double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5/9;
    }

    public static double celciousToFarenheit(int celsius) {
        return (celsius * 9/5) + 32;
    }

    public static void printTemperatureTable() {
        System.out.println("\nTemperature conversion table");
        System.out.println("C\tF");
        for (int celsius = 0; celsius <= 100; celsius += 10) {
            double f = celsiusToFahrenheit(celsius);
            System.out.printf("%d\t%.1f%n", celsius, f);
        }

        

    }

    
}
package java_systechtraining.Assessments.Assessment3_ChristineKipchumba.Problem3;

public class EcommerceTest {
    
    public static void main(String[] args) {
        try {
            Product laptop = new Electronics("E001", "Laptop", -999.99, 10); // Valid price
            laptop.reduceStock(15); // More than available stock
        } catch (InvalidProductException | OutOfStockException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

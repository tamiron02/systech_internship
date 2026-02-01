package java_systechtraining.Assessments.Assessment3_ChristineKipchumba.Problem3;

public class Electronics extends Product {
    private int warrantyPeriod;
    private int powerConsumption;

    public Electronics(String productId, String name, double price, int stockQuantity)
            throws InvalidProductException {
        super(productId, name, price, stockQuantity);
        // Example default values
        this.warrantyPeriod = 12;
        this.powerConsumption = 100;
    }

    @Override
    public double calculateDiscount() {
        return price * 0.10; // 10% discount
    }

    @Override
    public String getProductType() {
        return "Electronics";
    }
}

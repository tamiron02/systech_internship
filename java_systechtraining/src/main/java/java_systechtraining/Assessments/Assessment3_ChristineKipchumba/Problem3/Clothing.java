package java_systechtraining.Assessments.Assessment3_ChristineKipchumba.Problem3;

public class Clothing extends Product {
    private String size;
    private String material;
    private String color;

    public Clothing(String productId, String name, double price, int stockQuantity)
            throws InvalidProductException {
        super(productId, name, price, stockQuantity);
        // Example default values
        this.size = "M";
        this.material = "Cotton";
        this.color = "Blue";
    }

    @Override
    public double calculateDiscount() {
        return price * 0.15; // 15% discount
    }

    @Override
    public String getProductType() {
        return "Clothing";
    }
}

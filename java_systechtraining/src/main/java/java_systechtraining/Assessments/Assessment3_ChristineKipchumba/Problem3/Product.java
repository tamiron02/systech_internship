package java_systechtraining.Assessments.Assessment3_ChristineKipchumba.Problem3;

 public abstract class Product {
    protected String productId;
    protected String name;
    protected double price;
    protected int stockQuantity;

    public Product(String productId, String name, double price, int stockQuantity) throws InvalidProductException {
        if (productId == null || productId.isEmpty()) {
            throw new InvalidProductException("Product ID cannot be empty.");
        }
        if (name == null || name.isEmpty()) {
            throw new InvalidProductException("Product name cannot be empty.");
        }
        if (price < 0) {
            throw new InvalidProductException("Price cannot be negative.");
        }
        if (stockQuantity < 0) {
            throw new InvalidProductException("Stock quantity cannot be negative.");
        }
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.stockQuantity = stockQuantity;
    }

    public abstract double calculateDiscount();
    public abstract String getProductType();

    public void applyTax(double taxRate) {
        price += price * taxRate;
    }

    public void displayProductInfo() {
        System.out.println("ID: " + productId + ", Name: " + name + ", Price: " + price + ", Stock: " + stockQuantity);
    }

    public void reduceStock(int quantity) throws OutOfStockException {
        if (quantity > stockQuantity) {
            throw new OutOfStockException("Not enough stock available.");
        }
        stockQuantity -= quantity;
    }
}   


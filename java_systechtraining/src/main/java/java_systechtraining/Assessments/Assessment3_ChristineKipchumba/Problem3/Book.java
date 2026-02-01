package java_systechtraining.Assessments.Assessment3_ChristineKipchumba.Problem3;

public class Book extends Product {
    private String author;
    private String publisher;
    private String isbn;

    public Book(String productId, String name, double price, int stockQuantity)
            throws InvalidProductException {
        super(productId, name, price, stockQuantity);
        // Example default values
        this.author = "Unknown";
        this.publisher = "Unknown";
        this.isbn = "0000000000";
    }

    @Override
    public double calculateDiscount() {
        return price * 0.05; // 5% discount
    }

    @Override
    public String getProductType() {
        return "Book";
    }
}

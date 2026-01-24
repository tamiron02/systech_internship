//Created by Christine Tamiron

//QUIZ 1: Class design and encapsulation

package java_systechtraining.Assessments.Assessment2_ChristineTamiron;

public class Book {
    private String title;
    private String author;
    private String isbn;
    private double price;
    private boolean isAvailable;

    // Constructor
    public Book(String title, String author, String isbn, double price, boolean isAvailable) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.price = price;
        this.isAvailable = isAvailable;
    }

    // Getters and Setters
    public String getTitle() {
       
        return title;
        
    }

    public void setTitle(String title) {
         if (title == null || title.isEmpty()) {
            throw new IllegalArgumentException("Title cannot be null or empty");
        } else {
        this.title = title;
        }
    }

    public String getAuthor() {
       
        return author;
        
    }

    public void setAuthor(String author) {
        if (author == null || author.isEmpty()) {
            throw new IllegalArgumentException("Author cannot be null or empty");
        } else {
        this.author = author;
        }
    }

    public String getIsbn() {
        
        return isbn;
    }

    public void setIsbn(String isbn) {
        if (isbn == null || !isbn.matches("\\d{13}")) {
            throw new IllegalArgumentException("ISBN must be exactly 13 digits");
        }
        this.isbn = isbn;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price < 0) {
            throw new IllegalArgumentException("Price cannot be negative");
        } else {
        this.price = price;
        }
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", isbn='" + isbn + '\'' +
                ", price=" + price +
                ", isAvailable=" + isAvailable +
                '}';
    }
    // Borrow the book if available
    public void borrowBook() {
        if (!isAvailable) {
            throw new IllegalStateException("Book is not available to borrow");
        } else {
            System.out.println("You have borrowed the book: " + title);
            isAvailable = false;
        }
       
    }

    // Return the book if not already available
    public void returnBook() {
        if (isAvailable) {
            throw new IllegalStateException("Book is already available");
        } else {
            System.out.println("You have returned the book: " + title);
        }       
        isAvailable = true;
    }

    public static void main(String[] args) {
        Book book1 = new Book("Effective Java", "Joshua Bloch", "9780134686097", 45.00, true);
        Book book2 = new Book("Clean Code", "Robert C. Martin", "9780132350884", 40.00, false);

        book1.borrowBook();
        
        book2.returnBook();
        
    }

}

package java_systechtraining.Assessments.Assessment3_ChristineKipchumba.Problem1;

public class Book extends LibraryItem {
    private String isbn;
    private String genre;

    public Book(String itemId, String title, String author, String isbn, String genre) {
        super(itemId, title, author);
        this.isbn = isbn;
        this.genre = genre;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("ISBN: " + isbn);
        System.out.println("Genre: " + genre);
    }
}

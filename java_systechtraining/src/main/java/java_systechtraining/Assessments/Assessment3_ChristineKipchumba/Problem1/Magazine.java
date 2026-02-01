package java_systechtraining.Assessments.Assessment3_ChristineKipchumba.Problem1;

import java.time.LocalDate;

public class Magazine extends LibraryItem {
    private int issueNumber;
    private LocalDate publicationDate;

    public Magazine(String itemId, String title, String author, int issueNumber, LocalDate publicationDate) {
        super(itemId, title, author);
        this.issueNumber = issueNumber;
        this.publicationDate = publicationDate;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Issue Number: " + issueNumber);
        System.out.println("Publication Date: " + publicationDate);
    }
}

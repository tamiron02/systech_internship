package java_systechtraining.Assessments.Assessment3_ChristineKipchumba.Problem1;

public class DVD extends LibraryItem {
    private int duration; // in minutes
    private String rating;

    public DVD(String itemId, String title, String author, int duration, String rating) {
        super(itemId, title, author);
        this.duration = duration;
        this.rating = rating;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Duration: " + duration + " minutes");
        System.out.println("Rating: " + rating);
    }
}

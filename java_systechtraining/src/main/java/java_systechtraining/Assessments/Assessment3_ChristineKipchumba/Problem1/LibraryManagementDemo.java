package java_systechtraining.Assessments.Assessment3_ChristineKipchumba.Problem1;

import java.time.LocalDate;

public class LibraryManagementDemo {
    public static void main(String[] args) {
        LibraryItem[] items = {
            new Book("B001", "Java Programming", "John Doe", "123-4567890123", "Education"),
            new DVD("D001", "Java Tutorial", "Jane Smith", 120, "PG"),
            new Magazine("M001", "Tech Monthly", "Tech Press", 15, LocalDate.of(2024, 3, 1))
        };

        for (LibraryItem item : items) {
            item.displayDetails();
            item.checkout();
            System.out.println();
        }
    }
}

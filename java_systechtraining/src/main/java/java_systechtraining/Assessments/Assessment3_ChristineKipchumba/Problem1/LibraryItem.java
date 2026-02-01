package java_systechtraining.Assessments.Assessment3_ChristineKipchumba.Problem1;

public class LibraryItem {
	private String itemId;
	private String title;
	private String author;
	private boolean isAvailable;

	public LibraryItem(String itemId, String title, String author) {
		this.itemId = itemId;
		this.title = title;
		this.author = author;
		this.isAvailable = true;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public void checkout() {
		if (isAvailable) {
			isAvailable = false;
			System.out.println(title + " checked out successfully.");
		} else {
			System.out.println(title + " is not available for checkout.");
		}
	}

	public void returnItem() {
		if (!isAvailable) {
			isAvailable = true;
			System.out.println(title + " returned successfully.");
		} else {
			System.out.println(title + " was not checked out.");
		}
	}

	public void displayDetails() {
		System.out.println("Item ID: " + itemId);
		System.out.println("Title: " + title);
		System.out.println("Author: " + author);
		System.out.println("Available: " + (isAvailable ? "Yes" : "No"));
	}
}

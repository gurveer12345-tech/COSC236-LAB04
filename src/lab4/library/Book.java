package lab4.library;

public class Book {

    // GRASP Principle: Information Expert

    // Attributes
    private String title;
    private String author;
    private boolean isAvailable;

    // Constructor
    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.isAvailable = true;
    }

    // Getters
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    // Borrow the book
    public boolean borrow() {
        if (isAvailable) {
            isAvailable = false;
            return true;
        }
        return false;
    }

    // Return the book
    public void returnBook() {
        isAvailable = true;
    }

    // Display book information
    @Override
    public String toString() {
        return title + " by " + author +
                " (Available: " + isAvailable + ")";
    }
}

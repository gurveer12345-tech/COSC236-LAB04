package lab4.library;

import java.util.ArrayList;

public class Member {

    // GRASP Principles: Information Expert and Low Coupling

    // Attributes
    private String memberId;
    private String name;
    private ArrayList<Book> borrowedBooks;

    // Constructor
    public Member(String memberId, String name) {
        this.memberId = memberId;
        this.name = name;
        this.borrowedBooks = new ArrayList<>();
    }

    // Getters
    public String getMemberId() {
        return memberId;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Book> getBorrowedBooks() {
        return new ArrayList<>(borrowedBooks);
    }

    // Borrow a book
    public boolean borrowBook(Book book) {

        if (book != null && book.borrow()) {
            borrowedBooks.add(book);
            return true;
        }

        return false;
    }

    // Return a book
    public boolean returnBook(Book book) {

        if (book != null && borrowedBooks.contains(book)) {
            book.returnBook();
            borrowedBooks.remove(book);
            return true;
        }

        return false;
    }

    // Display borrowed books
    public void showBorrowedBooks() {

        System.out.println(name + "'s borrowed books:");

        if (borrowedBooks.isEmpty()) {
            System.out.println("No books borrowed.");
        } else {
            for (Book book : borrowedBooks) {
                System.out.println(book.getTitle());
            }
        }
    }

    // Display member information
    @Override
    public String toString() {
        return "Member ID: " + memberId + ", Name: " + name;
    }
}

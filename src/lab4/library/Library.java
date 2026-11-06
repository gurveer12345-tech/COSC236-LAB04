
package lab4.library;

import java.util.ArrayList;
import java.util.List;

public class Library {

    // GRASP Principles: Creator and Controller

    // Attributes
    private final ArrayList<Book> catalog;
    private final ArrayList<Member> members;

    // Constructor
    public Library() {
        catalog = new ArrayList<>();
        members = new ArrayList<>();
    }

    // Add a book to the catalog
    public void addBook(Book book) {
        if (book != null) {
            catalog.add(book);
            System.out.println(book.getTitle() + " added to the library.");
        }
    }

    // Register a new member
    public void registerMember(Member member) {
        if (member != null) {
            members.add(member);
            System.out.println(member.getName() + " registered successfully.");
        }
    }

    // Get all books in the catalog
    public List<Book> getCatalog() {
        return new ArrayList<>(catalog);
    }

    // Get all registered members
    public List<Member> getMembers() {
        return new ArrayList<>(members);
    }

    // Find a book by its title
    public Book findBookByTitle(String title) {

        if (title == null) {
            return null;
        }

        for (Book book : catalog) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }

        return null;
    }

    // Find a member by their name
    public Member findMemberByName(String name) {

        if (name == null) {
            return null;
        }

        for (Member member : members) {
            if (member.getName().equalsIgnoreCase(name)) {
                return member;
            }
        }

        return null;
    }

    // Remove a book from the catalog
    public boolean removeBook(String title) {

        Book book = findBookByTitle(title);

        if (book == null) {
            System.out.println("Book not found: " + title);
            return false;
        }

        if (!book.isAvailable()) {
            System.out.println("Cannot remove " + title +
                    " because it is currently borrowed.");
            return false;
        }

        catalog.remove(book);

        System.out.println(title + " removed from the library.");
        return true;
    }

    // Remove a member from the library
    public boolean removeMember(String name) {

        Member member = findMemberByName(name);

        if (member == null) {
            System.out.println("Member not found: " + name);
            return false;
        }

        if (!member.getBorrowedBooks().isEmpty()) {
            System.out.println("Cannot remove " + name +
                    " because they still have borrowed books.");
            return false;
        }

        members.remove(member);

        System.out.println(name + " removed from the library.");
        return true;
    }
}

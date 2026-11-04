
package lab4.library;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Library {

    // Stores the books and members belonging to the library
    private List<Book> catalog;
    private List<Member> members;y
    // Constructor initializes the library collections
    public Library() {
        catalog = new ArrayList<>();
        members = new ArrayList<>();
    }

    // CREATOR: Adds a Book object to the library catalog
    public void addBook(Book book) {
        if (book != null) {
            catalog.add(book);
            System.out.println("Book added: " + book.getTitle());
        }
    }

    // Removes an available book from the catalog
    public boolean removeBook(String title) {
        Book book = findBookByTitle(title);

        if (book != null && book.isAvailable()) {
            catalog.remove(book);
            System.out.println("Book removed: " + title);
            return true;
        }

        System.out.println("Book could not be removed.");
        return false;
    }

    // CREATOR: Registers a Member object with the library
    public void registerMember(Member member) {
        if (member != null) {
            members.add(member);
            System.out.println("Member registered: " + member.getName());
        }
    }

    // Removes a member who has no borrowed books
    public boolean removeMember(String name) {
        Member member = findMemberByName(name);

        if (member != null && member.getBorrowedBooks().isEmpty()) {
            members.remove(member);
            System.out.println("Member removed: " + name);
            return true;
        }

        System.out.println("Member could not be removed.");
        return false;
    }

    // INFORMATION EXPERT: Finds a book by its title
    public Book findBookByTitle(String title) {
        for (Book book : catalog) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }

        return null;
    }

    // INFORMATION EXPERT: Finds a member by name
    public Member findMemberByName(String name) {
        for (Member member : members) {
            if (member.getName().equalsIgnoreCase(name)) {
                return member;
            }
        }

        return null;
    }

    // Returns the catalog without exposing the internal list
    public List<Book> getCatalog() {
        return Collections.unmodifiableList(catalog);
    }

    // Returns the members without exposing the internal list
    public List<Member> getMembers() {
        return Collections.unmodifiableList(members);
    }
}

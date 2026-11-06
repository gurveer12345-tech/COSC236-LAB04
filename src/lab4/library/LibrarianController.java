package lab4.library;

public class LibrarianController {

    private final Library library;

    public LibrarianController(Library library) {
        this.library = library;
    }

    // Handles a borrow request and delegates work to Member and Book.
    // Parameter order matches LibraryApp: bookTitle, memberName.
    public void borrowBook(String bookTitle, String memberName) {
        Book book = library.findBookByTitle(bookTitle);
        Member member = library.findMemberByName(memberName);

        if (book == null) {
            System.out.println("Book not found: " + bookTitle);
            return;
        }

        if (member == null) {
            System.out.println("Member not found: " + memberName);
            return;
        }

        if (!book.isAvailable()) {
            System.out.println(bookTitle + " is not available.");
            return;
        }

        // Book and Member update their own state.
       member.borrowBook(book);

        System.out.println(memberName + " successfully borrowed " + bookTitle);
    }

    // Handles a return request and delegates work to Member and Book.
    public void returnBook(String bookTitle, String memberName) {
        Book book = library.findBookByTitle(bookTitle);
        Member member = library.findMemberByName(memberName);

        if (book == null) {
            System.out.println("Book not found: " + bookTitle);
            return;
        }

        if (member == null) {
            System.out.println("Member not found: " + memberName);
            return;
        }

        if (!member.getBorrowedBooks().contains(book)) {
            System.out.println(memberName + " did not borrow " + bookTitle);
            return;
        }

        member.returnBook(book);

        System.out.println(memberName + " successfully returned " + bookTitle);
    }
}

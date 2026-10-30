package lab4.library;
//Simplified verion of Library Management System

import java.util.List;


public class LibraryApp {
	private static void displayCatalog(Library library) {
	        System.out.println("\n--- Library Catalog ---");

	        List<Book> books = library.getCatalog();

	        if (books.isEmpty()) {
	            System.out.println("The catalog is empty.");
	            return;
	        }

	        for (Book book : books) {
	            String status = book.isAvailable()
	                    ? "Available" : "Borrowed";

	            System.out.printf("- %s by %s [%s]%n",
	                    book.getTitle(),
	                    book.getAuthor(),
	                    status);
	        }
	    }
	 
	 private static void displayMembers(Library library) {
	        System.out.println("\n--- Registered Members ---");

	        List<Member> members = library.getMembers();

	        if (members.isEmpty()) {
	            System.out.println("There are no registered members.");
	            return;
	        }

	        for (Member member : members) {
	            System.out.printf("- %s (ID: %s)%n",
	                    member.getName(),
	                    member.getMemberId());

	            List<Book> borrowedBooks = member.getBorrowedBooks();

	            if (borrowedBooks.isEmpty()) {
	                System.out.println("    Borrowed books: none");
	            } else {
	                System.out.println("    Borrowed books:");

	                for (Book book : borrowedBooks) {
	                    System.out.println("      * " + book.getTitle());
	                }
	            }
	        }
	    }
	 
	 private static void lookupBook(Library library, String title) {
	        System.out.println("\n--- Looking up book: " + title + " ---");

	        Book book = library.findBookByTitle(title);

	        if (book == null) {
	            System.out.println("Book not found: " + title);
	        } else {
	            String status = book.isAvailable()
	                    ? "Available" : "Borrowed";

	            System.out.printf("Found: %s by %s. Status: %s.%n",
	                    book.getTitle(),
	                    book.getAuthor(),
	                    status);
	        }
	    }
	 
	    private static void lookupMember(Library library, String name) {
	        System.out.println("\n--- Looking up member: " + name + " ---");

	        Member member = library.findMemberByName(name);

	        if (member == null) {
	            System.out.println("Member not found: " + name);
	        } else {
	            System.out.printf("Found member: %s (ID: %s).%n",
	                    member.getName(),
	                    member.getMemberId());
	        }
	    }
  
public static void main(String[] args) {
	
	 Library library = new Library();
	 LibrarianController controller = new LibrarianController(library);

	 System.out.println(" *** Library management system demo *** ");
	 
    // Adding some books to the catalog
	System.out.println("\n *** Adding \"Dune\" to the library:");
	library.addBook(new Book("Dune","Frank Herbert"));
	
	System.out.println("\n *** Adding \"1984\" to the library:");
	library.addBook(new Book("1984","George Orwell")); 
	
	System.out.println("\n *** Adding \"Moby Dick\" to the library:");
    library.addBook(new Book("Moby Dick","Herman Melville"));

    // Show available books
    System.out.println("\n *** Show all books:");
    displayCatalog(library);
    
    // Adding members
    System.out.println("\n *** Adding \"Alice\" to the library members");
    library.registerMember(new Member("M001", "Alice"));
    
    System.out.println("\n *** Adding \"Bob\" to the library members");
    library.registerMember(new Member("M002", "Bob"));

    // Show members
    System.out.println("\n *** Show all members");

    displayMembers(library);
    lookupBook(library, "1984");
    lookupMember(library, "Alice");
    // Borrow a book
    System.out.println("\n *** Alice borrows Dune:");
    controller.borrowBook("Dune", "Alice");

    // Show available books after borrowing
    System.out.println("\n *** Show all books:");
    
    displayCatalog(library);

    System.out.println("\n *** Bob borrows 1984:");
    controller.borrowBook("1984", "Bob");
    
    // Show available books after borrowing
    System.out.println("\n *** Show all books:");

    displayCatalog(library);
    
    System.out.println("\nBob borrows Dune:");
    controller.borrowBook("Dune", "Bob");
    // Show available books after borrowing
    System.out.println("\n *** Show all books:");
    displayCatalog(library);
    
    // Return a book
    System.out.println("\n *** Alice returns Dune:");
    controller.returnBook("Dune", "Alice");

    // Show available books after returning
    System.out.println("\n *** Show all books:");
    displayCatalog(library);

    System.out.println("\n *** Bob borrows Dune:") ;
    controller.borrowBook("Dune", "Bob");
    
    // Show available books after borrowing
    System.out.println("\n *** Show all books:");
    displayCatalog(library);
    displayMembers(library);
    
    System.out.println("\nBob returns Dune:");
    controller.returnBook("Dune", "Bob");

    System.out.println("\nBob returns 1984:");
    controller.returnBook("1984", "Bob");

    displayCatalog(library);
    displayMembers(library);
    
    System.out.println("\n=== Removing a Book and a Member ===");

    System.out.println("Removing Moby Dick:");
    library.removeBook("Moby Dick");

    System.out.println("\nRemoving Bob:");
    library.removeMember("Bob");

    // 8. Display the final state.
    System.out.println("\n=== Final Library State ===");

    displayCatalog(library);
    displayMembers(library);

    System.out.println("\n=== Demo Complete ===");

	}
}
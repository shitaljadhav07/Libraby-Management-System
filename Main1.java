import java.util.*;

// Book class
class Book {
    int id;
    String bookname;
    boolean isIssued;

    Book(int id, String bookname) {
        this.id = id;
        this.bookname = bookname;
        this.isIssued = false;
    }
}

// User class
class User {
    int userId;
    String name;

    User(int userId, String name) {
        this.userId = userId;
        this.name = name;
    }
}

// Library class
class Library {
    ArrayList<Book> books = new ArrayList<>();

    // Add a new book
    void addBook(Book book) {
        books.add(book);
        System.out.println("Book is added: " + book.bookname);
    }

    // Issue a book
    void issueBook(int bookId, User user) {
        for (Book b : books) {
            if (b.id == bookId) {
                if (!b.isIssued) {
                    b.isIssued = true;
                    System.out.println(" Book issued to " + user.name + ": " + b.bookname);
                } else {
                    System.out.println(" Book is already issued.");
                }
                return;
            }
        }
        System.out.println(" Book not found.");
    }

    // Return a book
    void returnBook(int bookId, User user) {
        for (Book b : books) {
            if (b.id == bookId) {
                if (b.isIssued) {
                    b.isIssued = false;
                    System.out.println("Book returned by " + user.name + ": " + b.bookname);
                } else {
                    System.out.println("Book was not issued.");
                }
                return;
            }
        }
        System.out.println(" Book not found.");
    }
}
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Library library = new Library();
        User user = new User(1, "Shital");

        int choice;

        do {
            System.out.println("\n-----Library Book Menu----");
            System.out.println("1. Add Book");
            System.out.println("2. Issue Book");
            System.out.println("3. Return Book");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Book ID: ");
                    int id = sc.nextInt();
                    sc.nextLine(); 
                    System.out.print("Enter Book Title: ");
                    String title = sc.nextLine();
                    library.addBook(new Book(id, title));
                    break;


                case 2:
                    System.out.print("Enter Book ID to issue: ");
                    int issueId = sc.nextInt();
                    library.issueBook(issueId, user);
                    break;

                case 3:
                    System.out.print("Enter Book ID to return: ");
                    int returnId = sc.nextInt();
                    library.returnBook(returnId, user);
                    break;

                case 4:
                    System.out.println("Exiting Library System. Thank You for visiting...!!");
                    break;

                default:
                    System.out.println(" Invalid choice. Try again.");
            }

        } while (choice != 4);

        sc.close();
    }
}

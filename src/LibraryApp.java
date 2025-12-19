import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LibraryApp {

    private List<Book> books = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        new LibraryApp().run();
    }

    public void run() {
        boolean running = true;

        while (running) {
            printMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> printALLBooks();
                case 2 -> addBook();
                case 3 -> searchByTitle();
                case 4 -> borrowBook();
                case 5 -> returnBook();
                case 6 -> deleteBook();
                case 7 -> running = false;
                default -> System.out.println("Invalid choice");
            }
        }
    }

    private void printMenu() {
        System.out.println("""
               Welcome to Library App!
               1. Print all books
               2. Add new book
               3. Search books by title
               4. Borrow a book
               5. Return a book
               6. Delete a book by id
               7. Quit
               """);
    }
    private void printALLBooks() {
        if( books.isEmpty()){
            System.out.println("No books in the Library");
            return;
        }
        for (Book book : books) {
            System.out.println(book) ;
        }
    }

    private void addBook() {
        System.out.print("Title: ");
        String title = scanner.nextLine();

        System.out.println("Author: ");
        String author = scanner.nextLine();

        System.out.println("Year: ");
        int year = scanner.nextInt();
        scanner.nextLine();

        books.add(new Book(title , author , year));
    }
    private void searchByTitle() {
        System.out.println("Enter a part of title: ");
        String search = scanner.nextLine().toLowerCase();

        for( Book book : books) {
            if (book.getTitle().toLowerCase().contains(search)){
                System.out.println(book) ;
            }
        }
    }

    private void borrowBook() {
        System.out.println("Enter book id: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        for (Book book : books) {
            if (book.getId() == id) {
                if (book.isAvailable()) {
                    book.markAsBorrowed();
                } else {
                    System.out.println("Book is already borrowed!");
                }
                return;
            }
        }
        System.out.println("Book is not found");
    }

    private void returnBook() {
        System.out.println("Enter book id: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        for (Book book : books) {
            if ( book.getId() == id) {
                if (!book.isAvailable()){
                    book.markAsReturned();
                }
                return;
            }
        }
        System.out.println("Book is not found");
    }

    private void deleteBook() {
        System.out.println("Enter book id: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        books.removeIf(book-> book.getId() == id) ;
    }
}

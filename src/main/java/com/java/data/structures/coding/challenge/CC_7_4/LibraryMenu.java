package com.java.data.structures.coding.challenge.CC_7_4;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class LibraryMenu {
    private Library library;
    private UserInteractionLogger logger = new UserInteractionLogger();
    private LibrarySerializer serializer = new LibrarySerializer();  // Added serializer

    public LibraryMenu(Library library) {
        this.library = library;

        // Load the library data when the program starts
        List<Book> books = serializer.loadLibrary("src/resources/data/library.ser");
        if (books != null) {
            library.setBooks(books);
            System.out.println("Library loaded successfully.");
        } else {
            System.out.println("No saved library found. Loading default books.");
            library.loadBooks("src/resources/data/books.txt");
        }
    }

    public void displayMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. View all books");
            System.out.println("2. Search for a book");
            System.out.println("3. Sort books");
            System.out.println("4. Save and exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline
            switch (choice) {
                case 1:
                    library.viewAllBooks();
                    logger.logViewAllBooks();
                    break;
                case 2:
                    System.out.print("Enter a keyword to search: ");
                    String keyword = scanner.nextLine();
                    Book foundBook = library.searchBookByKeyword(keyword);
                    if (foundBook != null) {
                        System.out.println("Found: " + foundBook);
                    } else {
                        System.out.println("No book found with the given keyword.");
                    }
                    logger.logSearch(keyword);
                    break;
                case 3:
                    sortBooks(scanner);
                    break;
                case 4:
                    serializer.saveLibrary(library.getBooks(), "src/resources/data/library.ser");
                    System.out.println("Library saved. Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

    }
    private void sortBooks(Scanner scanner) {
        System.out.println("Sort by:");
        System.out.println("1. Title");
        System.out.println("2. Author");
        System.out.println("3. Publication Year");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                SortUtil.quickSort(library.getBooks(), Comparator.comparing(Book::getTitle), 0, library.getBooks().size() - 1);
                logger.logSort("Title");
                break;
            case 2:
                SortUtil.quickSort(library.getBooks(), Comparator.comparing(Book::getAuthor), 0, library.getBooks().size() - 1);
                logger.logSort("Author");
                break;
            case 3:
                SortUtil.quickSort(library.getBooks(), Comparator.comparingInt(Book::getPublicationYear), 0, library.getBooks().size() - 1);
                logger.logSort("Publication Year");
                break;
            default:
                System.out.println("Invalid choice.");
        }
        library.viewAllBooks();
    }
}

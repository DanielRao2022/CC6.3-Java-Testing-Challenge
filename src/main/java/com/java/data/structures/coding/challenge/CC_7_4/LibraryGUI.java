package com.java.data.structures.coding.challenge.CC_7_4;/*
 / Author: Bala Ravi
 / Date: 11/22/2024
 / Filename: LibraryGUI.java
 / Description: Implements user interaction via GUI interface
 */

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Comparator;
import java.util.List;
public class LibraryGUI {
    private JFrame frame;
    private JTable bookTable;
    private Library library;
    private LibrarySerializer serializer = new LibrarySerializer();
    private UserInteractionLogger logger = new UserInteractionLogger();
    private DefaultTableModel tableModel;
    public LibraryGUI(Library library) {
        this.library = library;
        // Load library data
        List<Book> books = serializer.loadLibrary("src/resources/data/library.ser");
        if (books != null) {
            library.setBooks(books);
            JOptionPane.showMessageDialog(null, "Library loaded successfully.");
        } else {
            library.loadBooks("src/resources/data/books.txt");
            JOptionPane.showMessageDialog(null, "No saved library found. Default books loaded.");
        }
        // Initialize GUI components
        frame = new JFrame("Digital Library System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        // Create layout
        frame.setLayout(new BorderLayout());
        // Initialize the book table
        tableModel = new DefaultTableModel(new Object[]{"Title", "Author", "Year"}, 0);
        bookTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(bookTable);
        frame.add(scrollPane, BorderLayout.CENTER);
        // Add buttons panel
        JPanel buttonPanel = new JPanel();
        frame.add(buttonPanel, BorderLayout.SOUTH);
        JButton viewBooksButton = new JButton("View All Books");
        JButton searchBooksButton = new JButton("Search Book");
        JButton sortBooksButton = new JButton("Sort Books");
        JButton saveExitButton = new JButton("Save and Exit");
        buttonPanel.add(viewBooksButton);
        buttonPanel.add(searchBooksButton);
        buttonPanel.add(sortBooksButton);
        buttonPanel.add(saveExitButton);
        // Add action listeners for buttons
        viewBooksButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewAllBooks();
                logger.logViewAllBooks();
            }
        });
        searchBooksButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchBook();
            }
        });
        sortBooksButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sortBooks();
            }
        });
        saveExitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                serializer.saveLibrary(library.getBooks(), "src/resources/data/library.ser");
                JOptionPane.showMessageDialog(null, "Library saved. Exiting...");
                frame.dispose();
            }
        });
        frame.setVisible(true);
    }
    private void viewAllBooks() {
        clearTable();
        for (Book book : library.getBooks()) {
            tableModel.addRow(new Object[]{book.getTitle(), book.getAuthor(), book.getPublicationYear()});
        }
    }
    private void searchBook() {
        String keyword = JOptionPane.showInputDialog("Enter a keyword to search:");
        if (keyword != null && !keyword.isEmpty()) {
            Book foundBook = library.searchBookByKeyword(keyword);
            if (foundBook != null) {
                JOptionPane.showMessageDialog(null, "Found: " + foundBook);
            } else {
                JOptionPane.showMessageDialog(null, "No book found with the given keyword.");
            }
            logger.logSearch(keyword);
        }
    }
    private void sortBooks() {
        String[] options = {"Title", "Author", "Publication Year"};
        int choice = JOptionPane.showOptionDialog(null, "Sort by:", "Sort Books",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
        switch (choice) {
            case 0:
                SortUtil.quickSort(library.getBooks(), Comparator.comparing(Book::getTitle), 0, library.getBooks().size() - 1);
                logger.logSort("Title");
                break;
            case 1:
                SortUtil.quickSort(library.getBooks(), Comparator.comparing(Book::getAuthor), 0, library.getBooks().size() - 1);
                logger.logSort("Author");
                break;
            case 2:
                SortUtil.quickSort(library.getBooks(), Comparator.comparingInt(Book::getPublicationYear), 0, library.getBooks().size() - 1);
                logger.logSort("Publication Year");
                break;
            default:
                break;
        }
        viewAllBooks(); // Update the table after sorting
    }
    private void clearTable() {
        tableModel.setRowCount(0); // Clears the table
    }
}

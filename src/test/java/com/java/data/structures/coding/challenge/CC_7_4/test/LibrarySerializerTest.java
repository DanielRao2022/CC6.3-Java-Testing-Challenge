package com.java.data.structures.coding.challenge.CC_7_4.test;

import com.java.data.structures.coding.challenge.CC_7_4.Book;
import com.java.data.structures.coding.challenge.CC_7_4.LibrarySerializer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class LibrarySerializerTest {

    private LibrarySerializer serializer;
    private String testFileName = "test_library.ser";

    @Before
    public void setUp() {
        serializer = new LibrarySerializer();
    }

    @After
    public void tearDown() {
        // Clean up the test file after each test
        File file = new File(testFileName);
        if (file.exists()) {
            file.delete();
        }
    }

    @Test
    public void testSaveAndLoadLibrary() {
        // Create a test list of books
        List<Book> books = new ArrayList<>();
        books.add(new Book("Effective Java", "Joshua Bloch", 2008));
        books.add(new Book("Clean Code", "Robert C. Martin", 2008));

        // Save the library
        serializer.saveLibrary(books, testFileName);

        // Load the library
        List<Book> loadedBooks = serializer.loadLibrary(testFileName);

        // Assert the loaded data is the same as the saved data
        assertNotNull(loadedBooks);
        assertEquals(2, loadedBooks.size());
        assertEquals("Effective Java", loadedBooks.get(0).getTitle());
        assertEquals("Clean Code", loadedBooks.get(1).getTitle());
    }

    @Test
    public void testLoadNonExistentLibrary() {
        // Try to load a non-existent file
        List<Book> loadedBooks = serializer.loadLibrary("non_existent_file.ser");

        // Assert the result is null
        assertNull(loadedBooks);
    }

    @Test
    public void testSaveEmptyLibrary() {
        // Save an empty library
        List<Book> books = new ArrayList<>();
        serializer.saveLibrary(books, testFileName);

        // Load the library
        List<Book> loadedBooks = serializer.loadLibrary(testFileName);

        // Assert the loaded list is empty
        assertNotNull(loadedBooks);
        assertTrue(loadedBooks.isEmpty());
    }
}

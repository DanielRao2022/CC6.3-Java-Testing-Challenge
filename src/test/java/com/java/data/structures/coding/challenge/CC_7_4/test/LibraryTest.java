package com.java.data.structures.coding.challenge.CC_7_4.test;

import com.java.data.structures.coding.challenge.CC_7_4.Book;
import com.java.data.structures.coding.challenge.CC_7_4.Library;
import org.junit.Before;
import org.junit.Test;
import java.util.List;

import static org.junit.Assert.*;

public class LibraryTest {

    private Library library;

    @Before
    public void setUp() {
        library = new Library();
        library.getBooks().add(new Book("Effective Java", "Joshua Bloch", 2008));
        library.getBooks().add(new Book("Clean Code", "Robert C. Martin", 2008));
        library.getBooks().add(new Book("The Pragmatic Programmer", "Andrew Hunt", 1999));
    }

    @Test
    public void testViewAllBooks() {
        // This test relies on the correct order of the books
        List<Book> books = library.getBooks();

        assertEquals(3, books.size());
        assertEquals("Effective Java", books.get(0).getTitle());
        assertEquals("Clean Code", books.get(1).getTitle());
        assertEquals("The Pragmatic Programmer", books.get(2).getTitle());
    }

    @Test
    public void testSearchBookByKeyword() {
        Book foundBook = library.searchBookByKeyword("Effective");
        assertNotNull(foundBook);
        assertEquals("Effective Java", foundBook.getTitle());

        foundBook = library.searchBookByKeyword("Joshua");
        assertNotNull(foundBook);
        assertEquals("Effective Java", foundBook.getTitle());

        foundBook = library.searchBookByKeyword("Nonexistent");
        assertNull(foundBook);
    }
}

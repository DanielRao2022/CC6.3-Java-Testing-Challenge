package com.java.data.structures.coding.challenge.CC_7_4.test;

import com.java.data.structures.coding.challenge.CC_7_4.Book;
import org.junit.Test;
import static org.junit.Assert.*;

public class BookTest {

    @Test
    public void testBookConstructor() {
        Book book = new Book("Effective Java", "Joshua Bloch", 2008);

        assertEquals("Effective Java", book.getTitle());
        assertEquals("Joshua Bloch", book.getAuthor());
        assertEquals(2008, book.getPublicationYear());
    }

    @Test
    public void testSettersAndGetters() {
        Book book = new Book("Title", "Author", 2020);

        book.setTitle("New Title");
        book.setAuthor("New Author");
        book.setPublicationYear(2021);

        assertEquals("New Title", book.getTitle());
        assertEquals("New Author", book.getAuthor());
        assertEquals(2021, book.getPublicationYear());
    }

    @Test
    public void testToString() {
        Book book = new Book("Effective Java", "Joshua Bloch", 2008);
        String expected = "Book{title='Effective Java', author='Joshua Bloch', publicationYear=2008}";

        assertEquals(expected, book.toString());
    }
}

package com.java.data.structures.coding.challenge.CC_7_4.test;

import com.java.data.structures.coding.challenge.CC_7_4.Book;
import com.java.data.structures.coding.challenge.CC_7_4.SortUtil;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.junit.Assert.*;

public class SortUtilTest {

    private List<Book> books;

    @Before
    public void setUp() {
        books = new ArrayList<>();
        books.add(new Book("Effective Java", "Joshua Bloch", 2008));
        books.add(new Book("Clean Code", "Robert C. Martin", 2008));
        books.add(new Book("The Pragmatic Programmer", "Andrew Hunt", 1999));
    }

    @Test
    public void testSortByTitle() {
        SortUtil.quickSort(books, Comparator.comparing(Book::getTitle), 0, books.size() - 1);

        assertEquals("Clean Code", books.get(0).getTitle());
        assertEquals("Effective Java", books.get(1).getTitle());
        assertEquals("The Pragmatic Programmer", books.get(2).getTitle());
    }

    @Test
    public void testSortByAuthor() {
        SortUtil.quickSort(books, Comparator.comparing(Book::getAuthor), 0, books.size() - 1);

        assertEquals("Andrew Hunt", books.get(0).getAuthor());
        assertEquals("Joshua Bloch", books.get(1).getAuthor());
        assertEquals("Robert C. Martin", books.get(2).getAuthor());
    }

    @Test
    public void testSortByPublicationYear() {
        SortUtil.quickSort(books, Comparator.comparingInt(Book::getPublicationYear), 0, books.size() - 1);

        assertEquals(1999, books.get(0).getPublicationYear());
        assertEquals(2008, books.get(1).getPublicationYear());
        assertEquals(2008, books.get(2).getPublicationYear());
    }
}

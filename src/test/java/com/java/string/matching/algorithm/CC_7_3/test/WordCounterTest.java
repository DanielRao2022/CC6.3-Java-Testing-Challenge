package com.java.string.matching.algorithm.CC_7_3.test;

import com.java.string.matching.algorithm.CC_7_3.WordCounter;
import org.junit.Test;
import static org.junit.Assert.*;

public class WordCounterTest {

    @Test
    public void testConstructorWithDefaultCount() {
        WordCounter wordCounter = new WordCounter("hello");
        assertEquals("hello", wordCounter.getWord());
        assertEquals(1, wordCounter.getCounter());
    }

    @Test
    public void testConstructorWithSpecifiedCount() {
        WordCounter wordCounter = new WordCounter("hello", 5);
        assertEquals("hello", wordCounter.getWord());
        assertEquals(5, wordCounter.getCounter());
    }

    @Test
    public void testCountIncrementsCounter() {
        WordCounter wordCounter = new WordCounter("test");
        wordCounter.count();
        assertEquals(2, wordCounter.getCounter());
    }

    @Test
    public void testToStringFormat() {
        WordCounter wordCounter = new WordCounter("example", 3);
        assertEquals("{example=3}", wordCounter.toString());
    }
}

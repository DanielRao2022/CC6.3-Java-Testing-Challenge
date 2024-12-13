package com.java.string.matching.algorithm.CC_7_3.test;

import com.java.string.matching.algorithm.CC_7_3.WordSuggestions;
import org.junit.Test;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class WordSuggestionsGetWordListTest {

    @Test
    public void testGetWordList() throws Exception {
        // Create a temporary test file
        File tempFile = File.createTempFile("test", ".txt");
        FileWriter writer = new FileWriter(tempFile);
        writer.write("Hello world!\nThis is a test file.\nAnother line with words.");
        writer.close();

        List<File> files = new ArrayList<>();
        files.add(tempFile);

        WordSuggestions wordSuggestions = new WordSuggestions();
        ArrayList<String> wordList = wordSuggestions.getWordList(files);

        assertEquals(9, wordList.size()); // Words longer than 3 characters
        assertTrue(wordList.contains("hello"));
        assertTrue(wordList.contains("world"));

        // Clean up temporary file
        tempFile.delete();
    }
}

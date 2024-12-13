/*
 * @group : Week 17 - DS & Algo 2 1 
 * @authors : Varun Avvaru, Jonathon Kingston, Vijay Kumar, William Mai, Vatsal Modgil, Bala Ravi, Prajay Singh Silwal 
 * @version 1.0
 * @date: 11/08/2024
 * @proprietor: Amazon Web Services Inc.
 */

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.Arrays;
import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.util.Comparator;

/**
 * The WordSuggestions class provides functionality for processing text files,
 * analyzing word frequencies, and generating word suggestions.
 * 
 * This class includes methods for:
 * - Selecting text files from a file system
 * - Extracting words from the selected files
 * - Counting word frequencies
 * - Sorting words based on their frequencies
 * - Generating suggestions for similar words
 *
 * The class is designed to work with text files and provides a comprehensive
 * workflow from file selection to word analysis and suggestion generation.
 *
 **/

public class WordSuggestions {

	/**
	 * Prompts the user to select one or more text files using a file chooser
	 * dialog. This method opens a JFileChooser dialog, allowing the user to select
	 * multiple .txt files.
	 *
	 * @return A List of File objects representing the selected text files. If no files are selected or the selection is cancelled, an empty list is returned.
	 */
	public List<File> getFiles() {
		try {
			// Initialize the file chooser with the specified directory
			File initialDirectory = new File("./textfiles");
			if (!initialDirectory.exists() || !initialDirectory.isDirectory()) {
				System.err.println(
						"Warning: Specified initial directory does not exist or is not a directory. Using default.");
				initialDirectory = new File(System.getProperty("user.home"));
			}
			JFileChooser j = new JFileChooser(initialDirectory, FileSystemView.getFileSystemView());

			// Set up a file filter for .txt files
			FileNameExtensionFilter filter = new FileNameExtensionFilter("Text files", "txt");
			j.setFileFilter(filter);

			// Allow multiple file selection and disable "All files" option
			j.setMultiSelectionEnabled(true);
			j.setAcceptAllFileFilterUsed(false);

			// Show the open dialog
			int result = j.showOpenDialog(null);

			// Process the result of the file chooser dialog
			if (result == JFileChooser.APPROVE_OPTION) {
				List<File> selectedFiles = Arrays.asList(j.getSelectedFiles());
				List<String> fileNames = new ArrayList<>();

				for (File file : selectedFiles) {
					if (!file.exists() || !file.isFile() || !file.canRead()) {
						System.err.println("Warning: File " + file.getName() + " cannot be read or does not exist.");
					} else {
						fileNames.add(file.getName());
					}
				}

				if (fileNames.isEmpty()) {
					System.err.println("No valid files were selected.");
					return new ArrayList<>();
				}

				// Uncomment the next line for debugging purposes
		        // System.out.println("Selected files: " + fileNames);
				return selectedFiles;
			} else if (result == JFileChooser.CANCEL_OPTION) {
				System.out.println("File selection was cancelled by the user.");
			} else {
				System.err.println("An error occurred during file selection.");
			}
		} catch (SecurityException e) {
			System.err.println("Security Exception: " + e.getMessage());
			e.printStackTrace();
		} catch (Exception e) {
			System.err.println("Unexpected error occurred: " + e.getMessage());
			e.printStackTrace();
		}
		return new ArrayList<>();
	}

	/**
	 * Extracts words from a list of text files and returns them as a list.
	 * This method processes each file, converting all text to lowercase,
	 * removing non-alphabetic characters, and collecting words longer than 3 characters.
	 *
	 * @param files A List of File objects representing the text files to process.
	 *              Each file should be readable and contain text content.
	 * @return An ArrayList of Strings containing all words (longer than 3 characters)
	 *         extracted from the input files. If no valid words are found or if all files
	 *         fail to process, an empty list is returned.
	 * @throws NullPointerException if the input list of files is null.
	 *
	 * Note: This method silently skips any files that cannot be read or processed,
	 * logging an error message for each problematic file.
	 */
	public ArrayList<String> getWordList(List<File> files) {
		// Initialize a list to hold all words from all files
		ArrayList<String> wordList = new ArrayList<>();

		for (File file : files) {
			try (BufferedReader br = new BufferedReader(new FileReader(file))) {
				String line;


				while ((line = br.readLine()) != null) {
					line = line.toLowerCase();
					line = line.replaceAll("[^a-zA-Z]", " ");
					String[] words = line.split("\\s+");

					for (String word : words) {
						if (word.length() > 3) {
							wordList.add(word);
						}
					}

				}
			} catch (IOException e) {
				System.out.printf("Error reading file %s: %s%n", file.getName(), e.getMessage());
			}
		}
		
		// Uncomment the next line for debugging purposes
	    // System.out.println(wordList);
		return wordList;
	}

	/**
	 * Counts the frequency of each word in the provided word list.
	 * This method processes a list of words and creates a frequency count for each unique word.
	 *
	 * @param wordList The list of words to process. Each element should be a non-null String.
	 *                 Duplicate words in this list will be counted multiple times.
	 * @return An ArrayList of WordCounter objects, where each WordCounter contains a unique word
	 *         and its frequency count. The list is unordered with respect to word frequency.
	 *         If the input list is empty, an empty ArrayList is returned.
	 * @throws NullPointerException if the input wordList is null or contains null elements.
	 *
	 * Note: This method is case-sensitive. Words with different cases will be counted as separate entries.
	 */
	public ArrayList<WordCounter> countWords(ArrayList<String> wordList) {
		// Create the list of WordCounters for each word and its frequency to return
		ArrayList<WordCounter> wordCountList = new ArrayList<>();
		
		// Create a map to count the frequency of each word
		HashMap<String, Integer> wordCountMap = new HashMap<>();
		
		// Loop through the wordList and populate the map using each word as the key and its frequency as the value
		for (String word : wordList) {
			wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
		}
		
		// Lambda to process each key value pair in the map and create / add WordCounter objects to wordCountList
		wordCountMap.forEach((key, value) -> wordCountList.add(new WordCounter(key, value)));
		
		// Uncomment the next line for debugging purposes
	    // System.out.println(wordList);
		return wordCountList;
	}

	/**
	 * Sorts a list of WordCounter objects based on their frequency counts in descending order.
	 *
	 * @param countedList An ArrayList of WordCounter objects to be sorted.
	 *                    Each WordCounter should contain a word and its frequency count.
	 * @return A new ArrayList of WordCounter objects sorted in descending order of frequency.
	 *         The original list remains unchanged.
	 *         If the input list is empty, an empty ArrayList is returned.
	 * @throws NullPointerException if the input countedList is null or contains null elements.
	 *
	 * Note: This method creates a new list for sorting, preserving the original input list.
	 *       In case of ties in frequency, the order of equal-frequency words is not guaranteed.
	 */
	public ArrayList<WordCounter> getWordFrequencies(ArrayList<WordCounter> countedList) {
		ArrayList<WordCounter> sortedWordCountList = new ArrayList<>();
		ArrayList<WordCounter> unsortedWordCountList = new ArrayList<>(countedList);

		Collections.sort(unsortedWordCountList, (wc1, wc2) -> wc2.getCounter() - wc1.getCounter());

		sortedWordCountList = unsortedWordCountList;

		// Uncomment the next line for debugging purposes
	    // System.out.println(sortedWordCountList);
		return sortedWordCountList;
	}

	/**
	 * This method generates suggestions for similar words based on the given list of
	 * WordCounter objects.
	 * @param wordCountList The list of WordCounter objects containing words and their frequencies.
	 * @return An ArrayList of String arrays, where each array represents a group of
	 * similar words found in the input list.
	 */
	public ArrayList<String[]> getSuggestions(ArrayList<WordCounter> wordCountList) {
		ArrayList<String[]> suggestions = new ArrayList<>();
		Map<String, List<String>> similarMap = new HashMap<>();

		// Sort wordCountList by word length in ascending order
		Collections.sort(wordCountList, Comparator.comparingInt(wc -> wc.getWord().length()));

		// Loop through each word in the word count list
		for (WordCounter wc : wordCountList) {
			String word = wc.getWord();
			List<String> similars = new ArrayList<>();

			// Check for similar words and add them to the similars list
			for (WordCounter wc1 : wordCountList) {
				String otherWord = wc1.getWord();
				if (!word.equalsIgnoreCase(otherWord) && badCharacterRuleMatch(word, otherWord)) {
					similars.add(otherWord);
				}
			}

			// If there are similar words, add them to the similarsMap
			if (!similars.isEmpty()) {
				similars.add(word);
				similarMap.put(word, similars);
			}
		}

		// Convert the similarsMap to an ArrayList of String arrays
		for (Map.Entry<String, List<String>> entry : similarMap.entrySet()) {
			suggestions.add(entry.getValue().toArray(new String[0]));
		}
		return suggestions;
	}

	/**
	 * Bad character rule match boolean.
	 *
	 * @param P the p
	 * @param T the t
	 * @return the boolean
	 */
	public boolean badCharacterRuleMatch(String P, String T) {

		int n = T.length();
		int m = P.length();

		int e = 256;
		int left[][] = new int[m][e];

		for (int i = 0; i < m; i++)
			for (int j = 0; j < e; j++)
				left[i][j] = -1;

		for (int i = 0; i < m; i++) {
			if (i != 0)
				for (int j = 0; j < e; j++)
					left[i][j] = left[i - 1][j];
			left[i][P.charAt(i)] = i;
		}

		boolean hasMatch = false;

		int skip;
		for (int i = 0; i < n - m + 1; i += skip) {
			skip = 0;
			for (int j = m - 1; j >= 0; j--) {
				if (P.charAt(j) != T.charAt(i + j)) {
					skip = Math.max(1, j - left[j][T.charAt(i + j)]);
					break;
				}
			}

			if (skip == 0) {
				hasMatch = true;
				break;
			}
		}
		return hasMatch;
	}

	/**
	 *
	 * This method demonstrates the usage of the WordSuggestions class by processing
	 * text files and generating word suggestions.
	 *
	 * The method performs the following steps:
	 * 1. Prompts user to start app, choose file, and if they want to continue
	 * 2. Uses SwingUtilities.invokeLater to ensure thread safety with Swing components.
	 * 3. Calls methods to select files, extract words, count frequencies, and generate suggestions.
	 * 4. Prints the resulting similar word groups to the console.
	 *
	 * Note: Some debug print statements are commented out but can be uncommented for debugging purposes.
	 *
	 * @param args Command line arguments (not used in this implementation).
	 */
	public void runApplication(){
		SwingUtilities.invokeLater(() -> {
		if (JOptionPane.showOptionDialog(null, "Would you like to run the application?",
				"WORD SUGGESTIONS APPLICATION", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,
				null, null, null) == 0){
			do {
				System.out.println("ANALYZING FILE...");
				// Process files and generate word frequencies
				ArrayList<WordCounter> frequencies = getWordFrequencies(countWords(getWordList(getFiles())));
				// Uncomment the next line to print all word frequencies
				System.out.println(frequencies.toString());

				// Generate and print similar word groups
				ArrayList<String[]> suggestion = getSuggestions(frequencies);
				System.out.println("Similar word groups: ");
				for (String[] wordGroup : suggestion) {
					System.out.println(Arrays.toString(wordGroup));
				}
			} while (JOptionPane.showOptionDialog(null,
					"Would you like to continue running the application?", "WORD SUGGESTIONS APPLICATION",
					JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,null, null, null) ==0);
		}
		JOptionPane.showMessageDialog(null,
					"THANK YOU FOR CHOOSING 'WORD SUGGESTIONS'\nAS ALWAYS GROUP 1 COHORT 3 IS THE BEST!");
		});
	}


	/**
	 * The main entry point for the WordSuggestions application by calling runApplication().
	 *
	 *
	 * @param args Command line arguments (not used in this implementation).
	 */
	public static void main(String[] args) {
		WordSuggestions ws = new WordSuggestions();
		ws.runApplication();

	}

}
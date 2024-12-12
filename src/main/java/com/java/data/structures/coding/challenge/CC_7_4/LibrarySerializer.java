package com.java.data.structures.coding.challenge.CC_7_4;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class LibrarySerializer {

    public void saveLibrary(List<Book> books, String fileName) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            // Write the list of books to the file
            oos.writeObject(books);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Book> loadLibrary(String fileName) {
        File file = new File(fileName);
        if (!file.exists() || file.length() == 0) {

            return null;
        }

        try
                (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            // Cast and return the list of books
            return (List<Book>) ois.readObject();
        }
        catch (EOFException e) {

            System.err.println("The file is empty or corrupted: " + fileName);
            return null;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}


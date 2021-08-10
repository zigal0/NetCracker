package ru.skillbench.tasks.javaapi.io;

import java.io.*;
import java.util.*;
import java.util.stream.Stream;

public class WordFinderImpl implements WordFinder {
    String text = null;
    Set<String> foundWords = new TreeSet<>();

    @Override
    public String getText() {
        return text;
    }

    @Override
    public void setText(String text) {
        if (text == null) {
            throw new IllegalArgumentException("Error setText");
        }
        this.text = text;
    }

    @Override
    public void setInputStream(InputStream is) throws IOException {
        if (is == null) {
            throw new IllegalArgumentException("Error setInputStream");
        }
        byte[] b = new byte[is.available()];
        if (is.read(b) == -1) {
            throw new IOException("Error");
        }
        text = new String(b);
    }

    @Override
    public void setFilePath(String filePath) throws IOException {
        if (filePath == null) {
            throw new IllegalArgumentException("Error setFilePath");
        }
        FileInputStream is = new FileInputStream(filePath);
        setInputStream(is);
    }

    @Override
    public void setResource(String resourceName) throws IOException {
        if (resourceName == null) {
            throw new IllegalArgumentException("Error setResource");
        }
        InputStream is = getClass().getResourceAsStream(resourceName);
        setInputStream(is);
    }

    @Override
    public Stream<String> findWordsStartWith(String begin) {
        if (text == null) {
            throw new IllegalStateException("Error findWordsStartWith");
        }
        foundWords.clear();
        String modifiedText = text.toLowerCase();
        String[] subText = modifiedText.split("\\s+");
        if (begin == null || begin.equals("")) {
            foundWords.addAll(Arrays.asList(subText));
        } else {
            begin = begin.toLowerCase();
            for (String item : subText) {
                if (item.startsWith(begin)) {
                    foundWords.add(item);
                }
            }
        }
        return Arrays.stream(foundWords.toArray(new String[0]));
    }

    @Override
    public void writeWords(OutputStream os) throws IOException {
        if (foundWords.size() == 0) {
            throw new IllegalStateException("Error writeWords");
        }
        DataOutputStream dos = new DataOutputStream(os);
        int counter = 1;
        for (String item : foundWords) {
            dos.writeBytes(item);
            if (counter != foundWords.size()) {
                dos.writeBytes(" ");
            }
            counter++;
        }
        dos.flush();
        dos.close();
    }
}

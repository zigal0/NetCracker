package ru.skillbench.tasks.javaapi.io;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Locale;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class Demo {
    public static void main(String[] args) throws IOException {
        String example = "example.txt";
        WordFinderImpl wordFinder = new WordFinderImpl();
        wordFinder.setFilePath(example);
        System.out.println(wordFinder.getText());
        System.out.println("findWordsStartWith: ");
        Stream<String> result = wordFinder.findWordsStartWith("Wh");
        System.out.println(Arrays.toString(result.toArray()));
        System.out.println("Method writeWords: ");
        wordFinder.writeWords(System.out);
    }
}

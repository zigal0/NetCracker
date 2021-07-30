package ru.ncedu.zigal0.text;

import java.util.*;

/**
 * Class Analyzer is a tool for the frequency analysis of words and characters in a string.
 * Impossible to create with string == null - NullPointerException.
 *
 * @author zigal0
 */
public class Analyzer {
    // Collections for words & symbols
    private final Map<String, Integer> words = new HashMap<>();
    private final Map<Character, Integer> symbols = new HashMap<>();
    private String str;

    /**
     * Construct for Class Person with param - str.
     *
     * @param str - string for analysing.
     */
    public Analyzer(String str) {
        this.str = str;
        fullAnalysis();
    }

    /**
     * Returns str for Analysis.
     *
     * @return String
     */
    public String getStr() {
        return str;
    }

    /**
     * Sets new sting for Analysis.
     */
    public void setStr(String newStr) {
        str = newStr;
        fullAnalysis();
    }

    /**
     * Returns Map: word - number of occurrences.
     *
     * @return Map.
     */
    public Map<String, Integer> getWords() {
        return words;
    }

    /**
     * Returns Map: symbol - number of occurrences.
     *
     * @return Map.
     */
    public Map<Character, Integer> getSymbols() {
        return symbols;
    }

    /**
     * Runs analyzeWords & analyzeCharacters methods.
     */
    public void fullAnalysis() {
        if (str == null) {
            throw new NullPointerException();
        }
        analyzeWords();
        analyzeCharacters();
    }

    /**
     * Analyzes str for occurrences of words.
     */
    public void analyzeWords() {
        String delimiter = " ";
        String[] subStr = str.split(delimiter);
        for (String word : subStr) {
            if (words.containsKey(word)) {
                words.put(word, words.get(word) + 1);
            } else {
                words.put(word, 1);
            }
        }
    }

    /**
     * Analyzes str for occurrences of symbols.
     */
    public void analyzeCharacters() {
        char[] subChar = str.toCharArray();
        for (char c : subChar) {
            if (symbols.containsKey(c)) {
                symbols.put(c, symbols.get(c) + 1);
            } else {
                symbols.put(c, 1);
            }
        }
    }

    /**
     * Prints "word = number of occurrences".
     */
    public void printWords() {
        System.out.println("Word Analysis: ");
        Set<String> setWords = this.words.keySet();
        for (String word : setWords) {
            System.out.println(word + " = " + words.get(word));
        }
    }

    /**
     * Prints "symbol = number of occurrences".
     */
    public void printSymbols() {
        System.out.println("Symbol Analysis: ");
        Set<Character> setSymbols = this.symbols.keySet();
        for (char c : setSymbols) {
            System.out.println(c + " = " + symbols.get(c));
        }

    }

    /**
     * Finds words that are included in both the first and second strings.
     *
     * @param other - other Analyzer.
     * @return Set - list of unique words.
     */
    public Set<String> findSameWords(Analyzer other) {
        Set<String> setThisWords = this.words.keySet();
        Set<String> result = new HashSet<>(setThisWords);
        Set<String> setOtherWords = other.getWords().keySet();
        result.retainAll(setOtherWords);
        return result;
    }

    /**
     * Finds symbols that are included in both the first and second strings.
     *
     * @param other - other Analyzer.
     * @return Set - list of unique symbols.
     */
    public Set<Character> findSameSymbols(Analyzer other) {
        Set<Character> setThisSymbols = this.symbols.keySet();
        Set<Character> result = new HashSet<>(setThisSymbols);
        Set<Character> setOtherSymbols = other.getSymbols().keySet();
        result.retainAll(setOtherSymbols);
        return result;
    }

    /**
     * Finds words that are included in the first string and are not included in the second string.
     *
     * @param other - other Analyzer.
     * @return Set - list of unique words.
     */
    public Set<String> wordsInThisNotInOther(Analyzer other) {
        Set<String> setThisWords = this.words.keySet();
        Set<String> setOtherWords = other.getWords().keySet();
        Set<String> result = new HashSet<>();
        for (String word : setThisWords) {
            if (!setOtherWords.contains(word)) {
                result.add(word);
            }
        }
        return result;
    }

    /**
     * Finds symbols that are included in the first string and are not included in the second string.
     *
     * @param other - other Analyzer.
     * @return Set - list of unique symbols.
     */
    public Set<Character> symbolsInThisNotInOther(Analyzer other) {
        Set<Character> setThisSymbols = this.symbols.keySet();
        Set<Character> setOtherSymbols = other.getSymbols().keySet();
        Set<Character> result = new HashSet<>();
        for (char c : setThisSymbols) {
            if (!setOtherSymbols.contains(c)) {
                result.add(c);
            }
        }
        return result;
    }

    /**
     * Finds words that appear on at least one line.
     * @param other - other Analyzer.
     * @return - list of unique words.
     */
    public Set<String> wordsInBothStrings(Analyzer other) {
        Set<String> setThisWords = this.words.keySet();
        Set<String> setOtherWords = other.getWords().keySet();
        Set<String> result = new HashSet<>(setThisWords);
        result.addAll(setOtherWords);
        return result;
    }

    /**
     * Finds symbols that appear on at least one line.
     * @param other - other Analyzer.
     * @return - list of unique symbols.
     */
    public Set<Character> symbolsInBothStrings(Analyzer other) {
        Set<Character> setThisSymbols = this.symbols.keySet();
        Set<Character> setOtherSymbols = other.getSymbols().keySet();
        Set<Character> result = new HashSet<>(setThisSymbols);
        result.addAll(setOtherSymbols);
        return result;
    }

    /**
     * Carries out comparison between analysis of two strings.
     * @param other - other Analyzer.
     */
    public void fullAnalysisAndCompare(Analyzer other) {
        System.out.println("fullAnalysis:");
        String separator = "-----------------------------------------------------------------";

        System.out.println(separator);
        System.out.println("Words in the first string:");
        this.printWords();

        System.out.println(separator);
        System.out.println("Words in the second string:");
        other.printWords();

        System.out.println(separator);
        System.out.println("Symbols in the first string:");
        this.printSymbols();

        System.out.println(separator);
        System.out.println("Symbols in the second string:");
        other.printSymbols();

        System.out.println(separator);
        System.out.println("Words that are included in both the first and second strings:");
        Set<String> sameWords = this.findSameWords(other);
        for (String word : sameWords) {
            System.out.print(word + " ");
        }
        System.out.println();

        System.out.println(separator);
        System.out.println("Symbols that are included in both the first and second strings:");
        Set<Character> sameSymbols = this.findSameSymbols(other);
        for (char c : sameSymbols) {
            System.out.print(c + " ");
        }
        System.out.println();

        System.out.println(separator);
        System.out.println("Words that are included in the first string and are not included in the second string:");
        Set<String> onlyInFirstWords = this.wordsInThisNotInOther(other);
        for (String word : onlyInFirstWords) {
            System.out.print(word + " ");
        }
        System.out.println();

        System.out.println(separator);
        System.out.println("Symbols that are included in the first string and are not included in the second string:");
        Set<Character> onlyInFirstSymbols = this.symbolsInThisNotInOther(other);
        for (char c : onlyInFirstSymbols) {
            System.out.print(c + " ");
        }
        System.out.println();

        System.out.println(separator);
        System.out.println("Words that appear on at least one line:");
        Set<String> wordsInBoth = this.wordsInBothStrings(other);
        for (String word : wordsInBoth) {
            System.out.print(word + " ");
        }
        System.out.println();

        System.out.println(separator);
        System.out.println("Symbols that appear on at least one line:");
        Set<Character> symbolsInBoth = this.symbolsInBothStrings(other);
        for (char c : symbolsInBoth) {
            System.out.print(c + " ");
        }
        System.out.println();
        System.out.println(separator);
    }
}

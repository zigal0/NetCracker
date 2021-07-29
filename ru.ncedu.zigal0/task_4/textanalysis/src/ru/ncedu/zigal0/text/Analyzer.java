package ru.ncedu.zigal0.text;

import java.util.*;

public class Analyzer {
    private final HashMap<String, Integer> words = new HashMap<>();
    private final HashMap<Character, Integer> symbols = new HashMap<>();

    public HashMap<String, Integer> getWords() {
        return words;
    }
    public HashMap<Character, Integer> getSymbols() {
        return symbols;
    }

    public Analyzer(String str){
        analyzeWords(str);
        analyzeCharacters(str);
    }

    public void analyzeWords(String str) {
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

    public void analyzeCharacters(String str) {
        char[] subChar = str.toCharArray();
        for (char c : subChar) {
            if (symbols.containsKey(c)) {
                symbols.put(c, symbols.get(c) + 1);
            } else {
                symbols.put(c, 1);
            }
        }
    }

    public void printWords() {
        System.out.println("Word Analysis: ");
        Set<String> setWords = this.words.keySet();
        for (String word : setWords) {
            System.out.println(word + " = " + words.get(word));
        }
    }

    public void printSymbols() {
        System.out.println("Symbol Analysis: ");
        Set<Character> setSymbols = this.symbols.keySet();
        for (char c : setSymbols) {
            System.out.println(c + " = " + symbols.get(c));
        }
    }

    public Set<String> findSameWords(Analyzer other) {
        Set<String> setThisWords = this.words.keySet();
        Set<String> result = new HashSet<>(setThisWords);
        Set<String> setOtherWords = other.getWords().keySet();
        result.retainAll(setOtherWords);
        return result;
    }

    public Set<Character> findSameSymbols(Analyzer other) {
        Set<Character> setThisSymbols = this.symbols.keySet();
        Set<Character> result = new HashSet<>(setThisSymbols);
        Set<Character> setOtherSymbols = other.getSymbols().keySet();
        result.retainAll(setOtherSymbols);
        return result;
    }

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

    public Set<String> wordsInBothStrings(Analyzer other) {
        Set<String> setThisWords = this.words.keySet();
        Set<String> setOtherWords = other.getWords().keySet();
        Set<String> result = new HashSet<>(setThisWords);
        result.addAll(setOtherWords);
        return result;
    }

    public Set<Character> symbolsInBothStrings(Analyzer other) {
        Set<Character> setThisSymbols = this.symbols.keySet();
        Set<Character> setOtherSymbols = other.getSymbols().keySet();
        Set<Character> result = new HashSet<>(setThisSymbols);
        result.addAll(setOtherSymbols);
        return result;
    }

    public void fullAnalysis(Analyzer other) {
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

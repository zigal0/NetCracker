package ru.skillbench.tasks.text;

import java.io.PrintStream;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordCounterImpl implements WordCounter {
    private String text;
    @Override
    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String getText() {
        return text;
    }

    @Override
    public Map<String, Long> getWordCounts() throws IllegalStateException {
        if (getText() == null) {
            throw new IllegalStateException();
        }
        String refactoredText = deleteComments(this.text.trim());

        Pattern pattern = Pattern.compile("\\s+");
        String[] subText = pattern.split(refactoredText);
        Map<String, Long> analysis = new HashMap<>();
        for (String word : subText) {
            String wordLower = word.toLowerCase();
            if (analysis.containsKey(wordLower)) {
                analysis.put(wordLower, analysis.get(wordLower) + 1);
            } else {
                analysis.put(wordLower, 1L);
            }
        }
        return analysis;
    }

    private String deleteComments(String textForRefactoring) {
        Pattern pattern = Pattern.compile("<[^><]*>");
        Matcher matcher = pattern.matcher(textForRefactoring);
        String result = matcher.replaceAll("");
        if (!textForRefactoring.equals(result)) {
            return deleteComments(result);
        } else {
            return result;
        }
    }

    @Override
    public List<Map.Entry<String, Long>> getWordCountsSorted() {
        Map<String, Long> unsorted = getWordCounts();
        Comparator<Map.Entry<String, Long>> comparator = new Comparator<Map.Entry<String, Long>>() {
            @Override
            public int compare(Map.Entry<String, Long> o1, Map.Entry<String, Long> o2) {
//                if (o2.getValue().compareTo(o1.getValue()) == 0) {
//                    return o1.getKey().compareTo(o2.getKey());
//                }
                return o2.getValue().compareTo(o1.getValue());
            }
        };
        return this.sort(unsorted, comparator);
    }

    @Override
    public <K extends Comparable<K>, V extends Comparable<V>> List<Map.Entry<K, V>> sort(Map<K, V> map, Comparator<Map.Entry<K, V>> comparator) {
        List<Map.Entry<K, V>> sortedList = new ArrayList<>(map.entrySet());
        Collections.sort(sortedList, comparator);
        return sortedList;
    }

    @Override
    public <K, V> void print(List<Map.Entry<K, V>> entries, PrintStream ps) {
        for (Map.Entry<K, V> obj: entries) {
            ps.println(obj.getKey() + " " + obj.getValue());
        }
    }
}

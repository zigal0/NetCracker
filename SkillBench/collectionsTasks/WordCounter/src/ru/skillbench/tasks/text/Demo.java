package ru.skillbench.tasks.text;

import java.util.Map;
import java.util.Set;

public class Demo {
    public static void main(String[] args) {
        String separator = "********************************************";
        String text = "";
        WordCounter wordCounter = new WordCounterImpl();
        wordCounter.setText(text);
        Map<String, Long> result1 = wordCounter.getWordCounts();
        Set<String> keys = result1.keySet();
        for (String key : keys) {
            System.out.println(key + " - " + result1.get(key));
        }
        System.out.println(separator);
        wordCounter.print(wordCounter.getWordCountsSorted(), System.out);
    }
}

package ru.ncedu.zigal0.text;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        String separator = "*****************************************************************";
        String firstString = "This string is the first kek lol";
        String secondString = "This string is the second";
        Analyzer firstAnalyzer = new Analyzer(firstString);
        Analyzer secondAnalyzer = new Analyzer(secondString);
        firstAnalyzer.fullAnalysis(secondAnalyzer);

        System.out.println("OutPut for task:");
        System.out.println("Symbols that are included in both the first and second strings:");
        System.out.println(separator);
        System.out.println("The usual order:");
        ArrayList<Character> sameSymbols = new ArrayList<>(firstAnalyzer.findSameSymbols(secondAnalyzer));
        for (char c : sameSymbols) {
            System.out.print(c + " ");
        }
        System.out.println();
        System.out.println(separator);

        System.out.println("The reverse order:");
        Collections.reverse(sameSymbols);
        for (char c : sameSymbols) {
            System.out.print(c + " ");
        }
        System.out.println();
        System.out.println(separator);

        System.out.println("In ascending order of cyclic shift to the left by n bits of the symbol hash function ");
        Collections.reverse(sameSymbols);
        System.out.print("Enter n for left shift compare: ");
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        CharHashComparator comparator = new CharHashComparator(n);
        Collections.sort(sameSymbols, comparator);
        for (char c : sameSymbols) {
            System.out.print(c + " ");
        }
    }

    public static class CharHashComparator implements Comparator<Character> {

        private final int n;

        public CharHashComparator(int n) {
            this.n = n;
        }

        @Override
        public int compare(Character c1, Character c2) {
            return Integer.compare(c1.hashCode() << n, c2.hashCode() << n);
        }

    }
}

package ru.skillbench.tasks.javaapi.collections;

import java.util.*;

public class StringFilterImpl implements StringFilter {
    private final Set<String> set = new HashSet<>();

    @Override
    public void add(String s) {
        if (s == null) {
            set.add(null);
        } else {
            set.add(s.toLowerCase());
        }
    }

    @Override
    public boolean remove(String s) {
        if (s == null) {
            return set.remove(null);
        }
        return set.remove(s.toLowerCase());
    }

    @Override
    public void removeAll() {
        set.clear();
    }

    @Override
    public Collection<String> getCollection() {
        return set;
    }

    @Override
    public Iterator<String> getStringsContaining(final String chars) {
        if (chars == null || chars.equals("")) {
            return set.iterator();
        }
        Filter filter = new Filter() {
            @Override
            public boolean check(String forCheck) {
                return forCheck.contains(chars);
            }
        };
        return findWords(filter);
    }

    @Override
    public Iterator<String> getStringsStartingWith(final String begin) {
        if (begin == null || begin.equals("")) {
            return set.iterator();
        }
        Filter filter = new Filter() {
            @Override
            public boolean check(String forCheck) {
                String beginLower = begin.toLowerCase();
                return forCheck.startsWith(beginLower);
            }
        };
        return findWords(filter);
    }

    @Override
    public Iterator<String> getStringsByNumberFormat(final String format) {
        if (format == null || format.equals("")) {
            return set.iterator();
        }
        Filter filter = new Filter() {
            @Override
            public boolean check(String forCheck) {
                char[] subForCheck = forCheck.toCharArray();
                char[] subFormat = format.toCharArray();
                if (subForCheck.length != subFormat.length) {
                    return false;
                }
                for (int i = 0; i < subForCheck.length; i++) {
                    if (subForCheck[i] != subFormat[i]) {
                        if (subFormat[i] == '#' && Character.isDigit(subForCheck[i])) {
                            continue;
                        }
                        return false;
                    }
                }
                return true;
            }
        };
        return findWords(filter);
    }

    @Override
    public Iterator<String> getStringsByPattern(final String pattern) {
        if (pattern == null || pattern.equals("")) {
            return set.iterator();
        }
        Filter filter = new Filter() {
            @Override
            public boolean check(String forCheck) {
                String own = forCheck;
                boolean start = false;
                boolean finish = false;
                if (pattern.charAt(0) != '*') {
                    start = true;
                }
                if (pattern.charAt(pattern.length() - 1) != '*') {
                    finish = true;
                }
                String[] parts = pattern.split("\\*");
                for (int i = 0; i < parts.length; i++) {
                    if (i == 0 && start) {
                        if (!own.startsWith(parts[i])) {
                            return false;
                        }
                        own = own.substring(parts[i].length());
                    } else if (i == parts.length - 1 && finish) {
                        if (!own.endsWith(parts[i])) {
                            return false;
                        }
                    } else {
                        if (!own.contains(parts[i])) {
                            return false;
                        }
                        own = own.substring(own.indexOf(parts[i]) + parts[i].length());
                    }
                }
                return true;
            }
        };
        return findWords(filter);
    }

    private Iterator<String> findWords(Filter filter) {
        List<String> result = new ArrayList<>();
        for (String word : set) {
            if (word == null) {
                continue;
            }
            if (filter.check(word)) {
                result.add(word);
            }
        }
        return result.iterator();

    }

    private interface Filter {
        boolean check(String forCheck);
    }
}

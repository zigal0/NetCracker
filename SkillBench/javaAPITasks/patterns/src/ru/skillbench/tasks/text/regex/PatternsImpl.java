package ru.skillbench.tasks.text.regex;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternsImpl implements Patterns{
    @Override
    public Pattern getSQLIdentifierPattern() {
        return Pattern.compile("\\b[a-zA-Z]\\w{1,29}\\b");
    }

    @Override
    public Pattern getEmailPattern() {
        return Pattern.compile("\\b\\p{Alnum}([\\w.-]{0,20})\\p{Alnum}@(\\p{Alnum}([\\p{Alnum}-]*)\\p{Alnum}.)+(ru|com|net|org)\\b");
    }

    @Override
    public Pattern getHrefTagPattern() {
        return Pattern.compile("<\\s*[Aa]\\s+[hH][Rr][Ee][Ff]\\s*=\\s*(([^\\s>\"]+)|(\"([^\"])*\"))\\s*/?>");
    }

    @Override
    public List<String> findAll(String input, Pattern pattern) {
        Matcher matcher = pattern.matcher(input);
        List<String> result = new ArrayList<>();
        while (matcher.find()) {
            result.add(input.substring(matcher.start(), matcher.end()));
        }
        return result;
    }

    @Override
    public int countMatches(String input, String regex) {
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(input);
        int counter = 0;
        while (matcher.find()) {
            counter++;
        }
        return counter;
    }
}

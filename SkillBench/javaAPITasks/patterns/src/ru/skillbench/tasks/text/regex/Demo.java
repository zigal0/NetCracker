package ru.skillbench.tasks.text.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Demo {
    public static void main(String[] args) {

        String testSql = "2SString_22 s13_sa";
        String testEmails = "sergey-efimov-1999@mail.ru -@.ru";
        String testHREF = "dasdasda<a href=\"www.google.com\">asdas <a href=\"www.gasdasd.com\">";

        Patterns patterns = new PatternsImpl();
        // Testing
        //SQL
        Pattern patternSQL = patterns.getSQLIdentifierPattern();
        Matcher matcherSQL = patternSQL.matcher(testSql);
        while (matcherSQL.find()) {
            System.out.println(testSql.substring(matcherSQL.start(), matcherSQL.end()));
        }
        //Email
        Pattern patternEmail = patterns.getEmailPattern();
        Matcher matcherEmail = patternEmail.matcher(testEmails);
        while (matcherEmail.find()) {
            System.out.println(testEmails.substring(matcherEmail.start(), matcherEmail.end()));
        }
        // Href
        Pattern patternHREF = patterns.getHrefTagPattern();
        Matcher matcherHREF = patternHREF.matcher(testHREF);
        while (matcherHREF.find()) {
            System.out.println(testHREF.substring(matcherHREF.start(), matcherHREF.end()));
        }
    }
}

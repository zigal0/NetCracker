package ru.skillbench.tasks.text.regex;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CurriculumVitaeImpl implements CurriculumVitae {

    private String text;
    private final Map<String, String> hidden = new HashMap<>();

    @Override
    public void setText(String text) {
        hidden.clear();
        this.text = text;
    }

    @Override
    public String getText() throws IllegalStateException {
        if (text == null) {
            throw new IllegalStateException();
        }
        return text;
    }

    @Override
    public List<Phone> getPhones() {
        if (text == null) {
            throw new IllegalStateException();
        }

        List<Phone> phones = new ArrayList<>();

        Pattern pattern = Pattern.compile(PHONE_PATTERN);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            int areaCode = -1;
            int extension = -1;
            if (matcher.group(2) != null) {
                areaCode = Integer.parseInt(matcher.group(2));
            }
            if (matcher.group(7) != null) {
                extension = Integer.parseInt(matcher.group(7));
            }
            phones.add(new Phone(matcher.group(), areaCode, extension));
        }
        return phones;
    }

    @Override
    public String getFullName() {
        if (text == null) {
            throw new IllegalStateException();
        }
        Pattern pattern = Pattern.compile("([A-Z]([.]|[a-z]+[.]*)) ([A-Z]([.]|[a-z]+[.]*))? ?([A-Z]([.]|[a-z]+[.]*))");
        Matcher matcher = pattern.matcher(text);
        if (matcher.find()) {
            return matcher.group().trim();
        }
        throw new NoSuchElementException();
    }

    @Override
    public String getFirstName() {
        return getFullName().split(" ")[0];
    }

    @Override
    public String getMiddleName() {
        String[] subName = getFullName().split(" ");
        if (subName.length == 2) {
            return null;
        }
        return subName[1];
    }

    @Override
    public String getLastName() {
        String[] subName = getFullName().split(" ");
        return subName[subName.length - 1];
    }

    @Override
    public void updateLastName(String newLastName) {
        String oldLastName = getLastName();
        text = text.replace(oldLastName, newLastName);
    }

    @Override
    public void updatePhone(Phone oldPhone, Phone newPhone) {
        if (text == null) {
            throw new IllegalStateException();
        }
        if (!text.contains(oldPhone.getNumber())) {
            throw new IllegalArgumentException();
        }
        text = text.replace(oldPhone.getNumber(), newPhone.getNumber());
    }

    @Override
    public void hide(String piece) {
        if (text == null) {
            throw new IllegalStateException();
        }
        if (!text.contains(piece)) {
            throw new IllegalArgumentException();
        }
        String replace = piece.replaceAll("[^@. ]", "X");
        hidden.put(replace, piece);
        text = text.replace(piece, replace);
    }

    @Override
    public void hidePhone(String phone) {
        if (text == null) {
            throw new IllegalStateException();
        }
        if (!text.contains(phone)) {
            throw new IllegalArgumentException();
        }
        String replace = phone.replaceAll("[\\d]", "X");
        hidden.put(replace, phone);
        text = text.replace(phone, replace);
    }

    @Override
    public int unhideAll() {
        if (text == null) {
            throw new IllegalStateException();
        }
        Set<String> keys = hidden.keySet();
        for (String key : keys) {
            text = text.replace(key, hidden.get(key));
        }
        return keys.size();
    }
}

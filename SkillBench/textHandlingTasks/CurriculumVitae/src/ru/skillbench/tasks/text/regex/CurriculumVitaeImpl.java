package ru.skillbench.tasks.text.regex;

import java.util.List;

public class CurriculumVitaeImpl implements CurriculumVitae {

    private String text;

    @Override
    public void setText(String text) {
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
        return null;
    }

    @Override
    public String getFullName() {
        return null;
    }

    @Override
    public String getFirstName() {
        return null;
    }

    @Override
    public String getMiddleName() {
        return null;
    }

    @Override
    public String getLastName() {
        return null;
    }

    @Override
    public void updateLastName(String newLastName) {

    }

    @Override
    public void updatePhone(Phone oldPhone, Phone newPhone) {

    }

    @Override
    public void hide(String piece) {

    }

    @Override
    public void hidePhone(String phone) {

    }

    @Override
    public int unhideAll() {
        return 0;
    }
}

package ru.skillbench.tasks.text.regex;

import java.util.List;

public class Demo {
    public static void main(String[] args) {
        CurriculumVitae curriculumVitae = new CurriculumVitaeImpl();
        String cv = "[Julia Smith] [Oracle Certified Professional] (916)125-4171 lolkek chebureck 495 926-93-47 ext.1846 Efimov (916)125-4171";
        curriculumVitae.setText(cv);
        System.out.println(curriculumVitae.getFirstName());
        System.out.println(curriculumVitae.getFullName());
        System.out.println(curriculumVitae.getLastName());
        System.out.println(curriculumVitae.getMiddleName());
        System.out.println(curriculumVitae.getText());
        List<CurriculumVitae.Phone> phones = curriculumVitae.getPhones();
        for (CurriculumVitae.Phone phone : phones) {
            System.out.println(phone);
        }
        curriculumVitae.hide("Efimov");
        curriculumVitae.hidePhone("(916)125-4171");
        System.out.println(curriculumVitae.getText());
        curriculumVitae.unhideAll();
        System.out.println(curriculumVitae.getText());
    }
}

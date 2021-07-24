package ru.ncedu.zigal0.person;

/**
 * Class Person represents basic info about one Person.
 * @author zigal0
 */
public class Person {
    private String firstName;
    private String middleName;
    private String lastName;

    public Person() {
    }

    public Person(String firstName, String middleName, String lastName) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
    }

    /**
     * Returns full name in string format. If one of fields is null - return "None" instead.
     * @return initials
     */
    public String getFullName() {
        StringBuilder res = new StringBuilder();
        if (firstName == null) {
            res.append("None ");
        } else {
            res.append(firstName);
            res.append(" ");
        }
        if (middleName == null) {
            res.append("None ");
        } else {
            res.append(middleName);
            res.append(" ");
        }
        if (lastName == null) {
            res.append("None");
        } else {
            res.append(lastName);
            res.append(" ");
        }
        return res.toString();
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getMiddleName() {
        if (middleName == null) {
            return "None";
        }
        return middleName;
    }

    public String getLastName() {
        if (lastName == null) {
            return "None";
        }
        return lastName;
    }

    public String getFirstName() {
        if (firstName == null) {
            return "None";
        }
        return firstName;
    }
}

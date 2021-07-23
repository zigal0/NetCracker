package ru.skillbench.tasks.text;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

public class ContactCardImpl implements ContactCard{
    // Constant for check number of required fields
    final int numberOfRequiredField = 4;
    private String fullName;
    private String organization;
    private char gender;
    private LocalDate birthDate;
    private final HashMap<String, String> phoneTypeNumber = new HashMap<>();

    @Override
    public ContactCard getInstance(Scanner scanner) {
        String cur = scanner.nextLine();
        if (!cur.equals("BEGIN:VCARD")) {
            // No required field
            throw new NoSuchElementException();
        }
        int checkForRequiredFields = 1;
        while (scanner.hasNextLine()) {
            cur = scanner.nextLine();
            if (checker(cur, "FN:")) {
                fullName = cur.substring(3);
                checkForRequiredFields++;
            } else if (checker(cur, "ORG:")) {
                organization = cur.substring(4);
                checkForRequiredFields++;
            } else if (checker(cur, "GENDER:")) {
                if (cur.substring(7).length() != 1 && cur.charAt(7) != 'M' && cur.charAt(7) == 'F') {
                    // Sex - one character: F or M
                    throw new InputMismatchException();
                }
                gender = cur.charAt(7);
            } else if (checker(cur, "BDAY:")) {
                try {
                    // Special format for given date
                    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                    birthDate = LocalDate.parse(cur.substring(5), dtf);
                } catch (DateTimeParseException e) {
                    // Can occur during parsing (wrong format date), so need to throw InputMismatchException instead
                    throw new InputMismatchException();
                }
            } else if (checker(cur, "TEL")) {
                if (!cur.contains(":")) {
                    throw new InputMismatchException();
                }
                String phone = cur.substring(cur.indexOf(':') + 1);
                if (!phone.matches("\\d{10}")) {
                    // Regular Expressions
                    throw new InputMismatchException();
                }
                phoneTypeNumber.put(cur.substring(cur.indexOf('=') + 1, cur.indexOf(':')), phone);
            } else if (cur.equals("END:VCARD") && !scanner.hasNextLine()) {
                // END:VCARD should be the last line
                checkForRequiredFields++;
                break;
            } else {
                // Wrong format of info
                throw new InputMismatchException();
            }
        }
        if (checkForRequiredFields != numberOfRequiredField) {
            // Not enough required fields
            throw new NoSuchElementException();
        }
        return this;
    }

    /**
     * Additional method which checks for a match at the beginning of a line with pattern.
     * In this method regular expressions was used.
     * @param cur - our string
     * @param pattern - start pattern for check
     * @return true if beginning of cur matches with pattern
     */
    private boolean checker(String cur, String pattern) {
        return cur.matches(pattern + ".*");
    }

    @Override
    public ContactCard getInstance(String data) {
        return getInstance(new Scanner(data));
    }

    @Override
    public String getFullName() {
        return fullName;
    }

    @Override
    public String getOrganization() {
        return organization;
    }

    @Override
    public boolean isWoman() {
        return gender != '\u0000' && gender != 'M';
    }

    @Override
    public Calendar getBirthday() {
        if (birthDate == null) {
            throw new NoSuchElementException();
        }
        // Convert LocalDate to Calendar
        long epochSec = birthDate.atStartOfDay(ZoneId.systemDefault()).toEpochSecond();
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(epochSec*1000);
        return calendar;
    }

    @Override
    public Period getAge() {
        if (birthDate == null) {
            throw new NoSuchElementException();
        }
        return Period.between(birthDate, LocalDate.now());
    }

    @Override
    public int getAgeYears() {
        if (birthDate == null) {
            throw new NoSuchElementException();
        }
        return getAge().getYears();
    }

    @Override
    public String getPhone(String type) {
        if(!phoneTypeNumber.containsKey(type)) {
            throw new NoSuchElementException();
        }
        StringBuilder stringBuilder = new StringBuilder(phoneTypeNumber.get(type));
        stringBuilder.insert(0, "(");
        stringBuilder.insert(4, ")");
        stringBuilder.insert(5, " ");
        stringBuilder.insert(9, "-");
        return stringBuilder.toString();
    }
}

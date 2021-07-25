package ru.ncedu.zigal0.number;

/**
 * Class PhoneNumberParser represents convenient mechanism for converting phone number format.
 *
 * @author zigal0
 */
public abstract class PhoneNumberParser {
    public static String convert(String oldFormat) {
        StringBuilder res = new StringBuilder(oldFormat);
        if (oldFormat.matches("^[8]\\d{10}")) {
            res.replace(0, 1, "+7");
        } else if (!oldFormat.matches("^[+]\\d{11}")) {
            res.insert(0, "Wrong format: ");
            return res.toString();
        }
        res.insert(5, '-');
        res.insert(9, '-');
        return res.toString();
    }
}

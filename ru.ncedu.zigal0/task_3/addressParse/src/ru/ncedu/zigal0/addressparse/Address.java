package ru.ncedu.zigal0.addressparse;

import java.util.NoSuchElementException;
import java.util.StringTokenizer;

public class Address {
    private String country;
    private String region;
    private String city;
    private String streetName;
    private int streetNumber;
    private int building;
    private int apartment;

    public Address() {}

    public Address(String address, char delimiter) {
        parseWithOneMarkAndSpaces(address, delimiter);
    }

    public Address(String address) {
        parseWithOtherMarks(address);
    }

    public void parseWithOneMarkAndSpaces(String address, char delimiter) throws NoSuchElementException, ArrayIndexOutOfBoundsException {
        String fullDelimiter = delimiter + "\\s*";
        String[] subAddress = address.split(fullDelimiter);
        if (subAddress.length != 7) {
            throw new ArrayIndexOutOfBoundsException();
        }
        checkAndSend(subAddress);
    }

    public void parseWithOtherMarks(String address) throws NoSuchElementException, ArrayIndexOutOfBoundsException {
        StringTokenizer tokenizer = new StringTokenizer(address, " ,.;");
        if (tokenizer.countTokens() != 7) {
            throw new ArrayIndexOutOfBoundsException();
        }
        String[] subAddress = new String[7];
        for (int i = 0; i < 7; i++) {
            subAddress[i] = tokenizer.nextToken();
        }
        checkAndSend(subAddress);
    }

    private void checkAndSend(String[] subAddress) throws NoSuchElementException {
        if (!isNumeric(subAddress[4]) && !isNumeric(subAddress[5]) && !isNumeric(subAddress[6])) {
            throw new NoSuchElementException();
        }
        setAddress(subAddress[0], subAddress[1], subAddress[2], subAddress[3],
                Integer.parseInt(subAddress[4]), Integer.parseInt(subAddress[5]), Integer.parseInt(subAddress[6]));
    }

    public void setAddress(String country, String region, String city, String streetName,
                           int streetNumber, int building, int apartment) {
        this.country = country;
        this.region = region;
        this.city = city;
        this.streetName = streetName;
        this.streetNumber = streetNumber;
        this.building = building;
        this.apartment = apartment;
    }

    /**
     * Checks whether the String a valid integer.
     *
     * @param str - the String to check
     * @return true if the string is integer otherwise false
     */
    private static boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}

package ru.ncedu.zigal0.addressparse;

import java.util.Objects;
import java.util.StringTokenizer;

/**
 * Class Address represents improved version previous Class Address with parse methods.
 *
 * @author zigal0
 */
public class Address {
    private String country;
    private String region;
    private String city;
    private String streetName;
    private int streetNumber;
    private int building;
    private int apartment;

    @Override
    public int hashCode() {
        return Objects.hash(getCountry(), getRegion(), getCity(), getStreetName(), getStreetNumber(), getBuilding(), getApartment());
    }

    public Address() {
    }

    public Address(String address, String delimiter) {
        parseWithOneMarkAndSpaces(address, delimiter);
    }

    public Address(String address) {
        parseWithOtherMarks(address);
    }

    /**
     * Parses String address with given delimiter to Class Address.
     * It takes into account that quantity of spaces can be more then one and they may be in front of delimiter.
     *
     * @param address   - string with true format.
     * @param delimiter - delimiter such as [, . ;]
     * @throws NumberFormatException          - if streetNumber, building or apartment is not integer
     * @throws ArrayIndexOutOfBoundsException - if wrong format of address
     */
    public void parseWithOneMarkAndSpaces(String address, String delimiter) throws NumberFormatException, ArrayIndexOutOfBoundsException {
        String fullDelimiter = "\\s*" + delimiter + "\\s*";
        String[] subAddress = address.split(fullDelimiter);
        if (subAddress.length != 7) {
            throw new ArrayIndexOutOfBoundsException();
        }
        checkAndSend(subAddress);
    }

    /**
     * Parses String address with different delimiters to Class Address.
     *
     * @param address - string with true format.
     * @throws NumberFormatException          - if streetNumber, building or apartment is not integer
     * @throws ArrayIndexOutOfBoundsException - if wrong format of address
     */
    public void parseWithOtherMarks(String address) throws NumberFormatException, ArrayIndexOutOfBoundsException {
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

    /**
     * Checks if streetNumber, building or apartment is integer.
     *
     * @param subAddress - array with parsed info
     * @throws NumberFormatException - if streetNumber, building or apartment is not integer
     */
    private void checkAndSend(String[] subAddress) throws NumberFormatException {
        if (!isNumeric(subAddress[4]) || !isNumeric(subAddress[5]) || !isNumeric(subAddress[6])) {
            throw new NumberFormatException();
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

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof Address)) {
            return false;
        }
        Address that = (Address) other;

        return this.country.equals(that.getCountry()) &&
                this.region.equals(that.getRegion()) &&
                this.city.equals(that.getCity()) &&
                this.streetName.equals(that.getStreetName()) &&
                this.streetNumber == that.getStreetNumber() &&
                this.building == that.getBuilding() &&
                this.apartment == that.getApartment();
    }

    public String getCountry() {
        return country;
    }

    public String getRegion() {
        return region;
    }

    public String getCity() {
        return city;
    }

    public String getStreetName() {
        return streetName;
    }

    public int getStreetNumber() {
        return streetNumber;
    }

    public int getBuilding() {
        return building;
    }

    public int getApartment() {
        return apartment;
    }
}

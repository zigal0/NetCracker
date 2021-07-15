package ru.ncedu.zigal0.address;

/**
 * Class Address represents class for storing address (street name, street number, apartment number).
 */
public class Address {
    private final String streetName;
    private final int streetNumber;
    private final int aptNumber;

    public Address(String address) {
        String delimiter = " ";
        String[] subAddress = address.split(delimiter);
        this.streetName = subAddress[0];
        this.streetNumber = Integer.parseInt(subAddress[1]);
        this.aptNumber = Integer.parseInt(subAddress[2]);
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Address)) {
            return false;
        }
        Address other = (Address) obj;
        return other.getStreetName().equals(this.getStreetName())
                && other.getStreetNumber() == this.streetNumber && other.getAtNumber() == this.aptNumber;
    }

    @Override
    public int hashCode() {
        return streetName.hashCode() + streetNumber * 25 + aptNumber * 25;
    }

    public String toOutput() {
        return getStreetName() + " " + getStreetNumber() + " " + getAtNumber();
    }

    public String getStreetName() {
        return streetName;
    }

    public int getStreetNumber() {
        return streetNumber;
    }

    public int getAtNumber() {
        return aptNumber;
    }
}

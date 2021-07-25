package ru.ncedu.zigal0.shirt;

/**
 * Class Shirt represents info about shirt.
 *
 * @author zigal0
 */
public class Shirt {
    private String id;
    private String description;
    private String color;
    private String size;

    public Shirt() {
    }

    public Shirt(String stringShirt) {
        parseStringShirt(stringShirt);
    }

    /**
     * Parse String stringShirt with delimiter "," t Class Shirt.
     * It takes into account that quantity of spaces can be more then one and they may be in front of delimiter.
     *
     * @param stringShirt - string with true shirt info format
     * @throws ArrayIndexOutOfBoundsException - if wrong format of shirt info
     */
    private void parseStringShirt(String stringShirt) throws ArrayIndexOutOfBoundsException {
        String delimiter = "\\s*,\\s*";
        String[] subShirt = stringShirt.split(delimiter);
        if (subShirt.length != 4) {
            System.out.println(subShirt.length);
            throw new ArrayIndexOutOfBoundsException();
        }
        id = subShirt[0];
        description = subShirt[1];
        color = subShirt[2];
        size = subShirt[3];
    }

    public void setShirt(String stringShirt) {
        parseStringShirt(stringShirt);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("id: ");
        stringBuilder.append(id);
        stringBuilder.append("\n");
        stringBuilder.append("description: ");
        stringBuilder.append(description);
        stringBuilder.append("\n");
        stringBuilder.append("color: ");
        stringBuilder.append(color);
        stringBuilder.append("\n");
        stringBuilder.append("size: ");
        stringBuilder.append(size);
        return stringBuilder.toString();
    }
}

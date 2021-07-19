package ru.skillbench.tasks.basics.entity;

public class LocationImpl implements Location {

    private String name;
    private Type type;
    private Location parent = null;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Type getType() {
        return type;
    }

    @Override
    public void setType(Type type) {
        this.type = type;
    }

    @Override
    public void setParent(Location parent) {
        this.parent = parent;
    }

    @Override
    public String getParentName() {
        return (parent == null) ? "--" : parent.getName();
    }

    @Override
    public Location getTopLocation() {
        if (parent != null) {
            return parent.getTopLocation();
        } else {
            return this;
        }
    }

    @Override
    public boolean isCorrect() {
        if (parent == null) {
            return true;
        } else return type.compareTo(parent.getType()) > 0;
    }

    @Override
    public String getAddress() {
        String delimiter = " ";
        String[] subName = name.split(delimiter);
        String res = name;
        if (subName[0].charAt(subName[0].length() - 1) != '.' && name.charAt(name.length() - 1) != '.') {
            res = type.getNameForAddress() + name;
        }
        if (parent != null) {
            return res + ", " + parent.getAddress();
        } else {
            return res;
        }
    }

    @Override
    public String toString() {
        return name + " (" + type.toString() + ")";
    }
}

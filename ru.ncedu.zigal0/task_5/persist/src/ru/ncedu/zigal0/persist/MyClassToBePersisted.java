package ru.ncedu.zigal0.persist;

import java.io.Serializable;

/**
 * Class MyClassToBePersisted represents storage for som info.
 *
 * @author zigal0
 */
public class MyClassToBePersisted implements Serializable {
    private String profile;
    private int group;

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public int getGroup() {
        return group;
    }

    public void setGroup(int group) {
        this.group = group;
    }

    @Override
    public String toString() {
        return "[profile = " + getProfile() + "; group = " + getGroup() + "]";
    }
}

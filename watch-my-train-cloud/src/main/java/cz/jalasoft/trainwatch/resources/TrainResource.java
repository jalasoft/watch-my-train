package cz.jalasoft.trainwatch.resources;

import java.util.Optional;

/**
 * @author Honza Lastovicka (lastovicka@avast.com)
 * @since 9/6/15.
 */
public class TrainResource {

    private String number;
    private String name;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String nameOrEmpty() {
        return name != null ? name : "";
    }

    private String numberOrEmpty() {
        return number != null ? number : "";
    }

    public String getFullName() {
        return (nameOrEmpty() + " " + numberOrEmpty()).trim();
    }

    public boolean isEmpty() {
        return getFullName().isEmpty();
    }
}

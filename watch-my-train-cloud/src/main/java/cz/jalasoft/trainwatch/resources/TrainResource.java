package cz.jalasoft.trainwatch.resources;

import java.util.Optional;

/**
 * @author Honza Lastovicka (lastovicka@avast.com)
 * @since 9/6/15.
 */
public class TrainResource {

    private Optional<String> maybeNumber;
    private Optional<String> maybeName;

    public String getNumber() {
        return maybeNumber.orElse("");
    }

    public void setNumber(String number) {
        this.maybeNumber = Optional.ofNullable(number);
    }

    public String getMaybeName() {
        return maybeName.orElse("");
    }

    public void setMaybeName(String name) {
        this.maybeName = Optional.ofNullable(name);
    }

    public String getFullName() {
        return (maybeNumber.orElse("") + " " + maybeName.orElse("")).trim();
    }

    public boolean isEmpty() {
        return getFullName().isEmpty();
    }
}

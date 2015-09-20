package cz.jalasoft.trainwatch.domain.model.observer;

/**
 * @author Honza Lastovicka (lastovicka@avast.com)
 * @since 9/16/15.
 */
public final class Nickname {

    private String value;

    public Nickname(String value) {
        setValue(value);
    }

    private void setValue(String value) {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException("Nickname must not be null or empty.");
        }
        this.value = value.trim();
    }

    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Nickname that = (Nickname) o;

        return this.value.equals(that.value());
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = result * 37 + value().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return new StringBuilder("Nickname[")
                .append(value)
                .append(']')
                .toString();
    }
}

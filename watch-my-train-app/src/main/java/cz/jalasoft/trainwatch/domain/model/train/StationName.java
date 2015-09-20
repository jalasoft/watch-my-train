package cz.jalasoft.trainwatch.domain.model.train;

/**
 * @author Honza Lastovicka
 * @since 16.8.15
 */
public final class StationName {

    private String name;

    public StationName(String name) {
        setName(name);
    }

    public StationName(StationName station) {
        this(station.name());
    }

    private void setName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Station number must notbe null or empty.");
        }
        this.name = name;
    }

    public String name() {
        return name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof StationName)) {
            return false;
        }

        StationName that = (StationName) obj;

        return this.name().equals(that.name());
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = result * 37 + name().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return new StringBuilder("Station[")
                .append(name())
                .append("]")
                .toString();
    }
}

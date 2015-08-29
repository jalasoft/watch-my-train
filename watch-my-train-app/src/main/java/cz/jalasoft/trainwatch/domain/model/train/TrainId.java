package cz.jalasoft.trainwatch.domain.model.train;

import java.util.Optional;

/**
 * @author Honza Lastovicka
 * @since 13.8.15
 */
public final class TrainId {

    private String number;
    private String name;

    public TrainId(String number, String name) {
        setNumber(number);
        setName(name);
    }

    public TrainId(TrainId id) {
        this(id.number(), id.name().orElse(null));
    }

    private void setNumber(String number) {
        if (number == null || number.isEmpty()) {
            throw new IllegalArgumentException("Train number must not be null or empty");
        }
        this.number = number;
    }

    private void setName(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("Name might be null but not be empty.");
        }
        this.name = name;
    }

    public String number() {
        return number;
    }

    public Optional<String> name() {
        return Optional.ofNullable(name);
    }

    public String fullName() {
        return number() + name().orElse("");
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof TrainId)) {
            return false;
        }

        TrainId that = (TrainId) obj;

        return this.number().equals(that.number());
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = result * 37 + number().hashCode();
        return result;
    }

    @Override
    public String toString() {
        StringBuilder bldr = new StringBuilder("TrainId[")
                .append(number);

        name().ifPresent(n -> bldr.append(", " + n));

        return bldr
                .append("]")
                .toString();
    }
}

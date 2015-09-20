package cz.jalasoft.trainwatch.domain.model.train;

/**
 * An exception that indicates that a train of given number
 * is not found.
 *
 * @author Honza Lastovicka (lastovicka@avast.com)
 * @since 9/15/15.
 */
public final class TrainNotFound extends Exception {

    private static final String MESSAGE_PATTERN = "Train of number %s was not found.";

    private final String number;

    public TrainNotFound(String number) {
        this.number = number;
    }

    public String number() {
        return number;
    }

    @Override
    public String getMessage() {
        return String.format(MESSAGE_PATTERN, number());
    }
}

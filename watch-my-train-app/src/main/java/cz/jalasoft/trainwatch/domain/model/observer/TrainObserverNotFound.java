package cz.jalasoft.trainwatch.domain.model.observer;

/**
 * An exception that indicates that requested train observer is not registered.
 *
 * @author Honza Lastovicka (lastovicka@avast.com)
 * @since 9/15/15.
 */
public final class TrainObserverNotFound extends Exception {

    private static final String MESSAGE_PATTERN = "Train observer with nickname %s was not found.";

    private Nickname nickname;

    public TrainObserverNotFound(Nickname nickname) {
        this.nickname = nickname;
    }

    public String nickname() {
        return nickname.value();
    }

    @Override
    public String getMessage() {
        return String.format(MESSAGE_PATTERN, nickname());
    }
}

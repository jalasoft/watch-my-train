package cz.jalasoft.trainwatch.domain.model.observer;

import cz.jalasoft.trainwatch.domain.model.train.TrainName;

/**
 * @author Honza Lastovicka
 * @since 17.8.15
 */
public class TrainObserver {

    private String nickname;

    public TrainObserver(String nickname) {
        setNickname(nickname);
    }

    private void setNickname(String nickname) {
        if (this.nickname != null) {
            throw new IllegalStateException("Nickname cannot be reinitialized.");
        }

        if (nickname == null) {
            throw new IllegalArgumentException("Nickname must not be null");
        }

        if (nickname.isEmpty()) {
            throw new IllegalArgumentException("Nickname must not be empty");
        }
        this.nickname = nickname;
    }

    public String nickname() {
        return nickname;
    }

    public void startObserving(TrainName train) {

    }

    public void stopObserving(TrainName train) {

    }
}

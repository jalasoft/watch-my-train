package cz.jalasoft.trainwatch.domain.model.observer;

import cz.jalasoft.trainwatch.domain.model.train.TrainNumber;

import java.util.Collection;

/**
 * @author Honza Lastovicka
 * @since 17.8.15
 */
public class TrainObserver {

    private Nickname nickname;
    private WatchList watchList;

    public TrainObserver(Nickname nickname, WatchList watchList) {
        setNickname(nickname);
        setWatchList(watchList);
    }

    private void setNickname(Nickname nickname) {
        if (this.nickname != null) {
            throw new IllegalStateException("Nickname cannot be reinitialized.");
        }

        if (nickname == null) {
            throw new IllegalArgumentException("Nickname must not be null");
        }

        this.nickname = nickname;
    }

    private void setWatchList(WatchList watchList) {
        if (watchList == null) {
            throw new IllegalArgumentException("Watch list must not be null.");
        }
        this.watchList = watchList;
    }

    public Nickname nickname() {
        return nickname;
    }

    public void watchTrain(TrainNumber trainNumber) {
        watchList.watchTrain(trainNumber);
    }

    public void notWatchTrain(TrainNumber trainNumber) {
        watchList.notWatchTrain(trainNumber);
    }

    public Collection<TrainNumber> watchedTrains() {
        return watchList.all();
    }
}

package cz.jalasoft.trainwatch.domain.model.observer;

import cz.jalasoft.trainwatch.domain.model.train.Train;
import cz.jalasoft.trainwatch.domain.model.train.TrainNumber;

import java.util.ArrayList;
import java.util.Collection;
import java.util.function.Consumer;

/**
 * @author Honza Lastovicka
 * @since 17.8.15
 */
public final class WatchList {

    static WatchList empty() {
        return new WatchList();
    }

    private Collection<TrainNumber> watchedTrains;

    private Collection<TrainNumber> trainsToWatch;
    private Collection<TrainNumber> trainsStopToWatch;

    void watchTrain(TrainNumber number) {

    }

    void notWatchTrain(TrainNumber number) {

    }

    void forEach(Consumer<TrainNumber> consumer) {
        watchedTrains.stream().forEach(consumer);
    }

    Collection<TrainNumber> all() {
        return new ArrayList<>(watchedTrains);
    }
}

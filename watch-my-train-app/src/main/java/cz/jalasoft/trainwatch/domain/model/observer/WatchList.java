package cz.jalasoft.trainwatch.domain.model.observer;

import cz.jalasoft.trainwatch.domain.model.train.TrainName;

import java.util.Collection;
import java.util.function.Consumer;

/**
 * @author Honza Lastovicka
 * @since 17.8.15
 */
public class WatchList {

    public static WatchList empty() {
        return new WatchList();
    }

    private Collection<TrainName> watchedTrains;

    private Collection<TrainName> trainsToWatch;
    private Collection<TrainName> trainsStopToWatch;

    public void watchTrain(TrainName trainId) {
        trainsToWatch.contains(trainId);
    }

    public void stopWatchingTrain(TrainName trainId) {
        trainsStopToWatch.add(trainId);
    }

    public void forEachTrain(Consumer<TrainName> consumer) {
        //TODO
    }
}

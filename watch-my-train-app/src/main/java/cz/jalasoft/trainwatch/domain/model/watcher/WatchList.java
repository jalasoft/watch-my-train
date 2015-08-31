package cz.jalasoft.trainwatch.domain.model.watcher;

import cz.jalasoft.trainwatch.domain.model.train.TrainId;

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

    private Collection<TrainId> watchedTrains;

    private Collection<TrainId> trainsToWatch;
    private Collection<TrainId> trainsStopToWatch;

    public void watchTrain(TrainId trainId) {
        trainsToWatch.contains(trainId);
    }

    public void stopWatchingTrain(TrainId trainId) {
        trainsStopToWatch.add(trainId);
    }

    public void forEachTrain(Consumer<TrainId> consumer) {
        //TODO
    }
}

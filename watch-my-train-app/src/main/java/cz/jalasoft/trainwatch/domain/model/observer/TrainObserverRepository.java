package cz.jalasoft.trainwatch.domain.model.observer;

import java.util.Collection;

/**
 * @author Honza Lastovicka
 * @since 17.8.15
 */
public interface TrainObserverRepository {

    void addObserver(TrainObserver observer);

    Collection<TrainObserver> allObservers();
}

package cz.jalasoft.trainwatch.infrastructure.persistence;

import cz.jalasoft.trainwatch.domain.model.observer.TrainObserver;
import cz.jalasoft.trainwatch.domain.model.observer.TrainObserverRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author Honza Lastovicka (lastovicka@avast.com)
 * @since 9/6/15.
 */
@Component("inMemoryTrainObserversRepository")
public class InMemoryTrainObserverRepository implements TrainObserverRepository {

    private final Collection<TrainObserver> observers;

    public InMemoryTrainObserverRepository() {
        observers = new ArrayList<>();
    }

    @Override
    public void addObserver(TrainObserver observer) {
        observers.add(observer);
    }

    @Override
    public Collection<TrainObserver> allObservers() {
        return new ArrayList<>(observers);
    }
}

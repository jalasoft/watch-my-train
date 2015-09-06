package cz.jalasoft.trainwatch.infrastructure.persistence;

import cz.jalasoft.trainwatch.domain.model.observer.TrainObserver;
import cz.jalasoft.trainwatch.domain.model.observer.TrainObserverRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Honza Lastovicka (lastovicka@avast.com)
 * @since 9/6/15.
 */
@Component("inMemoryTrainObserversRepository")
public class InMemoryTrainObserverRepository implements TrainObserverRepository {

    private final Map<String, TrainObserver> observers;

    public InMemoryTrainObserverRepository() {
        observers = new HashMap<>();
    }

    @Override
    public void addObserver(TrainObserver observer) {
        observers.put(observer.nickname(), observer);
    }

    @Override
    public Collection<TrainObserver> allObservers() {
        return new ArrayList<>(observers.values());
    }

    @Override
    public void removeObserver(TrainObserver observer) {
        observers.remove(observer.nickname());
    }

    @Override
    public TrainObserver ofNickname(String nickname) {

        TrainObserver observer = observers.get(nickname);

        if (observer == null) {
            throw new IllegalArgumentException("Unexpected nickiname " + nickname);
        }
        return observer;
    }
}
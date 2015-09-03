package cz.jalasoft.trainwatch.application;

import cz.jalasoft.trainwatch.domain.model.observer.TrainObserver;
import cz.jalasoft.trainwatch.domain.model.observer.TrainObserverRepository;

/**
 * @author Honza Lastovicka (lastovicka@avast.com)
 * @since 8/29/15.
 */
public class TrainObserverApplicationService {

    private TrainObserverRepository observerRepository;

    public TrainObserver registerObserver(String nickname) {
        if (nickname == null || nickname.isEmpty()) {
            throw new IllegalArgumentException("Watcher name must not be null or empty.");
        }

        TrainObserver observer = new TrainObserver(nickname);
        observerRepository.addObserver(observer);

        return observer;
    }


}

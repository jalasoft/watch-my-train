package cz.jalasoft.trainwatch.application;

import cz.jalasoft.trainwatch.domain.model.observer.TrainObserver;
import cz.jalasoft.trainwatch.domain.model.observer.TrainObserverRepository;
import cz.jalasoft.trainwatch.domain.model.train.TrainName;
import cz.jalasoft.trainwatch.domain.model.train.TrainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;

/**
 * @author Honza Lastovicka (lastovicka@avast.com)
 * @since 8/29/15.
 */
@Component("trainObserverService")
public class TrainObserverApplicationService {

    @Autowired
    private TrainObserverRepository observerRepository;

    @Autowired
    private TrainRepository trainRepository;

    public TrainObserver registerObserver(String nickname) {
        checkNickname(nickname);

        TrainObserver observer = new TrainObserver(nickname);
        observerRepository.addObserver(observer);

        return observer;
    }

    public void unregisterObserver(String nickname) {
        checkNickname(nickname);

        TrainObserver observer = observerRepository.observerOfNickname(nickname);
        observerRepository.removeObserver(observer);
    }

    private void checkNickname(String nickname) {
        if (nickname == null || nickname.isEmpty()) {
            throw new IllegalArgumentException("Nickname of an observer must not be null or empty.");
        }
    }

    public Collection<TrainObserver> registeredObservers() {
        Collection<TrainObserver> observers = observerRepository.allObservers();
        return observers;
    }

    public void observeTrain(String nickname, String trainNumber) {
        checkNickname(nickname);

        TrainObserver observer = observerRepository.observerOfNickname(nickname);
        TrainName train = null; //TODO

        observer.startObserving(train);
    }

    public void notObserveTrain(String nickname, String trainNumber) {
        checkNickname(nickname);

        TrainObserver observer = observerRepository.observerOfNickname(nickname);
        trainRepository.lookupTrain(trainNumber);

        TrainName train = null; //TODO

        observer.stopObserving(train);
    }

    public Collection<TrainName> lookupTrain(String numberOrName) {
        return trainRepository.lookupTrain(numberOrName);
    }
}

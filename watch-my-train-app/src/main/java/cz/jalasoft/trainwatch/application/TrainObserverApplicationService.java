package cz.jalasoft.trainwatch.application;

import cz.jalasoft.trainwatch.domain.model.observer.*;
import cz.jalasoft.trainwatch.domain.model.train.Train;
import cz.jalasoft.trainwatch.domain.model.train.TrainNotFound;
import cz.jalasoft.trainwatch.domain.model.train.TrainNumber;
import cz.jalasoft.trainwatch.domain.model.train.TrainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;

/**
 * An application service that serves as a collection of uses cases.
 *
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

        TrainObserver observer = new TrainObserver(new Nickname(nickname), new WatchList());
        observerRepository.addObserver(observer);

        return observer;
    }

    public void unregisterObserver(String nickname) throws TrainObserverNotFound {

        TrainObserver observer = observerRepository.observerOfNickname(new Nickname(nickname));
        observerRepository.removeObserver(observer);
    }

    private void checkTrainNumber(String trainNumber) {
        if (trainNumber == null || trainNumber.isEmpty()) {
            throw new IllegalArgumentException("Train number must not be null or empty.");
        }
    }

    public Collection<TrainObserver> registeredObservers() {
        Collection<TrainObserver> observers = observerRepository.allObservers();
        return observers;
    }

    public void observeTrain(String nickname, String trainNumber) throws TrainObserverNotFound, TrainNotFound {
        checkTrainNumber(trainNumber);

        Train train = trainRepository.trainOfNumber(trainNumber);
        TrainObserver observer = observerRepository.observerOfNickname(new Nickname(nickname));

        observer.watchTrain(train.number());
    }

    public void notObserveTrain(String nickname, String trainNumber) throws TrainObserverNotFound, TrainNotFound {
        checkTrainNumber(trainNumber);

        TrainObserver observer = observerRepository.observerOfNickname(new Nickname(nickname));
        Train train = trainRepository.trainOfNumber(trainNumber);

        observer.notWatchTrain(train.number());
    }

    public Collection<TrainNumber> lookupTrain(String numberOrName) {
        return trainRepository.lookupTrain(numberOrName);
    }
}

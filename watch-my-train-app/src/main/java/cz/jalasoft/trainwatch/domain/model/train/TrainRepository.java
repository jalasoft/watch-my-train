package cz.jalasoft.trainwatch.domain.model.train;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;

/**
 * @author Honza Lastovicka
 * @since 17.8.15
 */
@Component
public class TrainRepository {

    @Autowired
    private TrainOnlineInfoService trainInfoService;

    public Collection<TrainNumber> lookupTrain(String trainNameOrNumber) {
        return trainInfoService.lookupTrain(trainNameOrNumber);
    }

    public Train trainOfNumber(String number) throws TrainNotFound {
        Collection<TrainNumber> trains = lookupTrain(number);

        if (trains.size() != 1) {
            throw new TrainNotFound(number);
        }
        TrainNumber trainNumber = trains.stream().findFirst().get();

        return new Train(trainNumber, trainInfoService);
    }
}

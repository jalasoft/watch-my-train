package cz.jalasoft.trainwatch.infrastructure.persistence;

import cz.jalasoft.trainwatch.domain.model.train.TrainNumber;
import cz.jalasoft.trainwatch.domain.model.train.TrainOnlineInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static java.util.stream.Collectors.toCollection;

/**
 * @author Honza Lastovicka (lastovicka@avast.com)
 * @since 9/13/15.
 */
@Component
public class MockedTrainOnlineInfoService implements TrainOnlineInfoService {

    @Autowired
    private List<TrainNumber> fakeTrains;

    @Override
    public Collection<TrainNumber> lookupTrain(String trainNameOrNumber) {

        return fakeTrains
                .stream()
                .filter(train -> train.fullName().contains(trainNameOrNumber))
                .collect(toCollection(ArrayList::new));
    }
}

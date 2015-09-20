package cz.jalasoft.trainwatch.resources.train;

import cz.jalasoft.trainwatch.application.TrainObserverApplicationService;
import cz.jalasoft.trainwatch.domain.model.train.TrainNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;

import static java.util.stream.Collectors.*;

/**
 * @author Honza Lastovicka (lastovicka@avast.com)
 * @since 9/9/15.
 */
@RestController
@RequestMapping(path = "/train")
public class TrainEndpoint {

    @Autowired
    private TrainObserverApplicationService observerService;

    @RequestMapping(path = "/{numberOrName}", method = RequestMethod.POST)
    public Collection<TrainResource> lookupTrains(@PathVariable String numberOrName) {
        Collection<TrainNumber> trains = observerService.lookupTrain(numberOrName);

        return trains.stream()
                .map(
                        train -> new TrainResourceAssembler(train)
                                .withSelfLink()
                                .resource())
                .collect(toCollection(ArrayList::new));
    }
}

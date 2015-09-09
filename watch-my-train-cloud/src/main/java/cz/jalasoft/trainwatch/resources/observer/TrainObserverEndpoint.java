package cz.jalasoft.trainwatch.resources.observer;

import cz.jalasoft.trainwatch.application.TrainObserverApplicationService;
import cz.jalasoft.trainwatch.domain.model.observer.TrainObserver;
import cz.jalasoft.trainwatch.resources.InvalidTrainObserverResource;
import cz.jalasoft.trainwatch.resources.InvalidTrainResource;
import cz.jalasoft.trainwatch.resources.train.TrainResource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

/**
 * @author Honza Lastovicka (lastovicka@avast.com)
 * @since 8/24/15.
 */
@RestController
@RequestMapping(path = "/observer")
public class TrainObserverEndpoint {

    private static final Logger LOGGER = LoggerFactory.getLogger(TrainObserverEndpoint.class);

    @Autowired
    private TrainObserverApplicationService observerService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<TrainObserverResource> registerObserver(@RequestBody TrainObserverResource resource)  {
        checkTrainObserverResource(resource);

        String nickname = resource.getNickname();

        LOGGER.debug("A new train observer is being created with nickname: {}", nickname);

        TrainObserver newObserver = observerService.registerObserver(nickname);

        TrainObserverResource newResource = new TrainObserverResourceAssembler(newObserver)
                .withSelfLink()
                .withRegisteredObserversLink()
                .withUnregisterObserverLink()
                .resource();

        //HttpHeaders headers = new HttpHeaders();
        //headers.setLocation(selfLinkBuilder.toUri());

        return new ResponseEntity<>(newResource, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Collection<TrainObserverResource>> registeredObservers() {

        Collection<TrainObserver> observers = observerService.registeredObservers();

        if (observers.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        Collection<TrainObserverResource> resources =
                observers.stream().map(observer ->
                        new TrainObserverResourceAssembler(observer).withSelfLink().resource()
                                    )
                                    .collect(Collectors.toCollection(ArrayList::new));

        return new ResponseEntity<>(resources, HttpStatus.ACCEPTED);
    }

    @RequestMapping(value = "/{nickname}", method = RequestMethod.PUT)
    public void observeTrain(@PathVariable String nickname, TrainResource train) {
        checkNickname(nickname);
        checkTrainResource(train);

        observerService.observeTrain(nickname, train.getFullName());
    }

    @RequestMapping(value = "/{nickname}/{trainNumber}", method = RequestMethod.DELETE)
    public void notObserveTrain(@PathVariable String nickname, @PathVariable String trainNumber) {
        checkNickname(nickname);
        checkTrainNumber(trainNumber);

        //TODO
    }

    @RequestMapping(value= "/{nickname}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> unregisterObserver(@PathVariable String nickname) {
        checkNickname(nickname);

        observerService.unregisterObserver(nickname);

        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    private void checkTrainObserverResource(TrainObserverResource observer) {
        if (observer == null) {
            throw new InvalidTrainObserverResource("Observer of trains must not be null.");
        }
        checkNickname(observer.getNickname());
    }

    private void checkNickname(String nickname) {
        if (nickname == null || nickname.isEmpty()) {
            throw new InvalidTrainObserverResource("Nick name of an observer must not be null or empty.");
        }
    }

    private void checkTrainResource(TrainResource train) {
        if (train == null) {
            throw new InvalidTrainResource("Train resource must not be null.");
        }

        if (train.isEmpty()) {
            throw new InvalidTrainResource("Train resource must not be empty.");
        }
    }

    private void checkTrainNumber(String trainNumber) {
        if (trainNumber == null || trainNumber.isEmpty()) {
            throw new InvalidTrainResource("Train number must not be null or empty.");
        }
    }
}

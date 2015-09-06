package cz.jalasoft.trainwatch.resources;

import cz.jalasoft.trainwatch.application.TrainObserverApplicationService;
import cz.jalasoft.trainwatch.domain.model.observer.TrainObserver;
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
public class ObserverEndpoint {

    private static final Logger LOGGER = LoggerFactory.getLogger(ObserverEndpoint.class);

    @Autowired
    private TrainObserverApplicationService observerService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<TrainObserverResource> registerObserver(@RequestBody TrainObserverResource resource)  {
        checkTrainObserver(resource);

        String nickname = resource.getNickname();

        LOGGER.debug("A new train observer is being created with nickname: {}", nickname);

        TrainObserver newObserver = observerService.registerObserver(nickname);

        TrainObserverResource newResource = new ObserverAssembler(newObserver)
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
                        new ObserverAssembler(observer).withSelfLink().resource()
                                    )
                                    .collect(Collectors.toCollection(ArrayList::new));

        return new ResponseEntity<>(resources, HttpStatus.ACCEPTED);
    }

    @RequestMapping(value= "/{nickname}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> unregisterObserver(@PathVariable String nickname) {
        checkNickname(nickname);

        observerService.unregisterObserver(nickname);

        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    private void checkTrainObserver(TrainObserverResource observer) {
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

}

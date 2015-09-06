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
    public ResponseEntity<ObserverResource> registerObserver(@RequestBody ObserverResource resource)  {
        String nickname = resource.getNickname();

        if (nickname == null || nickname.isEmpty()) {
            throw new InvalidObserverException("Nickname of an observer must not be null or empty");
        }

        LOGGER.debug("A new train observer is being created with nickname: {}", nickname);

        TrainObserver newObserver = observerService.registerObserver(nickname);

        ObserverResource newResource = new ObserverAssembler(newObserver)
                .withSelfLink()
                .withRegisteredObserversLink()
                .withUnregisterObserverLink()
                .resource();

        //HttpHeaders headers = new HttpHeaders();
        //headers.setLocation(selfLinkBuilder.toUri());

        return new ResponseEntity<>(newResource, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Collection<ObserverResource>> registeredObservers() {

        Collection<TrainObserver> observers = observerService.registeredObservers();

        Collection<ObserverResource> resources =
                observers.stream().map(observer ->
                        new ObserverAssembler(observer).withSelfLink().resource()
                                    )
                                    .collect(Collectors.toCollection(ArrayList::new));

        if (resources.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<Collection<ObserverResource>>(resources, HttpStatus.ACCEPTED);
    }

    @RequestMapping(value= "/{nickname}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> unregisterObserver(@PathVariable String nickname) {
        if (nickname == null || nickname.isEmpty()) {
            throw new InvalidObserverException("Nick name of an observer must not be null or empty.");
        }

        observerService.unregisterObserver(nickname);

        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}

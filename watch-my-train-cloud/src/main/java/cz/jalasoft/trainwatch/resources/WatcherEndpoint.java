package cz.jalasoft.trainwatch.resources;

import cz.jalasoft.trainwatch.application.TrainWatchApplicationService;
import cz.jalasoft.trainwatch.domain.model.watcher.Watcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

/**
 * @author Honza Lastovicka (lastovicka@avast.com)
 * @since 8/24/15.
 */
@RestController
@RequestMapping(path = "/watcher")
public class WatcherEndpoint {

    public static final Logger LOGGER = LoggerFactory.getLogger(WatcherEndpoint.class);

    private TrainWatchApplicationService watcherService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<WatcherResource> createWatcher(@RequestBody WatcherResource watcher) {

        String name = watcher.getName();
        if (name == null || name.isEmpty()) {
            throw new InvalidWatcherException("WatcherResource name must not be null or empty");
        }

        LOGGER.debug("A new watcher is being created: {}", watcher.getName());

        ControllerLinkBuilder selfLinkBuilder = linkTo(WatcherEndpoint.class).slash(name);

        Link selfLink = selfLinkBuilder.withSelfRel();
        watcher.add(selfLink);

        Watcher newWatcher = watcherService.registerWatcher(name);


        Link allLink = linkTo(methodOn(WatcherEndpoint.class).allWatchers()).withRel("all");
        watcher.add(allLink);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(selfLinkBuilder.toUri());

        return new ResponseEntity<WatcherResource>(watcher, headers, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<WatcherCollectionResource> allWatchers() {

        ControllerLinkBuilder selfLinkBuilder = ControllerLinkBuilder.linkTo(WatcherEndpoint.class);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(selfLinkBuilder.toUri());

        if (watchers.isEmpty()) {
            return new ResponseEntity<WatcherCollectionResource>(HttpStatus.NO_CONTENT);
        }

        WatcherCollectionResource allWatchers = new WatcherCollectionResource(watchers);
        allWatchers.add(selfLinkBuilder.withSelfRel());

        return new ResponseEntity<WatcherCollectionResource>(allWatchers, headers, HttpStatus.ACCEPTED);
    }

    @RequestMapping(value= "/{watcherName}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteWatcher(@PathVariable String watcherName) {

        if (watcherName == null || watcherName.isEmpty()) {
            throw new InvalidWatcherException("WatcherResource name must not be null or empty.");
        }

        boolean removed = false;
        Iterator<WatcherResource> it = watchers.iterator();
        while(it.hasNext()) {
            WatcherResource w = it.next();

            if (w.getName().equals(watcherName)) {
                it.remove();
                removed = true;
            }
        }

        if (!removed) {
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Void>(HttpStatus.FOUND);
    }
}

package cz.jalasoft.watchmytrain.cloud;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
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

    private final List<Watcher> watchers = new ArrayList<>();

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Watcher> createWatcher(@RequestBody Watcher watcher) {

        String name = watcher.getName();
        if (name == null || name.isEmpty()) {
            throw new InvalidWatcherException("Watcher name must not be null or empty");
        }

        LOGGER.debug("A new watcher is being created: {}", watcher.getName());

        ControllerLinkBuilder selfLinkBuilder = linkTo(WatcherEndpoint.class).slash(name);

        Link selfLink = selfLinkBuilder.withSelfRel();
        watcher.add(selfLink);

        watchers.add(watcher);

        Link allLink = linkTo(methodOn(WatcherEndpoint.class).allWatchers()).withRel("all");
        watcher.add(allLink);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(selfLinkBuilder.toUri());

        return new ResponseEntity<Watcher>(watcher, headers, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Watchers> allWatchers() {

        ControllerLinkBuilder selfLinkBuilder = ControllerLinkBuilder.linkTo(WatcherEndpoint.class);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(selfLinkBuilder.toUri());

        if (watchers.isEmpty()) {
            return new ResponseEntity<Watchers>(HttpStatus.NO_CONTENT);
        }

        Watchers allWatchers = new Watchers(watchers);
        allWatchers.add(selfLinkBuilder.withSelfRel());

        return new ResponseEntity<Watchers>(allWatchers, headers, HttpStatus.ACCEPTED);
    }
}

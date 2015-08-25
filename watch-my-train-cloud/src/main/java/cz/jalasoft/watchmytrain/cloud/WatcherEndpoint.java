package cz.jalasoft.watchmytrain.cloud;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author Honza Lastovicka (lastovicka@avast.com)
 * @since 8/24/15.
 */
@RestController
@RequestMapping(path = "/watcher")
public class WatcherEndpoint {

    public static final Logger LOGGER = LoggerFactory.getLogger(WatcherEndpoint.class);

    @RequestMapping(path = "/create", method = RequestMethod.POST)
    public ResponseEntity<Watcher> createWatcher(@RequestBody Watcher watcher) {

        String name = watcher.getName();
        if (name == null || name.isEmpty()) {
            throw new InvalidWatcherException("Watcher name must not be null or empty");
        }

        LOGGER.debug("A new watcher is being created: {}", watcher.getName());

        //watcher.add(new Link("localhost:8888/watcher/" + watcher.getName(), watcher.getName()));

        Link selfLink = ControllerLinkBuilder.linkTo(WatcherEndpoint.class).slash("create").withSelfRel();
        watcher.add(selfLink);

        Link watcherLink = ControllerLinkBuilder.linkTo(WatcherEndpoint.class).slash(watcher.getName()).withRel(watcher.getName());
        watcher.add(watcherLink);


        return new ResponseEntity<Watcher>(watcher, HttpStatus.CREATED);
    }
}

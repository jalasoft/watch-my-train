package cz.jalasoft.watchmytrain.cloud;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

/**
 * @author Honza Lastovicka (lastovicka@avast.com)
 * @since 8/24/15.
 */
@RestController
@RequestMapping(path = "/watcher")
public class WatcherEndpoint {

    public static final Logger LOGGER = LoggerFactory.getLogger(WatcherEndpoint.class);

    @PostConstruct
    public void init() {
        LOGGER.debug("WatcherEndpoint initialized");
    }

    @RequestMapping(path = "new", method = RequestMethod.POST)
    public void newWatcher(@RequestBody String name) {
        LOGGER.debug("Prisla message");
    }
}

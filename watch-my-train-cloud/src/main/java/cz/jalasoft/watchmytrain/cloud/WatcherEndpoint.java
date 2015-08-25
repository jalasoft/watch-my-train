package cz.jalasoft.watchmytrain.cloud;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    public Watcher createWatcher(@RequestBody Watcher watcher) {
        LOGGER.debug("A new watcher is being created: {}", watcher.getName());
        return watcher;
    }
}

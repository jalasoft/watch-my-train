package cz.jalasoft.trainwatch.domain.model.watcher;

import java.util.UUID;

/**
 * @author Honza Lastovicka (lastovicka@avast.com)
 * @since 8/31/15.
 */
public class WatcherFactory {

    public Watcher newWatcher(String name) {

        WatcherId id = WatcherId.from(UUID.randomUUID());

        return new Watcher(id, name, WatchList.empty());
    }
}

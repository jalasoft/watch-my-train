package cz.jalasoft.trainwatch.application;

import cz.jalasoft.trainwatch.domain.model.watcher.Watcher;
import cz.jalasoft.trainwatch.domain.model.watcher.WatcherFactory;
import cz.jalasoft.trainwatch.domain.model.watcher.WatcherRepository;

/**
 * @author Honza Lastovicka (lastovicka@avast.com)
 * @since 8/29/15.
 */
public class TrainWatchApplicationService {

    private WatcherFactory watcherFactory;

    private WatcherRepository watcherRepository;

    public Watcher registerWatcher(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Watcher name must not be null or empty.");
        }

        Watcher watcher = watcherFactory.newWatcher(name);
        watcherRepository.addWatcher(watcher);

        return watcher;
    }


}

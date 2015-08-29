package cz.jalasoft.trainwatch.domain.model.watcher;

/**
 * @author Honza Lastovicka
 * @since 17.8.15
 */
public interface WatcherRepository {

    Watcher newWatcher(String name);

    void addWatcher(Watcher watcher);

    void removeWatcher(WatcherId watcherId);

    Watcher getWatcherByName(String name);
}

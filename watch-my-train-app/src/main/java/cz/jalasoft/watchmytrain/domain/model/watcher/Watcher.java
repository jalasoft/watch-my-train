package cz.jalasoft.watchmytrain.domain.model.watcher;

import cz.jalasoft.watchmytrain.domain.model.train.TrainId;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author Honza Lastovicka
 * @since 17.8.15
 */
public class Watcher {

    private WatcherId id;
    private String name;
    private WatchList watchList;

    public Watcher(WatcherId id, String name, WatchList watchList) {
        this.id = id;
        this.name = name;
        this.watchList = watchList;
    }

    public void rename(String name) {
        if (name == null) {
            throw new IllegalArgumentException("Watcher name must not be null.");
        }

        String trimedName = name.trim();

        if (trimedName.isEmpty()) {
            throw new IllegalArgumentException("Watcher name must not be empty.");
        }

        this.name = name;
    }

    public WatcherId id() {
        return id;
    }

    public String name() {
        return name;
    }

    public WatchList list() {
        return watchList;
    }
}

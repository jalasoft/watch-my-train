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
    private Collection<TrainId> watchedTrains;

    public Watcher(WatcherId id, String name, Collection<TrainId> watchedTrains) {
        this.id = id;
        this.name = name;
        this.watchedTrains = watchedTrains;
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

    public String name() {
        return name;
    }

    public Iterable<TrainId> trains() {
        return new ArrayList<>(watchedTrains);
    }

}

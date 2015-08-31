package cz.jalasoft.trainwatch.domain.model.watcher;

import java.util.UUID;

/**
 * @author Honza Lastovicka
 * @since 17.8.15
 */
public final class WatcherId {

    public static WatcherId from(UUID uuid) {
        return new WatcherId(uuid);
    }

    private final UUID id;

    private WatcherId(UUID uuid) {
        this.id = uuid;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!getClass().equals(obj.getClass())) {
            return false;
        }

        WatcherId that = (WatcherId) obj;

        return this.id.equals(that.id);
    }

    public int hashCode() {
        int result = 17;
        result = result * 37 + id.hashCode();
        return result;
    }
}

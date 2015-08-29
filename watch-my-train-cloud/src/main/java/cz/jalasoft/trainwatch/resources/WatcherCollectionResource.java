package cz.jalasoft.trainwatch.resources;

import org.springframework.hateoas.ResourceSupport;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Honza Lastovicka (lastovicka@avast.com)
 * @since 8/26/15.
 */
public class WatcherCollectionResource extends ResourceSupport {

    private List<WatcherResource> watchers;

    public WatcherCollectionResource(List<WatcherResource> watchers) {
        this.watchers = new ArrayList<>(watchers);
    }

    public List<WatcherResource> getWatchers() {
        return watchers;
    }
}

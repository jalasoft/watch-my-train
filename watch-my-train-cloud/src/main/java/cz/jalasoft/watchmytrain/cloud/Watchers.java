package cz.jalasoft.watchmytrain.cloud;

import org.springframework.hateoas.ResourceSupport;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Honza Lastovicka (lastovicka@avast.com)
 * @since 8/26/15.
 */
public class Watchers extends ResourceSupport {

    private List<Watcher> watchers;

    public Watchers(List<Watcher> watchers) {
        this.watchers = new ArrayList<>(watchers);
    }

    public List<Watcher> getWatchers() {
        return watchers;
    }
}

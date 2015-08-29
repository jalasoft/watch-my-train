package cz.jalasoft.trainwatch.resources;

import org.springframework.hateoas.ResourceSupport;

/**
 * @author Honza Lastovicka (lastovicka@avast.com)
 * @since 8/24/15.
 */
public class WatcherResource extends ResourceSupport {

    private String name;

    public WatcherResource() {
        name="";
    }

    public WatcherResource(String name) {
        this.name = name;
    }

    public WatcherResource(WatcherResource watcher) {
        this.name = watcher.getName();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}

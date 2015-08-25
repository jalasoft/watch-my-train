package cz.jalasoft.watchmytrain.cloud;

import org.springframework.hateoas.ResourceSupport;

/**
 * @author Honza Lastovicka (lastovicka@avast.com)
 * @since 8/24/15.
 */
public class Watcher extends ResourceSupport {

    private String name;

    public Watcher() {
        name="";
    }

    public Watcher(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}

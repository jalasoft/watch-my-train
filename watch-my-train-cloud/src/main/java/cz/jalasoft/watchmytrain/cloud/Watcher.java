package cz.jalasoft.watchmytrain.cloud;

import java.io.Serializable;

/**
 * @author Honza Lastovicka (lastovicka@avast.com)
 * @since 8/24/15.
 */
public class Watcher implements Serializable {

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

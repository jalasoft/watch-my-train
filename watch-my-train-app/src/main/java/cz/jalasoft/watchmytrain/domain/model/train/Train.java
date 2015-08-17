package cz.jalasoft.watchmytrain.domain.model.train;

/**
 * @author Honza Lastovicka
 * @since 16.8.15
 */
public class Train {

    private TrainId id;

    public Train(TrainId id) {
        this.id = id;
    }

    public TrainId id() {
        return id;
    }

    public String fullName() {
        return id.fullName();
    }

    public Schedule schedule() {
        return null;
    }
}

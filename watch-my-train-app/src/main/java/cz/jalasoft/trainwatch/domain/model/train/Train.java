package cz.jalasoft.trainwatch.domain.model.train;

/**
 * @author Honza Lastovicka
 * @since 16.8.15
 */
public class Train {

    private TrainName name;

    public Train(TrainName name) {
        this.name = name;
    }

    public TrainName name() {
        return name;
    }

    public String fullName() {
        return name.fullName();
    }
}

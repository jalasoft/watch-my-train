package cz.jalasoft.watchmytrain.domain.model.train;

/**
 * @author Honza Lastovicka
 * @since 17.8.15
 */
public interface TrainRepository {

    void addTrain(Train train);

    void removeTrain(Train train);

    boolean isTrainTracked(TrainId trainId);

    Train getTrainById(TrainId trainId);
}

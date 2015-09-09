package cz.jalasoft.trainwatch.domain.model.train;

/**
 * @author Honza Lastovicka
 * @since 17.8.15
 */
public interface TrainRepository {

    TrainName lookupTrain(String trainNameOrNumber);
}

package cz.jalasoft.trainwatch.domain.model.train;

import java.util.Collection;

/**
 * @author Honza Lastovicka
 * @since 17.8.15
 */
public interface TrainRepository {

    Collection<TrainName> lookupTrain(String trainNameOrNumber);

    Train trainOfName(TrainName name);

}

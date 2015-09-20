package cz.jalasoft.trainwatch.domain.model.train;

import cz.jalasoft.trainwatch.domain.model.train.TrainNumber;

import java.util.Collection;

/**
 * @author Honza Lastovicka (lastovicka@avast.com)
 * @since 9/14/15.
 */
public interface TrainOnlineInfoService {

    Collection<TrainNumber> lookupTrain(String nameOrNumber);

    //TODO add further methods for retrieving info from online train service.
}

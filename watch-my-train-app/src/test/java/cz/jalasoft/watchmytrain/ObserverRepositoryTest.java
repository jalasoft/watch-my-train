package cz.jalasoft.watchmytrain;

import cz.jalasoft.trainwatch.domain.model.observer.TrainObserver;
import cz.jalasoft.trainwatch.domain.model.observer.TrainObserverRepository;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Collection;

/**
 * @author Honza Lastovicka
 * @since 19.8.15
 */
@Test(enabled = false)
public class ObserverRepositoryTest {

    private TrainObserverRepository repository;

   // @Test(groups = { "watcher" })
    public void newWatcherIsNotNull() {

        TrainObserver observer = new TrainObserver("Pepa");
        repository.addObserver(observer);
        Collection<TrainObserver> observers = repository.allObservers();


        //Assert.assertNotNull(watcher);
    }

    //@Test(expectedExceptions = {IllegalArgumentException.class})
    public void throwsExceptionDueToNullObserver() {
        repository.addObserver(null);
    }
}

package cz.jalasoft.watchmytrain;

import cz.jalasoft.trainwatch.domain.model.observer.TrainObserver;
import cz.jalasoft.trainwatch.domain.model.observer.TrainObserverRepository;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author Honza Lastovicka
 * @since 19.8.15
 */
@Test(enabled = false)
public class WatcherTest {

    private TrainObserverRepository repository;

   // @Test(groups = { "watcher" })
    public void newWatcherIsNotNull() {

        TrainObserver watcher = repository.newWatcher("Pepa");
        Assert.assertNotNull(watcher);
    }

    //@Test(expectedExceptions = {IllegalArgumentException.class})
    public void throwsExceptionDueToEmptyWatcherName() {
        repository.newWatcher("   ");
    }

    //@Test(expectedExceptions = {IllegalArgumentException.class})
    public void throwsExceptionDueToNullWatcherName() {
        repository.newWatcher(null);
    }

    //@Test
    public void addsNewWatcherAndRetrievesItByItsName() {
        TrainObserver newWatcher = repository.newWatcher("Honzales");
        repository.addWatcher(newWatcher);

        TrainObserver retrievedWatcher = repository.getWatcherByName(newWatcher.name());

        Assert.assertNotNull(retrievedWatcher);
        Assert.assertEquals(newWatcher.id(), retrievedWatcher.id());
    }

    public void jentak() {

        TrainObserver watcher = repository.getWatcherByName("Posrat");
        //watcher.list().watchTrain();

    }
}

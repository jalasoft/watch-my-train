package cz.jalasoft.watchmytrain;

import cz.jalasoft.watchmytrain.domain.model.train.TrainId;
import cz.jalasoft.watchmytrain.domain.model.watcher.Watcher;
import cz.jalasoft.watchmytrain.domain.model.watcher.WatcherRepository;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author Honza Lastovicka
 * @since 19.8.15
 */
@Test(enabled = false)
public class WatcherTest {

    private WatcherRepository repository;

   // @Test(groups = { "watcher" })
    public void newWatcherIsNotNull() {

        Watcher watcher = repository.newWatcher("Pepa");
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
        Watcher newWatcher = repository.newWatcher("Honzales");
        repository.addWatcher(newWatcher);

        Watcher retrievedWatcher = repository.getWatcherByName(newWatcher.name());

        Assert.assertNotNull(retrievedWatcher);
        Assert.assertEquals(newWatcher.id(), retrievedWatcher.id());
    }

    public void jentak() {

        Watcher watcher = repository.getWatcherByName("Posrat");
        //watcher.list().watchTrain();

    }
}

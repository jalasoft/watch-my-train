package cz.jalasoft.trainwatch.resources;

/**
 * @author Honza Lastovicka (lastovicka@avast.com)
 * @since 9/6/15.
 */
public class InvalidTrainResource extends RuntimeException {

    public InvalidTrainResource(String message) {
        super(message);
    }
}

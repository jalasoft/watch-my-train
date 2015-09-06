package cz.jalasoft.trainwatch.resources;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Honza Lastovicka (lastovicka@avast.com)
 * @since 8/25/15.
 */
@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
public class InvalidTrainObserverResource extends RuntimeException {

    public InvalidTrainObserverResource(String message) {
        super(message);
    }
}

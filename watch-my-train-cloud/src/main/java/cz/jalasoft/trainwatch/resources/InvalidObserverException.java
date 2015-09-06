package cz.jalasoft.trainwatch.resources;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Honza Lastovicka (lastovicka@avast.com)
 * @since 8/25/15.
 */
@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
public class InvalidObserverException extends RuntimeException {

    public InvalidObserverException(String message) {
        super(message);
    }
}

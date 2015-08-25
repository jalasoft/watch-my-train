package cz.jalasoft.watchmytrain.cloud;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Honza Lastovicka (lastovicka@avast.com)
 * @since 8/25/15.
 */
@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
public class InvalidWatcherException extends RuntimeException {

    public InvalidWatcherException(String message) {
        super(message);
    }
}

package co.edureka.assignment.hotelservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class ResourceAlreadyExistedException extends RuntimeException {
    public ResourceAlreadyExistedException(String message) {
        super(message);
    }
}
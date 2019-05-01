package rest.exceptionHandling.usingAdvice.exception.config;

/**
 * Created by pankaj on 4/10/2018.
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import rest.exceptionHandling.usingAdvice.exception.dto.Error;
import rest.exceptionHandling.usingAdvice.exception.dto.Errors;
import rest.exceptionHandling.usingAdvice.exception.rest.ValidationErrorMessageType;

import java.util.Collection;

import static org.springframework.http.HttpStatus.valueOf;
import static org.springframework.util.CollectionUtils.isEmpty;

@ControllerAdvice
public class ExceptionControllerAdvice {
    @Autowired
    RestExceptionMapper restExceptionMapper;
    @ExceptionHandler(Exception.class)
    public ResponseEntity exceptionHandler(Exception ex) throws IllegalAccessException, InstantiationException {
        RestException appropriateRestException = restExceptionMapper.mapToRestException((RuntimeException) ex);
        Errors errors = getErrors(appropriateRestException);
        return new ResponseEntity(errors, valueOf(appropriateRestException.getStatusCode()));
    }

    public Errors getErrors(RestException restException) {
        Errors envelope = new Errors();
        Collection<ValidationErrorMessageType> validationErrorMessageTypes = restException.getValidationErrorMessageTypes();
        if (isEmpty(validationErrorMessageTypes)) {
            Error error = new Error();
            error.setGuid("anyId");
            error.setCode(restException.getSubStatusCode() == 0 ? 0
                    : restException.getSubStatusCode());
            envelope.getErrors().add(error);
        }
        return envelope;
    }


}
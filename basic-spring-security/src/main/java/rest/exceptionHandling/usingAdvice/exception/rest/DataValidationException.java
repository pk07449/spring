package rest.exceptionHandling.usingAdvice.exception.rest;

import java.util.Collection;

/**
 * Created by pankaj on 4/9/2018.
 */
public class DataValidationException extends DiagnosticException {
    private Collection errorMessageTypes;

    public Collection getErrorMessageTypes() {
        return errorMessageTypes;
    }

    public void setErrorMessageTypes(Collection errorMessageTypes) {
        this.errorMessageTypes = errorMessageTypes;
    }
}
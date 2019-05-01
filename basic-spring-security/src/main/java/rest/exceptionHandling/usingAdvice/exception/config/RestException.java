package rest.exceptionHandling.usingAdvice.exception.config;

import java.util.Collection;

/**
 * Created by pankaj on 4/9/2018.
 */
public class RestException extends RuntimeException {
    private int subStatusCode;
    private Collection validationErrorMessageTypes;
    private String errorMessages;
    private int statusCode;

    public void setSubStatusCode(int subStatusCode) {
        this.subStatusCode = subStatusCode;
    }

    public int getSubStatusCode() {
        return subStatusCode;
    }

    public Collection getValidationErrorMessageTypes() {
        return validationErrorMessageTypes;
    }

    public void setValidationErrorMessageTypes(Collection validationErrorMessageTypes) {
        this.validationErrorMessageTypes = validationErrorMessageTypes;
    }

    public void setErrorMessages(String errorMessages) {
        this.errorMessages = errorMessages;
    }

    public String getErrorMessages() {
        return errorMessages;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }
}

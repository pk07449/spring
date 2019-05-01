package rest.exceptionHandling.usingAdvice.exception.rest;

import rest.exceptionHandling.usingAdvice.exception.config.RestException;

/**
 * Created by pankaj on 4/9/2018.
 */
public class DiagnosticException extends RestException {
    public int getSubStatusCode() {
        return 500;
    }
}

package rest.exceptionHandling.usingReslover.exception.rest;

import rest.exceptionHandling.usingReslover.exception.config.RestException;

/**
 * Created by pankaj on 4/9/2018.
 */
public class ForbiddenAccessException extends RestException {
    @Override
    public int getStatusCode() {
        return 403;
    }
}

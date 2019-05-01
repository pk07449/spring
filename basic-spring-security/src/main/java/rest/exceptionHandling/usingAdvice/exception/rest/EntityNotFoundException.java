package rest.exceptionHandling.usingAdvice.exception.rest;

/**
 * Created by pankaj on 4/9/2018.
 */
public class EntityNotFoundException extends DiagnosticException {

    @Override
    public int getStatusCode() {
        return 404;
    }
}

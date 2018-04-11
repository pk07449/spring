package rest.exceptionHandling.usingReslover.exception.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pankaj on 4/10/2018.
 */
public class Errors {
    private List<Error> errors = new ArrayList<>();
    public List<Error> getErrors() {
        return errors;
    }
}

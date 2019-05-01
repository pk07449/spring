package rest.exceptionHandling.usingReslover;

import org.springframework.http.ResponseEntity;
import org.springframework.web.method.annotation.ExceptionHandlerMethodResolver;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.ExceptionHandlerExceptionResolver;
import rest.exceptionHandling.usingReslover.exception.config.RestException;
import rest.exceptionHandling.usingReslover.exception.config.RestExceptionMapper;
import rest.exceptionHandling.usingReslover.exception.dto.Error;
import rest.exceptionHandling.usingReslover.exception.dto.Errors;
import rest.exceptionHandling.usingReslover.exception.rest.ValidationErrorMessageType;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Collection;

import static org.springframework.http.HttpStatus.valueOf;
import static org.springframework.util.CollectionUtils.isEmpty;

/**
 * Created by pankaj on 4/11/2018.
 */
public class CustomExceptionRelover implements HandlerExceptionResolver {

    private RestExceptionMapper restExceptionMapper;

    public CustomExceptionRelover(RestExceptionMapper restExceptionMapper) {
        this.restExceptionMapper = restExceptionMapper;
    }

    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest,
                                         HttpServletResponse httpServletResponse, Object o, Exception e) {
        RestException appropriateRestException = null;
        try {
            appropriateRestException = restExceptionMapper.mapToRestException((RuntimeException) e);
        } catch (InstantiationException e1) {
            e1.printStackTrace();
        } catch (IllegalAccessException e1) {
            e1.printStackTrace();
        }
        Errors errors = getErrors(appropriateRestException);

        ModelAndView modelAndView = new ModelAndView();
        int statusCode = appropriateRestException.getStatusCode();
        httpServletResponse.setStatus(statusCode);
        modelAndView.addObject(errors);
        return modelAndView;
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


package rest.exceptionHandling.usingReslover.exception.config;

import org.springframework.stereotype.Component;
import rest.exceptionHandling.usingReslover.exception.rest.*;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by pankaj on 4/9/2018.
 */
@Component
public class RestExceptionMapper {

    private Map<Class<? extends RuntimeException>, Class<? extends RestException>> restExceptionMap = new HashMap<>();

    @PostConstruct
    public void setUp() {
        restExceptionMap.put(RuntimeException.class, EntityNotFoundException.class);
    }

    public RestException mapToRestException(RuntimeException runTimeException) throws InstantiationException, IllegalAccessException {
        RestException restException = getMappedRestException(runTimeException.getClass());

        if (runTimeException instanceof DiagnosticException) {
            mapDiagnosticException((DiagnosticException) runTimeException, restException);
        }
        return restException;
    }

    private void mapDiagnosticException(DiagnosticException diagnosticExp, RestException restException) {
        restException.setSubStatusCode(diagnosticExp.getSubStatusCode());

        if (diagnosticExp instanceof DataValidationException) {
            DataValidationException dvEx = (DataValidationException) diagnosticExp;
            restException.getValidationErrorMessageTypes().addAll(dvEx.getErrorMessageTypes());
        } else if (diagnosticExp instanceof InformativeResponseException) {
            InformativeResponseException irEx = (InformativeResponseException) diagnosticExp;
            restException.getValidationErrorMessageTypes().addAll(irEx.getValidationErrorMessageTypes());
            restException.setErrorMessages(irEx.getInformativeErrorMessages());
            restException.setSubStatusCode(irEx.getSubStatusCode());
        } else if (diagnosticExp instanceof EntityNotFoundException) {
            restException.getValidationErrorMessageTypes().addAll(diagnosticExp.getValidationErrorMessageTypes());
        }
    }

    private RestException getMappedRestException(Class<? extends RuntimeException> dExClass) throws IllegalAccessException, InstantiationException {
        return restExceptionMap.get(dExClass) == null ?
                new InternalServerErrorException() : restExceptionMap.get(dExClass).newInstance();
    }

}

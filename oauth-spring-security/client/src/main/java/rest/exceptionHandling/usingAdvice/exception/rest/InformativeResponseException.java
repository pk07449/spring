package rest.exceptionHandling.usingAdvice.exception.rest;

/**
 * Created by pankaj on 4/9/2018.
 */
public class InformativeResponseException extends DiagnosticException {
    private String informativeErrorMessages;

    public String getInformativeErrorMessages() {
        return informativeErrorMessages;
    }

    public void setInformativeErrorMessages(String informativeErrorMessages) {
        this.informativeErrorMessages = informativeErrorMessages;
    }
}

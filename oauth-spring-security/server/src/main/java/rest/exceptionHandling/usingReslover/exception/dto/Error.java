package rest.exceptionHandling.usingReslover.exception.dto;

/**
 * Created by pankaj on 4/9/2018.
 */
public class Error {
    private String guid;
    private int code;

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getGuid() {
        return guid;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}

package spring.boot.propertiesValueReader.commandLine.disable;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by pankaj on 4/8/2020.
 */
@Component
public class RandomPropertyDisableService {
    public RandomPropertyDisableService(@Value("${server.port}") String port) {
        System.out.println(port);
    }
}

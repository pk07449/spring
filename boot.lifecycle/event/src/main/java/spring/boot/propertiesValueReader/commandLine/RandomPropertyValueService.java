package spring.boot.propertiesValueReader.commandLine;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by pankaj on 4/8/2020.
 */
@Component
public class RandomPropertyValueService {
    public RandomPropertyValueService(@Value("${server.port}") String port) {
        System.out.println(port);
    }
}

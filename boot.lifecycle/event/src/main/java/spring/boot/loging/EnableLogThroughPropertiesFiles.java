package spring.boot.loging;

/**
 * Created by pankaj on 10/28/2017.
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EnableLogThroughPropertiesFiles {

    public static void main(String[] args) {
        SpringApplication.run(EnableLogThroughPropertiesFiles.class, args);

//        Add following entry in application.properties in resources folder
//        To enable provide value as true and to disable provide value as false
//        spring.main.log-startup-info=false
    }
}
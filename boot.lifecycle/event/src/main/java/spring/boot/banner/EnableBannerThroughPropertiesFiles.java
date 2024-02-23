package spring.boot.banner;

/**
 * Created by pankaj on 10/28/2017.
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EnableBannerThroughPropertiesFiles {

    public static void main(String[] args) {
        SpringApplication.run(EnableBannerThroughPropertiesFiles.class, args);

//        Add following entry in application.properties in resources folder
//        To enable provide value as true and to disable provide value as false
//        spring.main.banner_mode=false
    }
}
package spring.boot.lazyInitilization;

/**
 * Created by pankaj on 10/28/2017.
 */

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LazyInitilizationThroughJavaCode {

    public static void main(String[] args) {

        //        If you want to disable lazy initialization for certain beans while using lazy initialization
//        for the rest of the application, you can explicitly set their lazy attribute to false using the @Lazy(false) annotation.

        SpringApplication app = new SpringApplication(LazyInitilizationThroughJavaCode.class);
        app.setLazyInitialization(false);
        app.run(args);

    }
}
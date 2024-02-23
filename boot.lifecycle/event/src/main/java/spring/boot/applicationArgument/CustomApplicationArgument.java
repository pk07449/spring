package spring.boot.applicationArgument;

/**
 * Created by pankaj on 10/28/2017.
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "spring.boot.applicationArgument")

public class CustomApplicationArgument {

    public static void main(String[] args) {

        SpringApplication app = new SpringApplication(CustomApplicationArgument.class);
        app.run(args);

    }
}
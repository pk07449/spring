package rest.exceptionHandling.usingReslover;

/**
 * Created by pankaj on 10/28/2017.
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import rest.exceptionHandling.usingReslover.exception.config.RestExceptionMapper;

@ComponentScan(basePackages = "rest.exceptionHandling.usingReslover")
@SpringBootApplication
public class Application {

    @Bean
    public CustomExceptionRelover customExceptionRelover(@Autowired RestExceptionMapper restExceptionMapper){
        return new CustomExceptionRelover(restExceptionMapper);
    }
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
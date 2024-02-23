package spring.boot.runCodeBeforeApplicaitonShutdown;

/**
 * Created by pankaj on 10/28/2017.
 */

import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication

public class RunCodeBeforeApplicaitonShutdown {

    @Bean
    public ExitCodeGenerator exitCodeGenerator() {
        System.out.println("RunCodeBeforeApplicaitonShutdown.exitCodeGenerator");
        return () -> 42;
    }

    public static void main(String[] args) {
        SpringApplication.run(RunCodeBeforeApplicaitonShutdown.class, args);
    }
}
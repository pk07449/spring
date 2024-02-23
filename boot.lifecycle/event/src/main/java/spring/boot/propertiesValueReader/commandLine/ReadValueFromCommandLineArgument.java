package spring.boot.propertiesValueReader.commandLine;

/**
 * Created by pankaj on 10/28/2017.
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "spring.boot.propertiesValueReader.commandLine")

public class ReadValueFromCommandLineArgument {

    public static void main(String[] args) {

        args = new String[]{"--server.port=9000"};
        SpringApplication app = new SpringApplication(ReadValueFromCommandLineArgument.class);
        app.run(args);

    }
}
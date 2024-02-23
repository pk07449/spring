package spring.boot.propertiesValueReader.commandLine.disable;

/**
 * Created by pankaj on 10/28/2017.
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "spring.boot.propertiesValueReader.commandLine.disable")

public class ReadValueFromCommandLineArgument {

    public static void main(String[] args) {

//        If you do not want command line properties to be added to the Environment, you can disable them by using SpringApplication.setAddCommandLineProperties(false).
        args = new String[]{"--server.port=9000"};
        SpringApplication app = new SpringApplication(ReadValueFromCommandLineArgument.class);
//        app.setAddCommandLineProperties(false);
        app.run(args);

    }
}
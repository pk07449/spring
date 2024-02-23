package spring.boot.loging;

/**
 * Created by pankaj on 10/28/2017.
 */

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EnableLogThroughJavaCode {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(EnableLogThroughJavaCode.class);
        app.setLogStartupInfo(false);
        app.run(args);
    }
}
package spring.boot.banner;

/**
 * Created by pankaj on 10/28/2017.
 */

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EnableBannerThroughJavaCode {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(EnableBannerThroughJavaCode.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);
    }
}
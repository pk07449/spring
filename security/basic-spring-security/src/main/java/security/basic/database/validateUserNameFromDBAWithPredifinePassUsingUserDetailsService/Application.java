package security.basic.database.validateUserNameFromDBAWithPredifinePassUsingUserDetailsService;

/**
 * Created by pankaj on 10/28/2017.
 */
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = "security.basic.database.validateUserNameFromDBAWithPredifinePassUsingUserDetailsService")
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
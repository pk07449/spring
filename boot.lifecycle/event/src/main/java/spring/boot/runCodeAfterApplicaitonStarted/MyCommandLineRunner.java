package spring.boot.runCodeAfterApplicaitonStarted;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by pankaj on 4/8/2020.
 */
@Component
public class MyCommandLineRunner implements CommandLineRunner{

    @Override
    public void run(String... strings) throws Exception {
        System.out.println("RandomPropertyDisableService.run");
    }
}

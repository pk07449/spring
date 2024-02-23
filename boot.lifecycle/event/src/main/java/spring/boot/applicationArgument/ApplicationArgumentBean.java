package spring.boot.applicationArgument;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by pankaj on 4/8/2020.
 */
@Component
public class ApplicationArgumentBean {
    @Autowired
    public ApplicationArgumentBean(ApplicationArguments args) {

        System.out.println("called");
        boolean debug = args.containsOption("debug");
        List<String> files = args.getNonOptionArgs();
        System.out.println(files);
        // if run with "--debug logfile.txt" debug=true, files=["logfile.txt"]
    }

}

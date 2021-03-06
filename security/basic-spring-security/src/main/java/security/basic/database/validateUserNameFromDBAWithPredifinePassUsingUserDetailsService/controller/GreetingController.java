package security.basic.database.validateUserNameFromDBAWithPredifinePassUsingUserDetailsService.controller;

/**
 * Created by pankaj on 10/28/2017.
 */

import security.basic.database.validateUserNameFromDBAWithPredifinePassUsingUserDetailsService.dto.Customer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/hello")
    public Customer greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Customer(counter.incrementAndGet(),
                String.format(template, name));
    }
}
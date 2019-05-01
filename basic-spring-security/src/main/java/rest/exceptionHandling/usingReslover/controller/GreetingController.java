package rest.exceptionHandling.usingReslover.controller;

/**
 * Created by pankaj on 10/28/2017.
 */

//import security.basic.inmemory.dto.Customer;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import rest.exceptionHandling.usingAdvice.dto.Customer;

import java.security.AccessControlException;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/hello")
    public Customer greeting(@RequestParam(value="name", defaultValue="World") String name) {
        throw new AccessControlException("custom run time exception");
//        return new Customer(counter.incrementAndGet(), format(template, name));
    }
}
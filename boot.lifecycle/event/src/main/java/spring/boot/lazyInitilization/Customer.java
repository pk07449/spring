package spring.boot.lazyInitilization;

import org.springframework.stereotype.Service;

/**
 * Created by pankaj on 4/6/2020.
 */
@Service
public class Customer {

    public Customer() {
        System.out.println("Customer.Customer");
        this.name = "config";
    }

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

package security.basic.inmemory.dto;

/**
 * Created by pankaj on 10/28/2017.
 */
public class Customer {

    private final long id;
    private final String name;

    public Customer(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
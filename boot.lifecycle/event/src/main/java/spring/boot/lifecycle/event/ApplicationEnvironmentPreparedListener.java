package spring.boot.lifecycle.event;

import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.context.event.EventListener;

/**
 * Created by pankaj on 4/4/2020.
 */


public class ApplicationEnvironmentPreparedListener {
    @EventListener(classes = {ApplicationEnvironmentPreparedEvent.class})
    public void listen() {
        System.out.println("ApplicationEnvironmentPreparedEvent  called");
    }
}

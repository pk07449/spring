package spring.boot.lifecycle.event;

import org.springframework.context.event.ContextStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * Created by pankaj on 4/4/2020.
 */

public class ContextStartedListener {
    @EventListener(classes = {ContextStartedEvent.class})
    public void listen() {
        System.out.println("ContextStartedListener called");
    }
}

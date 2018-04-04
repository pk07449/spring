package ioc.secheduling;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created by pankaj on 10/20/2017.
 */
@Component
public class AllOrders {

    @Scheduled(fixedRate=2000)
    public void countOrder(){
        System.out.println("Count Student...");
    }
}

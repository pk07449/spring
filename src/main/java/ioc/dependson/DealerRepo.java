package ioc.dependson;

import org.springframework.stereotype.Service;

/**
 * Created by pankaj on 10/26/2017.
 */
@Service
public class DealerRepo {

    public DealerRepo() {
        System.out.println("DealerRepo.DealerRepo");
    }
}

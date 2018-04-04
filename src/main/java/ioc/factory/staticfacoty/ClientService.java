package ioc.factory.staticfacoty;

/**
 * Created by pankaj on 10/25/2017.
 */

public class ClientService {
    private static ClientService clientService = new ClientService();

    private ClientService() {
        System.out.println("ClientService.ClientService");
    }

    public static ClientService createInstance() {
        System.out.println("ClientService.createInstance");
        return clientService;
    }
}
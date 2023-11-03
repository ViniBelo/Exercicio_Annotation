package application;

import services.UserService;
import utils.ProxyOptions;
import utils.UserRoles;

import java.util.UUID;

public class AppTest {
    public static void main(String[] args) {
        UserService service = new UserService();

        UUID id = service.create("Marcos", UserRoles.COMMON, ProxyOptions.DYNAMIC);
        System.out.println(id);

        System.out.println();

        id = service.create("Samantha", UserRoles.ADMINISTRATOR, ProxyOptions.DEFAULT);
        System.out.println(id);
    }
}

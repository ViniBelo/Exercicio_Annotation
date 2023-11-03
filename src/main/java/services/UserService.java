package services;

import factories.FactoryProvider;
import factories.interfaces.UserFactory;
import utils.ProxyOptions;
import utils.UserRoles;

import java.util.UUID;

public class UserService {
    UserFactory userFactory;

    public UUID create(String name, UserRoles role, ProxyOptions proxy) {
        userFactory = FactoryProvider.getFactory(proxy, role);
        return userFactory.createUser(name);
    }
}

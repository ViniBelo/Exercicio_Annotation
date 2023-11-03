package dao;

import domain.User;
import utils.UserRoles;

import java.util.UUID;

public class UserAdministratorDao implements IUserDao{
    @Override
    public UUID save(String name) {
        System.out.println("Saving admin user");
        User user = new User(UUID.randomUUID(), name, UserRoles.ADMINISTRATOR);
        return user.getId();
    }
}

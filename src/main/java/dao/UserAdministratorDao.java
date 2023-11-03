package dao;

import domain.User;

import java.util.UUID;

public class UserAdministratorDao implements IUserDao{
    @Override
    public UUID save(User user) {
        System.out.println("Saving admin user");
        return user.getId();
    }
}

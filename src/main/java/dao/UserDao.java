package dao;

import domain.User;

import java.util.UUID;

public class UserDao implements IUserDao{
    @Override
    public UUID save(User user) {
        System.out.println("Saved user");
        return user.getId();
    }
}

package dao;

import domain.User;
import utils.UserRoles;

import java.util.UUID;

public class UserCommonDao implements IUserDao{
    @Override
    public UUID save(String name) {
        System.out.println("Saving common user");
        User user = new User(UUID.randomUUID(), name, UserRoles.COMMON);
        return user.getId();
    }
}

package dao;

import domain.User;

import java.util.UUID;

public class UserCommonDao implements IUserDao{
    @Override
    public UUID save(User user) {
        System.out.println("Saving common user");
        return user.getId();
    }
}

package factories;

import Annotations.Transaction;
import dao.IUserDao;
import dao.UserCommonDao;
import domain.User;
import factories.interfaces.UserFactory;
import utils.UserRoles;

import java.util.UUID;

public class CommonFactory implements UserFactory {
    public CommonFactory() { }

    @Override
    @Transaction
    public UUID createUser(String name) {
        User user = new User(UUID.randomUUID(), name, UserRoles.COMMON);
        IUserDao userDao = new UserCommonDao();
        return userDao.save(user);
    }
}

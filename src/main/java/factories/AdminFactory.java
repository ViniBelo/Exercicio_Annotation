package factories;

import Annotations.Transaction;
import dao.IUserDao;
import dao.UserAdministratorDao;
import domain.User;
import factories.interfaces.UserFactory;
import utils.UserRoles;

import java.util.UUID;

public class AdminFactory implements UserFactory {
    public AdminFactory() { }

    @Override
    @Transaction
    public UUID createUser(String name) {
        User user = new User(UUID.randomUUID(), name, UserRoles.ADMINISTRATOR);
        IUserDao userDao = new UserAdministratorDao();
        return userDao.save(user);
    }
}

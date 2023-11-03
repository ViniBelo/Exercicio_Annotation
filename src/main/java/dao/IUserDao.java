package dao;

import Annotations.Transaction;
import domain.User;

import java.util.UUID;

public interface IUserDao {
    @Transaction
    public UUID save(User user);
}

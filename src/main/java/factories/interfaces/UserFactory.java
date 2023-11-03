package factories.interfaces;

import Annotations.Transaction;

import java.util.UUID;

public interface UserFactory {
    @Transaction
    public UUID createUser(String name);
}

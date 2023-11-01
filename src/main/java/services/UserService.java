package services;

import Annotations.Transaction;

public class UserService {
    public UserService() { }

    public int exampleMethod() {
        return 0;
    }

    @Transaction
    public String findUser(int value) {
        if (value == 0) {
            return "sucesso";
        } else {
            return "erro";
        }
    }
}

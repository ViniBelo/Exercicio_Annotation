package domain;

import utils.UserRoles;

import java.util.UUID;

public class User {
    UUID id;
    String name;
    UserRoles role;

    public User() {
        System.out.println(this);
    }

    public User(UUID id, String name, UserRoles role) {
        this.id = id;
        this.name = name;
        this.role = role;
        System.out.println(this);
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UserRoles getRole() {
        return role;
    }

    public void setRole(UserRoles role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", role=" + role +
                '}';
    }
}

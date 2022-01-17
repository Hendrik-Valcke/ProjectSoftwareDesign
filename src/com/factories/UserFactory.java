package com.factories;

import com.users.User;

public class UserFactory {

    public User getUser(String name, String password) {
        return new User(name, password);
    }
}

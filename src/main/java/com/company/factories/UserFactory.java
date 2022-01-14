package com.company.factories;

import com.company.users.User;

public class UserFactory {

    public User getUser(String name, String password) {
        return new User(name, password);
    }
}

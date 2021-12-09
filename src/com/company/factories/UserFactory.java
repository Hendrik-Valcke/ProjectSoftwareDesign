package com.company.factories;

import com.company.users.User;

public class UserFactory {
    public User getUser(String name) {
        return new User(name);
    }
}

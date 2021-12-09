package com.company.database;

import com.company.users.User;

import java.util.ArrayList;

public class UserDatabase extends Database{
    private static UserDatabase instance;
    private final ArrayList<User> db;

    private UserDatabase() {this.db = new ArrayList<User>(); }

    public static UserDatabase getInstance() {
        if(instance == null) {
            instance = new UserDatabase();
        }
        return instance;
    }

    public void addUser(User user) {
        db.add(user);
    }

    // attention, balances have to be recalculated
    public void removeUser(User user){
        db.remove(user);
    }

    // what if user doesn't exist?
    public double getBalance(User user) {
        return db.get(db.indexOf(user)).getBalance();
    }


    @Override
    public void printEntries() {

    }
}

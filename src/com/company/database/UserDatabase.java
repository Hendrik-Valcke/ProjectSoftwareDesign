package com.company.database;

import com.company.users.User;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public class UserDatabase<T> implements Iterable<T> {
    static UserDatabase<User> instance;
    private final ArrayList<T> db;

    private UserDatabase() {this.db = new ArrayList<>(); }

    public static UserDatabase<User> getInstance() {
        if (instance == null) {
            instance = new UserDatabase<>();
        }
        return instance;
    }

    public void add(T t) { this.db.add(t);}

    public void remove(T t) { this.db.remove(t);}

    public int size() {return this.db.size(); }


    @Override
    public Iterator<T> iterator() {
        return this.db.iterator();
    }

    @Override
    public void forEach(Consumer<? super T> action) {
        this.db.forEach(action);
    }

    @Override
    public Spliterator<T> spliterator() {
        return this.db.spliterator();
    }
}

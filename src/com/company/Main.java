package com.company;

import com.company.database.UserDatabase;
import com.company.tickets.EvenTicket;
import com.company.tickets.Ticket;
import com.company.users.User;

public class Main {

    public static void main(String[] args) {
        UserDatabase<User> Udb = UserDatabase.getInstance();
        User jeff = new User("jeff");
        User bart = new User("bart");
        Udb.add(bart);
        Udb.add(jeff);
        Ticket t = new EvenTicket(bart, 200);
        t.calculateSplit();
        System.out.println(bart.getBalance());
        System.out.println(jeff.getBalance());
        Udb.forEach(user -> System.out.println(user.getBalance()));



    }
}

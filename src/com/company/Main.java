package com.company;

import com.company.database.TicketDatabase;
import com.company.database.UserDatabase;
import com.company.factories.UserFactory;
import com.company.tickets.Ticket;
import com.company.tickets.UnevenTicket;
import com.company.users.User;

public class Main {

    public static void main(String[] args) {
        UserDatabase<User> Udb = UserDatabase.getInstance();
        TicketDatabase<Ticket> Tdb = TicketDatabase.getInstance();
        UserFactory Uf = new UserFactory();

        User jeff = Uf.getUser("jeff");
        User bart = Uf.getUser("bart");
        Udb.add(bart);
        Udb.add(jeff);

        UnevenTicket t = new UnevenTicket(bart, 200,"cinema");
        t.addPayer(jeff, 10.0);
        Tdb.addTicket(t);

        Tdb.forEach(Ticket::calculateSplit);
        Tdb.forEach(Ticket::printTicket);
        Udb.forEach(User::printUser);




    }
}

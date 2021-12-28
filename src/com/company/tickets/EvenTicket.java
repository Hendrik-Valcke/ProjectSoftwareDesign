package com.company.tickets;

import com.company.database.TicketDatabase;
import com.company.database.UserDatabase;
import com.company.users.User;

import java.util.HashMap;
import java.util.Iterator;

public class EvenTicket extends Ticket{
    private final String event;
    private final User creator;
    private final double amountPayed;

    public EvenTicket(User creator, double amountPayed, String event) {
        this.creator = creator;
        this.amountPayed = amountPayed;
        this.event = event;

    }

    @Override
    public void calculateSplit() {
        double individualAmount = amountPayed/UserDatabase.getInstance().size();
        UserDatabase.getInstance().forEach(user -> user.subtractSaldo(individualAmount)) ;
        creator.addSaldo(UserDatabase.getInstance().size()*individualAmount);
    }

    @Override
    public void printTicket() {
        System.out.println("-------------------" +
                "\nEvent: " + event +
                "\nPayed by: " + creator.getName() +
                "\nAmount payed: " + amountPayed+
                "\n-------------------");

    }
}

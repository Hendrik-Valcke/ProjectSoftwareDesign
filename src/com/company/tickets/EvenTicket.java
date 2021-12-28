package com.company.tickets;

import com.company.database.TicketDatabase;
import com.company.database.UserDatabase;
import com.company.users.User;

import java.util.HashMap;
import java.util.Iterator;

public class EvenTicket extends Ticket{
    private HashMap<User, Double> amountsOwed;
    private User creator;
    private double amountPayed;

    public EvenTicket(User creator, double amountPayed) {
        this.creator = creator;
        this.amountPayed = amountPayed;

    }

    @Override
    public void calculateSplit() {
        double individualAmount = amountPayed/UserDatabase.getInstance().size();
        UserDatabase.getInstance().forEach(user -> user.subtractSaldo(individualAmount)) ;
        creator.addSaldo(UserDatabase.getInstance().size()*individualAmount);


    }

    @Override
    public void printTicket() {

    }
}

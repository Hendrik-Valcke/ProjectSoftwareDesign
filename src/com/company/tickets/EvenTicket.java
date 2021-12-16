package com.company.tickets;

import com.company.database.Database;
import com.company.database.TicketDatabase;
import com.company.database.UserDatabase;
import com.company.users.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class EvenTicket extends Ticket{
    private HashMap<User, Double> amountsOwed;
    private User creator;
    private double amountPayed;

    public EvenTicket(User creator, double amountPayed, TicketDatabase db) {
        this.creator = creator;
        this.amountPayed = amountPayed;
      //  Iterator<User> it = db.iterator(); //need for an iterator
    }

    @Override
    public void calculateSplit() {

    }

    @Override
    public void printTicket() {

    }
}

package com.company.database;

import com.company.tickets.Ticket;
import com.company.users.User;
import org.w3c.dom.Node;

import java.util.ArrayList;
import java.util.Iterator;

public class TicketDBIterator implements Iterator<Ticket> {
    int current;
    ArrayList<Ticket> db;


    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public Ticket next() {
        Ticket data ;
        return null;
    }

    @Override
    public void remove() {
        Iterator.super.remove();
    }
}

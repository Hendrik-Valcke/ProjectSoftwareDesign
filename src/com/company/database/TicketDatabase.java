package com.company.database;

import com.company.tickets.Ticket;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class TicketDatabase extends Database implements Iterable<Ticket>{
    private static TicketDatabase instance;
    private final ArrayList<Ticket> db;
    private int currentSize=0;

    private TicketDatabase() { this.db = new ArrayList<>(); }

    public static TicketDatabase getInstance() {
        if(instance == null) {
            instance = new TicketDatabase();
        }
        return instance;
    }

    public int getCurrentSize() {
        return currentSize;
    }

    public void addTicket(Ticket t) {
        db.add(t);
        currentSize +=1;
    }

    public void removeTicket(Ticket t) {
        if(db.contains(t)) {currentSize-=1;}
        db.remove(t);
    }


    @Override
    public void printEntries() {

    }

    @Override
    public Iterator<Ticket> iterator() {
        return new TicketDBIterator();
    }
}

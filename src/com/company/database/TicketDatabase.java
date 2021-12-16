package com.company.database;

import com.company.tickets.Ticket;

import java.util.ArrayList;
import java.util.HashMap;

public class TicketDatabase extends Database{
    private static TicketDatabase instance;
    private final ArrayList<Ticket> db;

    private TicketDatabase() { this.db = new ArrayList<>(); }

    public static TicketDatabase getInstance() {
        if(instance == null) {
            instance = new TicketDatabase();
        }
        return instance;
    }


    @Override
    public void printEntries() {

    }
}

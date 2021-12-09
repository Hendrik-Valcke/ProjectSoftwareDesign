package com.company.database;

import java.util.ArrayList;
import java.util.HashMap;

public class TicketDatabase extends Database{
    private static TicketDatabase instance;


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

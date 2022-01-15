package com.company.tickets;

import com.company.database.TicketDatabase;
import com.company.users.User;

import java.util.HashMap;

public abstract class Ticket {
    public abstract void calculateSplit();
    public abstract void printTicket();
    public abstract String getEvent() ;

    public abstract User getCreator() ;

    public abstract double getAmountPayed() ;
}

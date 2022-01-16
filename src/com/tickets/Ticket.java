package com.tickets;

import com.users.User;

public abstract class Ticket {
    public abstract void calculateSplit();
    public abstract void printTicket();
    public abstract String getEvent() ;

    public abstract User getCreator() ;

    public abstract double getAmountPayed() ;
}

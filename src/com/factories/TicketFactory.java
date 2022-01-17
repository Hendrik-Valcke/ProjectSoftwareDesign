package com.factories;

import com.tickets.EvenTicket;
import com.tickets.UnevenTicket;
import com.users.User;

public class TicketFactory {

    public EvenTicket getEvenTicket(User creator, double amount , String event) {
        return new EvenTicket( creator,  amount , event);
    }
    public UnevenTicket getUnevenTicket(User creator, double amount , String event) {
        return new UnevenTicket( creator,  amount , event);
    }

}

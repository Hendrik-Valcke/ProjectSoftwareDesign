package com.company.factories;

import com.company.tickets.EvenTicket;
import com.company.tickets.Ticket;
import com.company.tickets.UnevenTicket;
import com.company.users.User;

public class TicketFactory {

    public EvenTicket getEvenTicket(User creator, double amount , String event) {
        return new EvenTicket( creator,  amount , event);
    }
    public UnevenTicket getUnevenTicket(User creator, double amount , String event) {
        return new UnevenTicket( creator,  amount , event);
    }

}

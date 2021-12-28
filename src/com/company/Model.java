package com.company;

import com.company.database.TicketDatabase;
import com.company.database.UserDatabase;

public class Model {
    private TicketDatabase ticketDb;
    private UserDatabase userDb;

    public Model(TicketDatabase ticketDb, UserDatabase userDb) {
        this.ticketDb = ticketDb;
        this.userDb = userDb;
    }
}

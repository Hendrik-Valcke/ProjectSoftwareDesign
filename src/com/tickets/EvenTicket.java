package com.tickets;

import com.database.UserDatabase;
import com.users.User;

public class EvenTicket extends Ticket{
    private final String event;
    private final User creator;
    private final double amountPayed;

    public EvenTicket(User creator, double amountPayed, String event) {
        this.creator = creator;
        this.amountPayed = amountPayed;
        this.event = event;

    }

    public String getEvent() {
        return event;
    }

    public User getCreator() {
        return creator;
    }

    public double getAmountPayed() {
        return amountPayed;
    }

    @Override
    public void calculateSplit() {
        double individualAmount = amountPayed/UserDatabase.getInstance().size();
        UserDatabase.getInstance().forEach(user -> user.subtractSaldo(individualAmount)) ;
        creator.addSaldo(UserDatabase.getInstance().size()*individualAmount);
    }

    public void printTicket() {
        System.out.println("-------------------" +
                "\nEvent: " + event +
                "\nPayed by: " + creator.getName() +
                "\nAmount payed: " + amountPayed+
                "\n-------------------");

    }
}

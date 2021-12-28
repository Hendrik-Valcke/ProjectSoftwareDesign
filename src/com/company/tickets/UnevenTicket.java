package com.company.tickets;

import com.company.database.UserDatabase;
import com.company.users.User;

import java.util.HashMap;

public class UnevenTicket extends Ticket{
    private final String event;
    private final User creator;
    private final double amountPayed;
    private HashMap<User, Double> amountsOwed;

    public UnevenTicket(User creator, double amountPayed, String event) {
        this.event = event;
        this.creator = creator;
        this.amountPayed = amountPayed;
        this.amountsOwed = new HashMap<>();
    }

    public void addPayer(User u, Double d) {
        if(UserDatabase.getInstance().contains(u)) {
            double totalAlreadySplit = 0;
            if(!amountsOwed.isEmpty()) {
                for(Double value: amountsOwed.values()) {
                    totalAlreadySplit += value;
                }
            }

            if( totalAlreadySplit +d <= this.amountPayed) {
                this.amountsOwed.put(u,d);
            }
        }
    }

    @Override
    public void calculateSplit() {
        for (HashMap.Entry<User,Double> entry : amountsOwed.entrySet()) {
            User key = entry.getKey();
            Double value = entry.getValue();
            key.subtractSaldo(value);
            creator.addSaldo(value);
        }


    }

    @Override
    public void printTicket() {
        StringBuilder personsThatPay = new StringBuilder();
        Double moneyReturned = 0.0;
        for (HashMap.Entry<User,Double> entry : amountsOwed.entrySet()) {
            User key = entry.getKey();
            Double value = entry.getValue();
            moneyReturned += value;
            personsThatPay.append("\n").append(key.getName()).append(" pays: ").append(value);
        }
        System.out.println("-------------------" +
                "\nEvent: " + event +
                "\nPayed by: " + creator.getName() +
                "\nAmount payed: " + amountPayed+
                "\n" + personsThatPay +
                "\n" + creator.getName() + " receives: " + moneyReturned +
                "\n-------------------");

    }
}

package com.users;

import java.util.HashMap;
import java.util.Map;

public class User {
    private String name;
    private double balance;
    private HashMap<User, Double> owesUser;
    private String password;

    public User(String name) {
        this.name = name;
        this.balance = 0;
        owesUser = new HashMap<>();

    }
    public User(String name, String pw) {
        this.name = name;
        this.balance = 0;
        this.password=pw;
        owesUser = new HashMap<>();

    }


    public String getName() {
        return name;
    }
    public String getPassWord() {
        return password;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public boolean isInDebt() {
        return balance < 0 ;
    }

    public void addSaldo(double amount) {
        this.balance += amount;
    }

    public void subtractSaldo(double amount) {
        this.balance -= amount;
    }

    public void owesTo(User u, double amount) {
        this.owesUser.put(u, amount);
    }

    public double getAmountOwedTo(User u) {
        if(owesUser.containsKey(u)) {
            return owesUser.get(u);
        } else {
            return 0;
        }
    }

    public void printDebt() {
        System.out.println("======User: " + this.name + "======");
        for (Map.Entry<User,Double> entry : owesUser.entrySet()) {
            User u = entry.getKey();
            double value = entry.getValue();
            System.out.println("owes " + u.getName() + " €" + value);
        }
    }

    public void printUser() {
        System.out.println("User: " + this.name + " balance: " + this.balance);
    }

}

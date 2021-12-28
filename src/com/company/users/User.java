package com.company.users;

public class User {
    private String name;
    private double balance;

    public User() {
        this.name = "anonymousUser";
        this.balance = 0;
    }

    public User(String name) {
        this.name = name;
        this.balance = 0;
    }

    public User(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public boolean isSettled() {
        return this.balance == 0;
    }

    public void addSaldo(double amount) {
        this.balance += amount;
    }

    public void subtractSaldo(double amount) {
        this.balance -= amount;
    }

    public void printUser() {
        System.out.println("User: " + this.name + " balance: " + this.balance);
    }

}

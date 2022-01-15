package com.company.database;

import com.company.tickets.Ticket;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public class TicketDatabase<T> implements Iterable<T> {
    static TicketDatabase<Ticket> instance;
    private final ArrayList<T> db;

    private TicketDatabase() { this.db = new ArrayList<>(); }

    public static TicketDatabase<Ticket> getInstance() {
        if(instance == null) {
            instance = new TicketDatabase<>();
        }
        return instance;
    }

    public void addTicket(T t) {
        db.add(t);
    }

    public int size() {
        return db.size();
    }
    public boolean contains(T t) {
        return db.contains(t);
    }

    public void removeTicket(T t) {
        db.remove(t);
    }

    @Override
    public Iterator<T> iterator() {
        return this.db.iterator();
    }

    @Override
    public void forEach(Consumer<? super T> action) {
        this.db.forEach(action);
    }

    @Override
    public Spliterator<T> spliterator() {
        return this.db.spliterator();
    }
}

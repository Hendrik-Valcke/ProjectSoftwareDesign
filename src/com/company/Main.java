package com.company;

import com.company.GUI.Window;

import javax.swing.*;
import java.awt.*;

import com.company.database.TicketDatabase;
import com.company.database.UserDatabase;
import com.company.tickets.EvenTicket;
import com.company.tickets.Ticket;
import com.company.users.User;

public class Main {

    public static void main(String[] args) {
        System.out.println("testing main:");
        /*
        Window mainWindow = new Window();
        mainWindow.showCustomTicketScreen();
        mainWindow.setVisible(true);*/
        /*
        UserDatabase<User> Udb = UserDatabase.getInstance();
        User jeff = new User("jeff");
        User bart = new User("bart");
        Udb.add(bart);
        Udb.add(jeff);
        Ticket t = new EvenTicket(bart, 200);
        t.calculateSplit();
        System.out.println(bart.getBalance());
        System.out.println(jeff.getBalance());
        Udb.forEach(user -> System.out.println(user.getBalance()));*/
    }

    void run()
    {
        ////=mvc logica
        ////maak db aan
        Model model= new Model(TicketDatabase.getInstance(),UserDatabase.getInstance());

        ////maak window aan
        Window view = new Window();

        ////maak controller aan
        Controller controller= new Controller(model,view);
        
        // begin in startscreen, knoppen bepalen volgende stappen
        controller.start();

    }
}

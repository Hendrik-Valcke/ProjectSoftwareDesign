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
        Main main = new Main();
        main.run();
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
        /*the controller handles the traffic between the gui(view) and the data(model)
        example: user presses the 'caculate'button in the homescreen
                --> the button calls the function 'calculateTotal' in the controller
                --> calculateTotal calls a function from the model, which performs the calculation using the databases
                --> the function returns an answer to the controller
                --> the controller calls: view.showEndresult() which displays the values everyone has to pay to each other
                (de helft van deze functies bestaan nog ni )
        */

        ////maak db aan
        System.out.println("make model");
        Model model= new Model(TicketDatabase.getInstance(),UserDatabase.getInstance());

        ////maak window aan
        System.out.println("make view");
        Window view = new Window();

        ////maak controller aan
        System.out.println("make controller");
        Controller controller= new Controller(model,view);

        // begin in startscreen, knoppen bepalen volgende stappen
        controller.start();

    }
}

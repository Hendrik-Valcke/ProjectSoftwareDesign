package com;

import com.GUI.Window;

import com.database.TicketDatabase;
import com.database.UserDatabase;
import com.tickets.Ticket;
import com.users.User;

public class Main {

    public static void main(String[] args) {
        System.out.println("testing main:");
        Main main = new Main();
        main.run();
        /*
        Window mainWindow = new Window();
        mainWindow.showCustomTicketScreen();
        mainWindow.setVisible(true);*/


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
        Model model= new Model();

        ////maak window aan
        System.out.println("make view");
        Window view = new Window();

        ////maak controller aan
        System.out.println("make controller");
        Controller controller= new Controller(model,view);

        // begin in startscreen, knoppen bepalen volgende stappen
        controller.go2Start();

    }
}

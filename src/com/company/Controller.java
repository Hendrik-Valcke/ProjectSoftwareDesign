package com.company;

import com.company.GUI.Window;

public class Controller {
    private Window view;
    private Model model;

    public Controller(Model model, Window view) {
        this.view = view;
        this.model = model;
    }

    public void start()
    {
        System.out.println("controller:start");
        view.showStartScreen();
        view.setVisible(true);
    }

//basically all buttons call a function of the controller
    public void startLogin()
    {
        //triggered when the user presses 'login'in startscreen or 'change user' in homescreen
        //the user will enter info and press the login button
        view.showLoginScreen();
        view.setVisible(true);

    }

    public void checkLogin(String username,String password)
    {
        //triggered when someone presses 'login' after entering info in loginScreen

        //a function that looks for the username in the database and confirms whether the password is correct
        //
        //if the check returns positive:
            //send to homescreen
            //Home();
        //if the check returns negative:
            //make a messagebox:error wrong info...
            //startLogin()
    }

    /*public void startcreateNewUser()
    {
        view.showCreateUser();
    }*/


}

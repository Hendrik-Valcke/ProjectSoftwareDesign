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
        view.showStartScreen();
    }
//basically alle buttons roepen een functie op van controller
    public void login()
    {
        view.showLoginScreen();
    }
}

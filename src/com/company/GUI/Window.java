package com.company.GUI;

import com.company.Controller;
import com.company.GUI.subframes.*;

import javax.swing.*;
import javax.xml.stream.events.StartDocument;
import java.awt.*;
import java.awt.event.ActionListener;

public class Window extends JFrame {

    private JPanel mainPanel;
    private CreateUserScreen cuScreen;
    private LoginScreen loginScreen;
    private HomeScreen homeScreen;

    public Window() {
        super("Moneysplitter");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setPreferredSize(new Dimension(640,480));
        this.pack();
    }

    public void showStartScreen(boolean enableLogin, ActionListener createUserListener, ActionListener loginListener)
    {
        StartScreen screen= new StartScreen();
        screen.enableLoginButton(enableLogin);//if there are no users, the login button will be disabled
        screen.addListener(createUserListener,loginListener);
        this.setContentPane(screen.getRootPanel());
    }
    public void showLoginScreen(ActionListener cancelListener,ActionListener loginListener)
    {
        loginScreen=new LoginScreen();
        loginScreen.addListener( cancelListener, loginListener);
        this.setContentPane(loginScreen.getRootPanel());
    }

    public void showCreateUserScreen(ActionListener cancelListener,ActionListener createUserListener) {
        cuScreen= new CreateUserScreen();
        cuScreen.addListener(cancelListener,createUserListener);
        this.setContentPane(cuScreen.getRootPanel());
    }

    public void showHomeScreen(ActionListener logOutListener,ActionListener evenTicketListener,ActionListener specialTicketListener,ActionListener calcListener, ActionListener addUListerner, ActionListener remUListener)
    {
        homeScreen= new HomeScreen();
        homeScreen.addListener(logOutListener,evenTicketListener,specialTicketListener,calcListener,addUListerner,remUListener);
        this.setContentPane(homeScreen.getRootPanel());
    }
    public void showEvenTicketScreen()
    {
        JPanel panel= new EvenTicketScreen().getRootPanel();
        this.setContentPane(panel);
    }
    public void showCustomTicketScreen()
    {
        JPanel panel= new CustomTicketScreen().getRootPanel();
        this.setContentPane(panel);
    }

    //getters
    public CreateUserScreen getCuScreen()
    {
        return cuScreen;
    }

    public LoginScreen getLoginScreen()
    {
        return loginScreen;
    }
    public void showErrorMessage(String message)
    {
        JOptionPane.showMessageDialog(this,message);
    }

}


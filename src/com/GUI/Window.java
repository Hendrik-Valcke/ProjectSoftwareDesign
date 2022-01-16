package com.GUI;


import com.GUI.subframes.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Window extends JFrame {

    private JPanel mainPanel;
    private CreateUserScreen cuScreen;
    private LoginScreen loginScreen;
    private HomeScreen homeScreen;
    private RemoveUserScreen ruScreen;
    private EvenTicketScreen etScreen;
    private CustomTicketScreen ctScreen;
    private EndScreen endScreen;

    public Window() {
        super("Moneysplitter");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setPreferredSize(new Dimension(640, 480));
        this.pack();
    }

    public void showStartScreen(boolean enableLogin, ActionListener createUserListener, ActionListener loginListener) {
        StartScreen screen = new StartScreen();
        screen.enableLoginButton(enableLogin);//if there are no users, the login button will be disabled
        screen.addListener(createUserListener, loginListener);
        this.setContentPane(screen.getRootPanel());
    }

    public void showLoginScreen(ActionListener cancelListener, ActionListener loginListener) {
        loginScreen = new LoginScreen();
        loginScreen.addListener(cancelListener, loginListener);
        this.setContentPane(loginScreen.getRootPanel());
    }

    public void showCreateUserScreen(ActionListener cancelListener, ActionListener createUserListener) {
        cuScreen = new CreateUserScreen();
        cuScreen.addListener(cancelListener, createUserListener);
        this.setContentPane(cuScreen.getRootPanel());
    }

    public void showHomeScreen(ActionListener logOutListener, ActionListener evenTicketListener, ActionListener specialTicketListener, ActionListener calcListener, ActionListener addUListener, ActionListener remUListener, String[] ticketContents, String[] userNames) {
        homeScreen = new HomeScreen(ticketContents, userNames);
        homeScreen.addListener(logOutListener, evenTicketListener, specialTicketListener, calcListener, addUListener, remUListener);
        this.setContentPane(homeScreen.getRootPanel());
    }

    public void showRemoveUserScreen(ActionListener cancelListener, ActionListener removeUserListener, String[] userNames) {
        ruScreen = new RemoveUserScreen(userNames);
        ruScreen.addListener(cancelListener, removeUserListener);
        this.setContentPane(ruScreen.getRootPanel());
    }

    public void showEvenTicketScreen(ActionListener cancelListener, ActionListener createTicketListener) {
        etScreen = new EvenTicketScreen();
        etScreen.addListener(cancelListener, createTicketListener);
        this.setContentPane(etScreen.getRootPanel());
    }

    public void showCustomTicketScreen(ActionListener cancelListener, ActionListener createTicketListener, String[] userNames) {
        ctScreen = new CustomTicketScreen(userNames);
        ctScreen.addListener(cancelListener, createTicketListener);
        this.setContentPane(ctScreen.getRootPanel());
    }

    public void showEndsScreen(ActionListener cancelListener, String[] userNames, double[][] data)
    {
        endScreen= new EndScreen(userNames,data);
        endScreen.addListener(cancelListener);
        this.setContentPane(endScreen.getRootPanel());
    }

    //getters
    //adduser
    public String getCuScreenName()
    {
        return cuScreen.getName();
    }
    public String getCuScreenPassword()
    {
        return cuScreen.getPassWord();
    }
    //removeuser
    public String getRuScreenName()
    {
        return ruScreen.getName();
    }
    //misc
    public LoginScreen getLoginScreen()
    {
        return loginScreen;
    }
    public void showErrorMessage(String message)
    {
        JOptionPane.showMessageDialog(this,message);
    }
    //eventicket
    public String getEvenTicketCreator() {
        return etScreen.getCreator();
    }
    public String getEvenTicktEvent() {
        return etScreen.getEvent();
    }
    public double getEvenTicketAmountPaid() {
        return etScreen.getAmountPaid();
    }
    //customTicket
    public String getCustomTicketCreator() {
        return ctScreen.getCreator();
    }
    public String getCustomTicktEvent() {
        return ctScreen.getEvent();
    }
    public double getCustomTicketAmountPaid() {
        return ctScreen.getAmountPaid();
    }
    public double[] getCustomTicketDebts()
    {
        return ctScreen.getUserDebts();
    }

}


package com.company.GUI;

import com.company.GUI.subframes.*;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {

    private JPanel mainPanel;
    private JPanel startPanel;
    private JPanel loginPanel;

    public Window() {
        super("Moneysplitter");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setPreferredSize(new Dimension(640,480));
        this.pack();
    }

    public void showStartScreen()
    {
        JPanel panel= new StartScreen().getRootPanel();
        this.setContentPane(panel);
    }
    public void showLoginScreen()
    {
        JPanel panel= new LoginScreen().getRootPanel();
        this.setContentPane(panel);
    }
    public void showHomeScreen()
    {
        JPanel panel= new HomeScreen().getRootPanel();
        this.setContentPane(panel);
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
}


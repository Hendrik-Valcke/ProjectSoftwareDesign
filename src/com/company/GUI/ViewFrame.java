package com.company.GUI;


import com.company.GUI.panels.LoginPanel;
import com.company.GUI.panels.StartPanel;

import javax.swing.*;

public class ViewFrame extends JFrame
{
    private StartPanel startPanel;
    private JPanel loginPanel;

    public ViewFrame()
    {
        super("moneytracker");
    }

    public void initialize()
    {
        this.setSize(720, 480);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.startPanel=new StartPanel();
        this.loginPanel=new LoginPanel();
        this.setVisible(true);
    }

    public void showStartPanel()
    {
        this.add(startPanel);
    }

    public void showLoginPanel()
    {
        this.add(loginPanel);
    }
}

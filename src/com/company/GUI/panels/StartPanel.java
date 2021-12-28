package com.company.GUI.panels;

import javax.swing.*;

public class StartPanel extends JPanel {

    private JButton loginButton;
    private JButton createUserButton;
    private JLabel label;

    public StartPanel()
    {
        loginButton = new JButton("login");
        createUserButton = new JButton("Create new user");
        label = new JLabel("Welcome");
        this.add(label);
        this.add(loginButton);
        this.add(createUserButton);
    }

}

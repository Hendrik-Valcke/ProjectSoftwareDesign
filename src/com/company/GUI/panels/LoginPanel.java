package com.company.GUI.panels;

import javax.swing.*;

public class LoginPanel extends JPanel {
    private JLabel userlabel;
    private JLabel pwLabel;
    private JButton createUserButton;
    private JTextField userText;
    private JPasswordField pwText;

    public LoginPanel()
    {
        userlabel = new JLabel("Username");
        userlabel.setBounds(10,20,80,25);

        userText= new JTextField();
        userText.setBounds(100,20,80,25);

        pwLabel = new JLabel("Password");
        pwLabel.setBounds(10,40,80,25);
        pwText= new JPasswordField();
        pwText.setBounds(100,40,80,25);
        createUserButton = new JButton("Create User");
        createUserButton.setBounds(10,80,80,25);

        this.add(userlabel);
        this.add(userText);
        this.add(pwLabel);
        this.add(createUserButton);
    }

}

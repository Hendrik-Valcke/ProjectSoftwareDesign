package com.company.GUI.subframes;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginScreen implements SubFrame{
    private JPanel rootPanel;
    private JPanel topPanel;
    private JLabel textLabel;
    private JTextField userField;
    private JPasswordField pwField;
    private JButton loginButton;
    private JLabel pwLabel;
    private JLabel userLabel;
    private JButton cancelButton;

    public LoginScreen() {

    }
    public String getPassWord()
    {
        return new String(pwField.getPassword());
    }
    public String getName()
    {
        return userField.getText();
    }

    public void addListener(ActionListener listenForCancel,ActionListener listenForLogin)
    {
        loginButton.addActionListener(listenForLogin);
        cancelButton.addActionListener(listenForCancel);
    }



    @Override
    public JPanel getRootPanel() {
        return this.rootPanel;
    }
}

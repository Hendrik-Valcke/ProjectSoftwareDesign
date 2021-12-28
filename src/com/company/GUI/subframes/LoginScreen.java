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

    public LoginScreen() {
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });
    }

    @Override
    public JPanel getRootPanel() {
        return this.rootPanel;
    }
}

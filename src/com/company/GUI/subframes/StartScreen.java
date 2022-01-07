package com.company.GUI.subframes;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartScreen implements SubFrame {


    private JPanel rootPanel;
    private JPanel topPanel;
    private JLabel title;
    private JPanel botPanel;
    private JPanel botLeftPanel;
    private JButton loginButton;
    private JPanel botRightPanel;
    private JButton createUserButton;
    private JPanel midPanel;

    public StartScreen() {
    }

    public void enableLoginButton(boolean enable)
    {
        //if enable is false the button will be disabled
        loginButton.setEnabled(enable);
    }


    public void addListener(ActionListener listenForCreate,ActionListener listenForLogin)
    {
        loginButton.addActionListener(listenForLogin);
        createUserButton.addActionListener(listenForCreate);
    }

    @Override
    public JPanel getRootPanel() {
        return this.rootPanel;
    }
}


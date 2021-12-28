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
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });
        createUserButton.addActionListener(new ActionListener() {
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


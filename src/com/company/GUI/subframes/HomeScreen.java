package com.company.GUI.subframes;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomeScreen implements SubFrame{
    private JPanel rootPanel;
    private JList ticketList;
    private JButton evenTicketButton;
    private JLabel titleLabel;
    private JButton changeUserButton;
    private JButton specialTicketButton;
    private JList userList;
    private JLabel ticketListLabel;
    private JLabel userListLabel;
    private JButton calculateButton;
    private JPanel panel1;
    private JPanel panel3;
    private JPanel panel2;
    private JPanel panel5;
    private JPanel panel4;

    public HomeScreen() {
        changeUserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });
        evenTicketButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });
        specialTicketButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });
        calculateButton.addActionListener(new ActionListener() {
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

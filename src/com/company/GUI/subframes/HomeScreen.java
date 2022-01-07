package com.company.GUI.subframes;

import javax.swing.*;
import java.awt.event.ActionListener;

public class HomeScreen implements SubFrame{
    private JPanel rootPanel;
    private JList ticketList;
    private JButton evenTicketButton;
    private JLabel titleLabel;
    private JButton logOutButton;
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
    private JButton addUserButton;
    private JButton removeUserButton;

    public HomeScreen() {
    }

    @Override
    public JPanel getRootPanel() {
        return this.rootPanel;
    }

    public void addListener(ActionListener logOutListener, ActionListener evenTicketListener, ActionListener specialTicketListener, ActionListener calcListener,ActionListener addUListerner, ActionListener remUListener) {
        logOutButton.addActionListener(logOutListener);
        evenTicketButton.addActionListener(evenTicketListener);
        specialTicketButton.addActionListener(specialTicketListener);
        calculateButton.addActionListener(calcListener);
        addUserButton.addActionListener(addUListerner);
        removeUserButton.addActionListener(remUListener);
    }
}

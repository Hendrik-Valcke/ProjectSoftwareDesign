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
    private DefaultListModel ticketModel;
    private DefaultListModel userModel;

    public HomeScreen(String[] ticketContents, String[] userContents) {
        ticketModel = new DefaultListModel();
        ticketList.setModel(ticketModel);
        userModel = new DefaultListModel();
        userList.setModel(new DefaultListModel());

        populateLists( ticketContents,  userContents);
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

    public void populateLists(String[] ticketContents, String[] userContents)
    {
        ticketModel.removeAllElements();
        for (int i = 0; i < ticketContents.length; i++) {
            ticketModel.addElement(ticketContents[i]);
        }

        userModel.removeAllElements();
        for (int i = 0; i < userContents.length; i++) {
            System.out.println(userContents[i]);
            userModel.addElement(userContents[i]);
        }
        /*for (String content: ticketContents){
            ticketModel.addElement(content);
        }

        userModel.removeAllElements();
        for (String content: userContents){
            userModel.addElement(content);
        }*/
    }
}

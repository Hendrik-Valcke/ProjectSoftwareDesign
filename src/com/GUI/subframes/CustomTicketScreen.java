package com.GUI.subframes;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CustomTicketScreen implements SubFrame{
    private JPanel rootPanel;
    private JLabel titleLabel;
    private JTextField creatorTextField;
    private JTextField eventTextField;
    private JButton cancelButton;
    private JButton saveTicketButton;
    private JList userList;
    private JLabel listLabel;
    private JButton saveShareButton;
    private JTextField shareField;
    private JTextField amountPaidTextField;
    private String[] userString;
    private DefaultListModel userModel;
    private double[] userDebts;

    public CustomTicketScreen(String[] userNames) {
        userString = userNames;

        userDebts= new double[userString.length];
        for (int i = 0; i < userString.length; i++) {
            userDebts[i]=0.0;
        }
        userModel = new DefaultListModel();
        userModel.removeAllElements();
        /*for (int i = 0; i < userString.length; i++) {
            System.out.println(userString[i]+" "+userDebts[i]);
            userModel.addElement(userString[i]+" "+userDebts[i]);
        }*/
        updateList();
        userList.setModel(userModel);

        userList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent listSelectionEvent) {
                saveShareButton.setEnabled(true);
                shareField.setText(""+userDebts[userList.getSelectedIndex()]);
            }
        });
        saveShareButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                userDebts[userList.getSelectedIndex()]= Double.parseDouble(shareField.getText());
                //userList.setSelectedIndex(0);
                updateList();
            }
        });
    }
    public void updateList()
    {
        userModel = new DefaultListModel();
        userModel.removeAllElements();
        System.out.println("update");
        for (int i = 0; i < userString.length; i++) {
            userModel.addElement(userString[i]+": €"+userDebts[i]);
        }
        userList.setModel(userModel);
    }

    @Override
    public JPanel getRootPanel() {
        return this.rootPanel;
    }

    public void addListener(ActionListener cancelListener, ActionListener createTicketListener) {
        cancelButton.addActionListener(cancelListener);
        saveTicketButton.addActionListener(createTicketListener);
    }

    public String getCreator() {
        return creatorTextField.getText();
    }

    public String getEvent() {
        return eventTextField.getText();
    }

    public double getAmountPaid() {
        return Double.parseDouble(amountPaidTextField.getText());
    }

    public double[] getUserDebts() {
        return userDebts;
    }
}

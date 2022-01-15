package com.company.GUI.subframes;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EvenTicketScreen implements SubFrame{
    private JPanel rootPanel;
    private JButton saveTicketButton;
    private JButton cancelButton;
    private JLabel titleLabel;
    private JTextField eventTextField;
    private JTextField creatorTextField;
    private JTextField amountPaidTextField;

    public EvenTicketScreen() {
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });
        saveTicketButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });
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
}

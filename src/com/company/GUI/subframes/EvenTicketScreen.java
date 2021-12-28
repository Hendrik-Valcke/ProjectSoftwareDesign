package com.company.GUI.subframes;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EvenTicketScreen implements SubFrame{
    private JPanel rootPanel;
    private JButton saveTicketButton;
    private JButton cancelButton;
    private JLabel titleLabel;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;

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
}

package com.company.GUI.subframes;

import javax.swing.*;

public class CustomTicketScreen implements SubFrame{
    private JPanel rootPanel;
    private JLabel titleLabel;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField1;
    private JButton cancelButton;
    private JButton saveTicketButton;

    @Override
    public JPanel getRootPanel() {
        return this.rootPanel;
    }
}

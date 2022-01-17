package com.GUI.subframes;

import javax.swing.*;
import java.awt.event.ActionListener;

public class CreateUserScreen implements SubFrame{
    private JPanel rootPanel;
    private JButton createUserButton;
    private JButton cancelButton;
    private JPasswordField passwordField;
    private JTextField nameTextField;
    private JLabel titleLabel;

    public CreateUserScreen()
    {}
    public String getPassWord()
    {
        return new String(passwordField.getPassword());
    }
    public String getName()
    {
        return nameTextField.getText();
    }

    public void addListener(ActionListener cancelListener,ActionListener createUserListener)
    {
        cancelButton.addActionListener(cancelListener);
        createUserButton.addActionListener(createUserListener);
    }
    @Override
    public JPanel getRootPanel() {
        return this.rootPanel;
    }
}

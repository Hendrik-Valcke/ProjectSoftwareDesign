package com.company.GUI.subframes;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionListener;

public class RemoveUserScreen implements SubFrame{
    private JPanel rootPanel;
    private JLabel JLabel;
    private JList userList;
    private JLabel userLabel;
    private JButton cancelButton;
    private JButton removeUserButton;
    private DefaultListModel userModel;
    private String[] userString;

    public RemoveUserScreen(String[] userNames)
    {
        userString=userNames;
        userModel= new DefaultListModel();
        userModel.removeAllElements();
        for (int i = 0; i < userNames.length; i++) {
            System.out.println(userNames[i]);
            userModel.addElement(userNames[i]);
        }
        userList.setModel(userModel);
        userList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent listSelectionEvent) {
                removeUserButton.setEnabled(true);
                userLabel.setText(userString[userList.getSelectedIndex()]);
            }
        });
    }
    public void addListener(ActionListener cancelListener, ActionListener removeUserListener)
    {
        cancelButton.addActionListener(cancelListener);
        removeUserButton.addActionListener(removeUserListener);
    }
    public String getName() {
        return userString[userList.getSelectedIndex()];
    }
    @Override
    public JPanel getRootPanel() {
        return rootPanel;
    }


}

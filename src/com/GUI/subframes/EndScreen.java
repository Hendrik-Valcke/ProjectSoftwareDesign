package com.GUI.subframes;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionListener;

public class EndScreen implements SubFrame {
    private JPanel rootPanel;
    private JButton cancelButton;
    private JButton printToTxtButton;
    private JList userList;
    private JList debtList;
    private JLabel oweLabel;
    private String[] userString;
    private double[][] debtData;
    private DefaultListModel userModel;
    private DefaultListModel debtsModel;

    public EndScreen(String[] userNames,double[][] data)
    {
        userString=userNames;
        debtData=data;
        userModel= new DefaultListModel();
        debtsModel=new DefaultListModel();
        userModel.removeAllElements();
        for (int i = 0; i < userNames.length; i++) {
            //System.out.println(userNames[i]);
            userModel.addElement(userNames[i]);
        }
        userList.setModel(userModel);
        userList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent listSelectionEvent) {
                oweLabel.setText(userString[userList.getSelectedIndex()]+" owes to others:");
                updateDebts();
            }
        });
    }

    @Override
    public JPanel getRootPanel() {
        return rootPanel;
    }
    public void updateDebts()
    {
        System.out.println(userString.length);
        for (int i = 0; i <userString.length ; i++) {
            for (int j = 0; j <userString.length ; j++) {
                System.out.println(debtData[i][j]);
            }
        }

        debtsModel.removeAllElements();
        for (int i = 0; i < userString.length; i++) {
            debtsModel.addElement("€"+debtData[userList.getSelectedIndex()][i]+" to "+userString[i]);
        }
        debtList.setModel(debtsModel);
    }

    public void addListener(ActionListener cancelListener) {
        cancelButton.addActionListener(cancelListener);
    }
}

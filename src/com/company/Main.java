package com.company;

import com.company.GUI.Window;

import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {
        System.out.println("testing gui:");
        Window mainWindow = new Window();
        mainWindow.showCustomTicketScreen();
        mainWindow.setVisible(true);
    }
}

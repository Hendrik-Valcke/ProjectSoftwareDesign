package com.company;

import com.company.GUI.ViewFrame;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello world3");
        ViewFrame view = new ViewFrame();
        view.initialize();
        view.showLoginPanel();
    }
}

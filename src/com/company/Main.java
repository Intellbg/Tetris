package com.company;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import com.company.DesktopGui.DesktopGui;

public class Main {
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException
                | UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        new DesktopGui();
    }
}

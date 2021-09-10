package com.company.DesktopGui;

import javax.swing.JButton;
import java.awt.event.*;  

public class BotonSalir extends JButton implements ActionListener{

    public BotonSalir() {
        super("Salir");
        addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        DesktopGui.regresarMenu();
    }

    
}

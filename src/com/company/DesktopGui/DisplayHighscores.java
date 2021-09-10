package com.company.DesktopGui;

import javax.swing.JPanel;
import javax.swing.JTable;

public class DisplayHighscores extends JPanel{

    public DisplayHighscores() {
        add(new JTable(5,3));
        add(new BotonSalir());
    }
    
}

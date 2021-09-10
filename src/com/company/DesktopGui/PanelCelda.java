package com.company.DesktopGui;

import javax.swing.*;
import java.awt.*;

public class PanelCelda extends JPanel{
    int color=9;
    public PanelCelda() {
        setBorder(BorderFactory.createLineBorder(Color.black));
    }
    public PanelCelda(Color color) {
        setBackground(color);
    }

    public void cambiarColor(int color){
        setBorder(BorderFactory.createLineBorder(Color.black));
        switch(color){
            case 0:
                setBackground(Color.green);
                break;
            case 1:
                setBackground(Color.cyan);
                break;
            case 2:
                setBackground(Color.black);
                break;
            case 3:
                setBackground(Color.blue);
                break;
            case 4:
                setBackground(Color.yellow);
                break;
            case 5:
                setBackground(Color.orange);
                break;
            case 6:
                setBackground(Color.red);
                break;
            default:
                setBackground(Color.white);
        }
        this.color=color;
        repaint();
    }
    
}

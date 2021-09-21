package com.company.DesktopGui;

import javax.swing.*;
import java.awt.*;

public class PanelCelda extends JPanel{
    public PanelCelda() {
        setBorder(BorderFactory.createLineBorder(Color.black));
    }
    public PanelCelda(Color color) {
        setBackground(color);
    }

    public void cambiarColor(String color){
        setBorder(BorderFactory.createLineBorder(Color.black));
        switch(color){
            case "verde":
                setBackground(Color.green);
                break;
            case "cyan":
                setBackground(Color.cyan);
                break;
            case "negro":
                setBackground(Color.black);
                break;
            case "azul":
                setBackground(Color.blue);
                break;
            case "amarillo":
                setBackground(Color.yellow);
                break;
            case "tomate":
                setBackground(Color.orange);
                break;
            case "rojo":
                setBackground(Color.red);
                break;
            case "morado":
                setBackground(Color.magenta);
                break;
            default:
                setBackground(Color.black);
        }
        repaint();
    }
    
}

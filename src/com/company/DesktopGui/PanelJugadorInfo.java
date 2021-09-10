package com.company.DesktopGui;

import javax.swing.*;
import java.awt.*;

public class PanelJugadorInfo extends JPanel{
    JLabel nombre;
    JLabel puntaje;
    public PanelJugadorInfo() {
        setBackground(Color.white);
        setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        nombre = new JLabel("Nombre jugador");
        puntaje = new JLabel("Puntaje: ");
        add(nombre);
        add(puntaje);
    }
    
}

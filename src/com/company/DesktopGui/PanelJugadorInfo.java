package com.company.DesktopGui;

import javax.swing.*;
import java.awt.*;

import com.company.Tetris.Jugador;
import com.company.Tetris.Tetris;


public class PanelJugadorInfo extends JPanel {
    JLabel nombre;
    JLabel puntaje;
    JLabel nivel;

    public PanelJugadorInfo() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(Color.lightGray);

        nombre = new JLabel();
        nombre.setFont(new Font("Arial", Font.PLAIN, 20));
        add(nombre);
        
        puntaje = new JLabel("Puntaje: " );
        puntaje.setFont(new Font("Arial", Font.PLAIN, 18));
        add(puntaje);
        
        nivel = new JLabel("LV: ");
        nivel.setFont(new Font("Arial", Font.PLAIN, 18));
        add(nivel);
    }
    
    public void actualizarInformacion() {
        nombre.setText(Tetris.getNombreJugador());
        puntaje.setText("Puntaje: " + Tetris.getPuntaje());
        nivel.setText("Nivel: " + Tetris.getNivel());
    }
}

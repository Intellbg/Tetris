package com.company.DesktopGui;

import javax.swing.*;
import java.awt.*;

public class DisplayMenuPrincipal extends JPanel{
    JButton botonJugar, botonHighscore;
    GridLayout grid;
    public DisplayMenuPrincipal() {
        grid=new GridLayout(3,1);
        grid.setVgap(10);
        setLayout(grid);        
        setBackground(Color.CYAN);

        botonJugar= new JButton("Jugar");
        //botonJugar.addActionListener(new ListenerCambiarVistaBoton("TetrisDisplay"));
        add(botonJugar);
        
        add(new JButton("Cargar Partida"));
        
        botonHighscore=new JButton("HighScores");
        //botonHighscore.addActionListener(new ListenerCambiarVistaBoton("HighscoresDisplay"));
        add(botonHighscore);
        
    }
}

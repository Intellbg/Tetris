package com.company.DesktopGui;

import javax.swing.*;

import com.company.Tetris.Jugador;
import com.company.Tetris.Tetris;

import java.awt.*;
import java.util.ArrayList;

public class DisplayHighscores extends JPanel{

    public DisplayHighscores() {
        setPreferredSize(new Dimension(1200, 900));
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

        add(Box.createRigidArea(new Dimension(10, 30)));

        JLabel titulo= new JLabel("El Salon de la Fama");
        titulo.setAlignmentX(Component.CENTER_ALIGNMENT);
        titulo.setFont(new Font("Arial", Font.PLAIN, 60));
        add(titulo);
        
        add(Box.createRigidArea(new Dimension(10, 60)));
        
        JScrollPane contenedorTabla=new JScrollPane(crearTabla());
        contenedorTabla.setMaximumSize(new Dimension(800,550));
        add(contenedorTabla);
        
        add(Box.createRigidArea(new Dimension(10, 60)));

        JButton salir=new JButton("Regresar");
        salir.setFont(new Font("Arial", Font.PLAIN, 25));
        salir.setAlignmentX(Component.CENTER_ALIGNMENT);
        salir.addActionListener(a->mostrarMenuPrincipal());
        add(salir);
    }

    private JTable crearTabla(){
        String[] nombresColumna= new String[]{"Nombre","Nivel","Puntaje"}; 
        String[][] datos=new String[5][3];
        ArrayList<Jugador> mejoresJugadores= Tetris.obtenerMejoresJugadores();
        int i =0;
        for(Jugador jugador: mejoresJugadores){
            datos[i][0]=jugador.getNombre();
            datos[i][1]=String.valueOf(jugador.getNivel());
            datos[i][2]=String.valueOf(jugador.getPuntaje());
            i++;
        }
        return new TablaHighscore(datos,nombresColumna);
    }
    
    private void mostrarMenuPrincipal(){
        this.getParent().add(new DisplayMenuPrincipal());
        this.getParent().remove(this);
    }
}

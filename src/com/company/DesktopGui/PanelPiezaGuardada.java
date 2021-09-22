package com.company.DesktopGui;

import javax.swing.JPanel;

import com.company.Tetris.Tetris;
import com.company.Tetris.TiposPieza.T;

import javax.swing.*;
import java.awt.*;

public class PanelPiezaGuardada extends JPanel {
    PanelGridCeldas piezaGuardada;
    
    public PanelPiezaGuardada() {
        setBackground(Color.LIGHT_GRAY);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        piezaGuardada = new PanelGridCeldas(new T());
        add(piezaGuardada);
    }
    
    public void actualizarPiezaGuardada(){
        removeAll();
        piezaGuardada = new PanelGridCeldas(Tetris.getPiezaGuardada());
        add(piezaGuardada);
    }
}

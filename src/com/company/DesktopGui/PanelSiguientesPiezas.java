package com.company.DesktopGui;

import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;
import com.company.Tetris.Pieza;
import com.company.Tetris.TiposPieza.Cuadrado;

public class PanelSiguientesPiezas extends JPanel {

    public PanelSiguientesPiezas() {
        setBackground(Color.lightGray);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        add(Box.createRigidArea(new Dimension(0, 25)));

        for (int i=0;i<3;i++) {
            add(new PanelGridCeldas(new Cuadrado()));
            add(Box.createRigidArea(new Dimension(0, 25)));
        }
    }

    public void actualizar(ArrayList<Pieza> piezas) {
        removeAll();
        add(Box.createRigidArea(new Dimension(0, 25)));
        for (Pieza pieza : piezas) {
            add(new PanelGridCeldas(pieza));
            add(Box.createRigidArea(new Dimension(0, 25)));
        }
        revalidate();
    }
}

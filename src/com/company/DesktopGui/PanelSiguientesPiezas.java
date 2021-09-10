package com.company.DesktopGui;

import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;
import com.company.*;

public class PanelSiguientesPiezas extends JPanel {
    Color color=Color.lightGray;
    public PanelSiguientesPiezas() {
        setBackground(color);
        //setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(Box.createRigidArea(new Dimension(0,25)));
        for (int i=0;i<3;i++) {
            add(new PanelGridCeldas(4,4));
            add(Box.createRigidArea(new Dimension(0,25)));
        }
    }
    public void actualizar(ArrayList<Pieza> piezas) {
        removeAll();
        add(Box.createRigidArea(new Dimension(0,25)));
        for (Pieza pieza : piezas) {
            add(new PanelGridCeldas(pieza,color));
            add(Box.createRigidArea(new Dimension(0,25)));
        }
        revalidate();
    }
}

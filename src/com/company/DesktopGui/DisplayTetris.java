package com.company.DesktopGui;

import com.company.Tetris.*;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class DisplayTetris extends JPanel {

    static PanelGridCeldas gridDeJuego;
    static PanelSiguientesPiezas panelSiguientesPiezas;

    public DisplayTetris() {
        setLayout(new FlowLayout());
        setBackground(Color.lightGray);

        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));

        leftPanel.add(new PanelJugadorInfo());

        panelSiguientesPiezas = new PanelSiguientesPiezas();
        leftPanel.add(panelSiguientesPiezas);

        JPanel opciones = new JPanel(new FlowLayout());
        opciones.setBackground(Color.BLACK);
        opciones.add(new JButton("Pausar"));
        opciones.add(new JButton("Guardar"));
        JButton jugar = new JButton("jugar");
        //jugar.addActionListener(new ListenerJugar());
        opciones.add(jugar);
        opciones.add(new BotonSalir());
        leftPanel.add(opciones);

        add(leftPanel);
        gridDeJuego = new PanelGridCeldas(20,10);
        add(gridDeJuego);
    }

    public void actualizarProximasPiezas(ArrayList<Pieza> piezas){
        panelSiguientesPiezas.actualizar(piezas);
    }
    
    public void actualizarGridDeJuego(Cuadricula cuadricula){
        gridDeJuego.actualizar(cuadricula);        
        revalidate();
        repaint();
    }

    public void resetGridDeJuego() {
        gridDeJuego.resetCuadricula();
    }
}

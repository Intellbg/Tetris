package com.company.DesktopGui;

import com.company.Tetris.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class DisplayTetris extends JFrame implements Runnable {

    private static PanelGridCeldas gridDeJuego;
    private static PanelTetrisAuxiliar panelIzquierdo;

    public DisplayTetris() {
        setPreferredSize(new Dimension(1200, 900));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBackground(Color.red);
        setLayout(new FlowLayout());

        JPanel contenedor = new JPanel();
        contenedor.setBackground(Color.lightGray);
        panelIzquierdo = new PanelTetrisAuxiliar();
        contenedor.add(panelIzquierdo);
        add(contenedor);

        add(Box.createRigidArea(new Dimension(50, 0)));

        gridDeJuego = new PanelGridCeldas(new Cuadricula());
        add(gridDeJuego);

        addKeyListener(new Control(this));
        setFocusable(true);
        setVisible(true);
        pack();
    }

    public void actualizarGridDeJuego(Cuadricula cuadricula) {
        gridDeJuego.actualizar(cuadricula);
        revalidate();
        repaint();
    }

    public void resetGridDeJuego() {
        gridDeJuego.resetCuadricula();
    }

    public void actualizarProximasPiezas(ArrayList<Pieza> proximasPiezas) {
        panelIzquierdo.actualizarProximasPiezas(proximasPiezas);
    }

    public void actualizarInformacion() {
        panelIzquierdo.actualizarInformacion();
    }

    public void actualizarPiezaGuardada() {
        panelIzquierdo.actualizarPiezaGuardada();
    }

    public void pausar() {
        panelIzquierdo.pausar();
    }

    public void reanudar() {
        panelIzquierdo.resumir();
    }

    @Override
    public void run() {
    }

    public void guardar() {
        panelIzquierdo.guardar();
    }

    public void alertarGameOver() {
        JOptionPane.showMessageDialog(null,"GAME OVER");
        panelIzquierdo.salir();
    }

}

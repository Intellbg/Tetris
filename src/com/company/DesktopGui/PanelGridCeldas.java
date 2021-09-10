package com.company.DesktopGui;

import com.company.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PanelGridCeldas extends JPanel implements KeyListener {
    int numeroFilas;
    int numeroColumnas;
    PanelCelda[][] gridCeldas;

    public PanelGridCeldas(int numeroFilas, int numeroColumnas) {
        this.numeroColumnas = numeroColumnas;
        this.numeroFilas = numeroFilas;
        gridCeldas=new PanelCelda[numeroFilas][numeroColumnas];
        setLayout(new GridLayout(numeroFilas+2, numeroColumnas));
        setPreferredSize(new Dimension(30 * numeroColumnas, 30 * numeroFilas));
        inicializarGrid();
        ajustarGrid();
        addKeyListener(this);
        setFocusable(true);
    }

    private void ajustarGrid() {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < numeroColumnas; j++) {
                getComponent(i * numeroColumnas + j).setVisible(false);
                add(new JPanel());
            }
        }
    }

    public PanelGridCeldas(Pieza pieza, Color color) {
        this.numeroColumnas = 4;
        this.numeroFilas = 4;
        gridCeldas=new PanelCelda[numeroFilas][numeroColumnas];
        // this.numeroColumnas = pieza.getNumeroColumnas() + 1;
        // this.numeroFilas = pieza.getNumeroFilas() + 1;
        setLayout(new GridLayout(numeroFilas, numeroColumnas));
        setPreferredSize(new Dimension(30 * numeroColumnas, 30 * numeroFilas));
        inicializarGrid(color);
        mostrarPieza(pieza);
    }

    private void inicializarGrid() {
        for (int i = 0; i < numeroFilas; i++) {
            for (int j = 0; j < numeroColumnas; j++) {
                gridCeldas[i][j]=new PanelCelda();
                add(gridCeldas[i][j]);
            }
        }
    }

    private void inicializarGrid(Color color) {
        for (int i = 0; i < numeroFilas; i++) {
            for (int j = 0; j < numeroColumnas; j++) {
                gridCeldas[i][j]=new PanelCelda(color);
                add(gridCeldas[i][j]);
            }
        }
    }

    public void mostrarPieza(Pieza pieza) {
        for (Celda celda : pieza.getForma()) {
            pintarCelda(celda);
        }
    }

    private void pintarCelda(Celda celda) {
        gridCeldas[celda.getPosicionI()][celda.getPosicionJ()].cambiarColor(celda.getColor());
    }


    public void actualizar(Cuadricula cuadricula) {
        Celda[][] celdas=cuadricula.getCeldas();
        Celda celda;
        resetCuadricula();

        for (int i = 0; i < numeroFilas; i++) {
            for (int j = 0; j < numeroColumnas; j++) {
                celda=celdas[i][j];
                if (celda != null) {
                    pintarCelda(celda);
                } else {
                    pintarCelda(new Celda(i, j));
                }
            }
        }
    }

    
    public void resetCuadricula() {
        for (int i = 0; i < numeroFilas; i++) {
            for (int j = 0; j < numeroColumnas; j++) {
                gridCeldas[i][j].cambiarColor(10);
  
            }
        }
        repaint();
        revalidate();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch(e.getKeyCode()){
            
            case 37:
                Tetris.moverPiezaActivaIzquierda();
                break;
            case 39:
                Tetris.moverPiezaActivaDerecha();
                break;
            case 40:
                Tetris.piezaActivaCae();
                break;
            case 82:
                Tetris.rotarPiezaActiva();
                break;
        }
        actualizar(Tetris.getCuadricula()); 
     
    }
    
    
    @Override
    public void keyTyped(KeyEvent e) {
            
    }
    
    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub

    }

}

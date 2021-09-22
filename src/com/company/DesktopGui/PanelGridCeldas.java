package com.company.DesktopGui;

import com.company.Tetris.*;
import javax.swing.*;
import java.awt.*;

public class PanelGridCeldas extends JPanel {
    int numeroFilas;
    int numeroColumnas;
    PanelCelda[][] gridCeldas;

    public PanelGridCeldas(Pieza pieza) {
        setPreferredSize(new Dimension(180, 70));
        this.numeroColumnas = pieza.obtenerCoordenadaMaximaJ() + 1;
        this.numeroFilas = pieza.obtenerCoordenadaMaximaI() + 1;
        gridCeldas = new PanelCelda[numeroFilas][numeroColumnas];
        setLayout(new GridLayout(numeroFilas, numeroColumnas));
        setMaximumSize(new Dimension(30 * numeroColumnas, 30 * numeroFilas));
        inicializarGrid(Color.lightGray);
        mostrarPieza(pieza);
    }

    public PanelGridCeldas(Cuadricula cuadricula) {
        this.numeroColumnas = cuadricula.NUMERO_COLUMNAS_MAXIMO;
        this.numeroFilas = cuadricula.NUMERO_FILAS_MAXIMO - 2;
        gridCeldas = new PanelCelda[numeroFilas][numeroColumnas];
        setPreferredSize(new Dimension(40 * numeroColumnas, 40 * numeroFilas));
        setLayout(new GridLayout(numeroFilas, numeroColumnas));
        inicializarGrid();
    }

    private void inicializarGrid() {
        for (int i = 0; i < numeroFilas; i++) {
            for (int j = 0; j < numeroColumnas; j++) {
                gridCeldas[i][j] = new PanelCelda();
                add(gridCeldas[i][j]);
            }
        }
    }

    private void inicializarGrid(Color color) {
        for (int i = 0; i < numeroFilas; i++) {
            for (int j = 0; j < numeroColumnas; j++) {
                gridCeldas[i][j] = new PanelCelda(color);
                add(gridCeldas[i][j]);
            }
        }
    }

    public void mostrarPieza(Pieza pieza) {
        for (Bloque celda : pieza.getForma()) {
            pintarCelda(celda);
        }
    }

    public void mostrarPiezaGridJuego(Pieza pieza) {
        for (Bloque celda : pieza.getForma()) {
            pintarCeldaGridJuego(celda);
        }
    }

    private void pintarCelda(Bloque celda) {
        gridCeldas[celda.getCoordenadaI()][celda.getCoordenadaJ()].cambiarColor(celda.getColor());
    }

    private void pintarCeldaGridJuego(Bloque celda) {
        gridCeldas[celda.getCoordenadaI()-2][celda.getCoordenadaJ()].cambiarColor(celda.getColor());
    }


    public void actualizar(Cuadricula cuadricula) {
        Bloque[][] celdas = cuadricula.getBloques();
        Bloque celda;
        resetCuadricula();

        for (int i = 0; i < numeroFilas; i++) {
            for (int j = 0; j < numeroColumnas; j++) {
                celda = celdas[i+2][j];
                if (celda != null) {
                    pintarCeldaGridJuego(celda);
                } else {
                    pintarCeldaGridJuego(new Bloque(i+2, j));
                }
            }
        }
    }

    public void resetCuadricula() {
        for (int i = 0; i < numeroFilas; i++) {
            for (int j = 0; j < numeroColumnas; j++) {
                gridCeldas[i][j].cambiarColor("negro");
            }
        }
        repaint();
        revalidate();
    }
}

package com.company.Tetris;

import java.util.ArrayList;

public class Cuadricula {
    private int NUMERO_FILAS_MAXIMO = 20;
    private int NUMERO_COLUMNAS_MAXIMO = 10;
    private Celda[][] celdas;

    private int origenPiezasI = 0;
    private int origenPiezasJ = 4;

    public Cuadricula() {
        this.celdas = new Celda[NUMERO_FILAS_MAXIMO][NUMERO_COLUMNAS_MAXIMO];
    }

    public int limpiarFilasCompletas(ArrayList<Integer> filas) {
        int puntos = 0;
        for (Integer fila : filas) {
            if (estaFilaCompleta(fila)) {
                limpiarFilaCompleta(fila);
                puntos += 100;
            }
        }
        return puntos;
    }



    private void limpiarFilaCompleta(int fila) {
        int filaAnterior;
        for (int i = fila; i > 0; i--) {
            filaAnterior = i - 1;
            if (filaAnterior < 0) {
                for (int j = 0; j < NUMERO_COLUMNAS_MAXIMO; j++) {
                    celdas[i][j] = null;
                }
            }
            for (int j = 0; j < NUMERO_COLUMNAS_MAXIMO; j++) {
                celdas[i][j] = celdas[filaAnterior][j];
                if (celdas[i][j] != null) {
                    celdas[i][j].setPosicion(i,j);
                }
            }
        }
    }

    public boolean estaFilaCompleta(int fila) {
        for (int columna = 0; columna < NUMERO_COLUMNAS_MAXIMO; columna++) {
            if (celdas[fila][columna] == null) {
                return false;
            }
        }
        return true;
    }

    public boolean verificarGameOver() {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < NUMERO_COLUMNAS_MAXIMO; j++) {
                if (celdas[i][j] != null) {
                    return true;
                }
            }
        }
        return false;
    }

    public void ponerPieza(Pieza pieza) {
        pieza.ajustarCoordenadasCeldas(this.origenPiezasI, this.origenPiezasJ);
        for (Celda celda : pieza.getForma()) {
            celdas[celda.getCoordenadaI()][celda.getCoordenadaJ()] = celda;
        }
    }

    public void mostrarPieza(Pieza pieza) {
        for (Celda celda : pieza.getForma()) {
            celdas[celda.getCoordenadaI()][celda.getCoordenadaJ()] = celda;
        }
    }

    public void ocultarPieza(Pieza pieza) {
        for (Celda celda : pieza.getForma()) {
            celdas[celda.getCoordenadaI()][celda.getCoordenadaJ()] = null;
        }
    }

    public boolean piezaPuedeCaer(Pieza pieza) {
        for (Celda celda : pieza.getForma()) {
            if (celda.getCoordenadaI() >= NUMERO_FILAS_MAXIMO - 1) {
                return false;
            }
            Celda celdaDeAbajo = getCelda(celda.getCoordenadaI() + 1, celda.getCoordenadaJ());
            if (celdaDeAbajo != null) {
                if (!pieza.pertenece(celdaDeAbajo)) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean piezaPuedeMoverIzquierda(Pieza pieza) {
        for (Celda celda : pieza.getForma()) {
            if (celda.getCoordenadaJ() - 1 < 0) {
                return false;
            }
            Celda celdaDeIzquierda = getCelda(celda.getCoordenadaI(), celda.getCoordenadaJ() - 1);
            if (celdaDeIzquierda != null) {
                if (!pieza.pertenece(celdaDeIzquierda)) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean piezaPuedeMoverDerecha(Pieza pieza) {
        for (Celda celda : pieza.getForma()) {
            if (celda.getCoordenadaJ() + 1 >= NUMERO_COLUMNAS_MAXIMO) {
                return false;
            }
            Celda celdaDeIzquierda = getCelda(celda.getCoordenadaI(), celda.getCoordenadaJ() + 1);
            if (celdaDeIzquierda != null) {
                if (!pieza.pertenece(celdaDeIzquierda)) {
                    return false;
                }
            }
        }
        return true;
    }

    private Celda getCelda(int fila, int columna) {
        return celdas[fila][columna];
    }

    public Celda[][] getCeldas() {
        return celdas;
    }

    @Override
    public String toString() {
        String cuadricula = "";
        for (int i = 0; i < NUMERO_FILAS_MAXIMO; i++) {
            for (int j = 0; j < NUMERO_COLUMNAS_MAXIMO; j++) {
                if (this.celdas[i][j] == null) {
                    cuadricula += "* ";
                } else {
                    cuadricula += this.celdas[i][j] + " ";
                }
            }
            cuadricula += "\n";
        }
        return cuadricula;
    }
}
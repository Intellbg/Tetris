package com.company.Tetris;
import java.io.Serializable;
import java.util.ArrayList;

import com.company.Tetris.TiposPieza.Linea;

public class Cuadricula implements Serializable{
    public final int NUMERO_FILAS_MAXIMO = 20;
    public final int NUMERO_COLUMNAS_MAXIMO = 10;
    private Bloque[][] bloques;

    private int origenPiezasI = 0;
    private int origenPiezasJ = 4;

    public Cuadricula() {
        this.bloques = new Bloque[NUMERO_FILAS_MAXIMO][NUMERO_COLUMNAS_MAXIMO];
    }

    // Metodos administracion de bloques
    public void mostartPiezaEnOrigen(Pieza pieza) {
        if (pieza instanceof Linea) {
            pieza.ajustarCoordenadasBloquesForma(origenPiezasI, 3);
            mostrarPieza(pieza);
            return;
        }
        pieza.ajustarCoordenadasBloquesForma(origenPiezasI, origenPiezasJ);
        mostrarPieza(pieza);
    }

    public void mostrarPieza(Pieza pieza) {
        for (Bloque bloque : pieza.getForma()) {
            bloques[bloque.getCoordenadaI()][bloque.getCoordenadaJ()] = bloque;
        }
    }

    public void ocultarPieza(Pieza pieza) {
        for (Bloque bloque : pieza.getForma()) {
            bloques[bloque.getCoordenadaI()][bloque.getCoordenadaJ()] = null;
        }
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
                    bloques[i][j] = null;
                }
            }
            for (int j = 0; j < NUMERO_COLUMNAS_MAXIMO; j++) {
                bloques[i][j] = bloques[filaAnterior][j];
                if (bloques[i][j] != null) {
                    bloques[i][j].setPosicion(i, j);
                }
            }
        }
    }

    // Metodos de control
    public void piezaPuedeMover(Pieza piezaPosicionFutura) throws Exception {
        ArrayList<Bloque> bloquesPosicionFutura = piezaPosicionFutura.getForma();
        estaBloqueFueraGridJuego(bloquesPosicionFutura);
        estaEspacioOcupado(bloquesPosicionFutura);
    }

    public void piezaPuedeRotar(Pieza piezaRotada) throws Exception{
        ArrayList<Bloque> bloquesPosicionFutura = piezaRotada.getForma();
        try {
            estaBloqueFueraGridJuego(bloquesPosicionFutura);
        } catch (Exception e) {
            if (e.getMessage() == "Desborde Derecho") {
                if (piezaRotada instanceof Linea) {
                    piezaRotada.ajustarCoordenadasBloquesForma(0, -2);
                }
                piezaRotada.ajustarCoordenadasBloquesForma(0, -1);
            }
        }finally{
            estaEspacioOcupado(bloquesPosicionFutura);
        }
    }

    private boolean estaEspacioOcupado(ArrayList<Bloque> bloquesEnPosicionFutura) throws Exception {
        for (Bloque bloque : bloquesEnPosicionFutura) {
            Bloque bloqueDeCuadricula = getBloque(bloque.getCoordenadaI(), bloque.getCoordenadaJ());
            if (bloqueDeCuadricula != null) {
                if (!bloquesEnPosicionFutura.contains(bloqueDeCuadricula)) {
                    throw new Exception("Posicion Ocupada");
                }
            }
        }
        return false;
    }

    private void estaBloqueFueraGridJuego(ArrayList<Bloque> bloquesEnPosicionFutura) throws Exception {
        for (Bloque bloque : bloquesEnPosicionFutura) {
            if (bloque.getCoordenadaI() >= NUMERO_FILAS_MAXIMO) {
                throw new Exception("Desborde Inferior");
            }
            if (bloque.getCoordenadaI() < 0) {
                throw new Exception("Desborde Superior");
            }
            if (bloque.getCoordenadaJ() >= NUMERO_COLUMNAS_MAXIMO) {
                throw new Exception("Desborde Derecho");
            }
            if (bloque.getCoordenadaJ() < 0) {
                throw new Exception("Desborde Izquierdo");
            }
        }
    }

    public boolean estaFilaCompleta(int fila) {
        for (int columna = 0; columna < NUMERO_COLUMNAS_MAXIMO; columna++) {
            if (bloques[fila][columna] == null) {
                return false;
            }
        }
        return true;
    }

    public boolean verificarGameOver() {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < NUMERO_COLUMNAS_MAXIMO; j++) {
                if (bloques[i][j] != null) {
                    return true;
                }
            }
        }
        return false;
    }

    // Getters
    private Bloque getBloque(int fila, int columna) {
        return bloques[fila][columna];
    }

    public Bloque[][] getBloques() {
        return bloques;
    }

    // Metodos auxiliares
    @Override
    public String toString() {
        String cuadricula = "";
        for (int i = 0; i < NUMERO_FILAS_MAXIMO; i++) {
            for (int j = 0; j < NUMERO_COLUMNAS_MAXIMO; j++) {
                if (this.bloques[i][j] == null) {
                    cuadricula += "* ";
                } else {
                    cuadricula += "0 ";
                    // cuadricula += this.bloques[i][j]. + " ";
                }
            }
            cuadricula += "\n";
        }
        return cuadricula;
    }
}
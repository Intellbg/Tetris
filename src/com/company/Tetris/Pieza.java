package com.company.Tetris;

import java.util.*;
import com.company.Tetris.*;
import com.company.Tetris.TiposPieza.*;

public abstract class Pieza {
    private ArrayList<Celda> forma;
    private int numeroColumnas;
    private int numeroFilas;
    private int color;
    private boolean horizontal = true;

    public Pieza(int color, Celda... celda) {
        this.forma = new ArrayList<Celda>(Arrays.asList(celda));
        this.numeroFilas = Collections.max(forma, new comparePositionI()).getCoordenadaI();
        this.numeroColumnas = Collections.max(forma, new comparePositionJ()).getCoordenadaJ();
        this.color = color;
        asignarColorCeldas();
    }

    public void asignarColorCeldas() {
        for (Celda celda : forma) {
            celda.setColor(this.color);
        }
    }

    public int getColor() {
        return color;
    }

    public void caer() {
        for (Celda celda : forma) {
            celda.moverAbajo();
        }
    }

    public void moverIzquierda() {
        for (Celda celda : forma) {
            celda.moverIzquierda();
        }
    }

    public void moverDerecha() {
        for (Celda celda : forma) {
            celda.moverDerecha();
            ;
        }
    }

    public ArrayList<Celda> getForma() {
        return forma;
    }

    public void ajustarCoordenadasCeldas(int origenPiezasI, int origenPiezasJ) {
        if (this instanceof Linea) {
            origenPiezasJ = 3;
        }
        for (Celda celda : forma) {
            celda.setPosicion(origenPiezasI + celda.getCoordenadaI(), origenPiezasJ + celda.getCoordenadaJ());
        }
    }

    private void ponerCoordenadasOrigenRelativo(int origenI, int origenJ) {
        for (Celda celda : forma) {
            celda.setCoordenadaI(origenI + celda.getCoordenadaI());
            celda.setCoordenadaJ(origenJ + celda.getCoordenadaJ());
        }
    }

    public boolean pertenece(Celda celda) {
        return forma.contains(celda);
    }

    public void rotatarAntiHorario() {
        int temp;
        int coordRotacionI = Collections.min(forma, new comparePositionI()).getCoordenadaI();
        int coordRotacionJ = Collections.min(forma, new comparePositionJ()).getCoordenadaJ();
        if (horizontal) {
            coordRotacionJ = coordRotacionJ + 1;
        }
        if (!horizontal) {
            coordRotacionI = coordRotacionI + 1;
        }
        ponerCoordenadasOrigenRelativo(-coordRotacionI, -coordRotacionJ);
        for (Celda celda : forma) {
            temp = celda.getCoordenadaI();
            celda.setPosicion(celda.getCoordenadaJ(),numeroFilas - 1 - temp);
        }
        ponerCoordenadasOrigenRelativo(coordRotacionI, coordRotacionJ);
        horizontal = !horizontal;
    }
    // TODO: Componente cuadricula permita la rotacion de pieza activa
}

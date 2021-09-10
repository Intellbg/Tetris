package com.company;

import java.util.*;

import com.company.TiposPieza.Linea;

public abstract class Pieza {
    private ArrayList<Celda> forma;
    private int numeroColumnas;
    private int numeroFilas;
    private int color;
    private boolean horizontal = true;

    public Pieza(int color, Celda... celda) {
        this.forma = new ArrayList<Celda>(Arrays.asList(celda));
        this.numeroFilas = Collections.max(forma, new comparePositionI()).getPosicionI();
        this.numeroColumnas = Collections.max(forma, new comparePositionJ()).getPosicionJ();
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

    public int getNumeroColumnas() {
        return numeroColumnas;
    }

    public int getNumeroFilas() {
        return numeroFilas;
    }

    public void caer() {
        for (Celda celda : forma) {
            celda.setPosicionI(celda.getPosicionI() + 1);
        }
    }

    public void moverIzquierda() {
        for (Celda celda : forma) {
            celda.setPosicionJ(celda.getPosicionJ() - 1);
        }
    }

    public void moverDerecha() {
        for (Celda celda : forma) {
            celda.setPosicionJ(celda.getPosicionJ() + 1);
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
            celda.setPosicionI(origenPiezasI + celda.getPosicionI());
            celda.setPosicionJ(origenPiezasJ + celda.getPosicionJ());
        }
    }

    private void coordenadasOrigenRelativo(int origenI, int origenJ) {
        for (Celda celda : forma) {
            celda.setPosicionI(origenI + celda.getPosicionI());
            celda.setPosicionJ(origenJ + celda.getPosicionJ());
        }
    }

    public boolean pertenece(Celda celda) {
        return forma.contains(celda);
    }

    public void rotatarAntiHorario() {
        int temp;
        int coordRotacionI = Collections.min(forma, new comparePositionI()).getPosicionI();
        int coordRotacionJ = Collections.min(forma, new comparePositionJ()).getPosicionJ();
        if (horizontal) {
            coordRotacionJ = coordRotacionJ + 1;
        }
        if (!horizontal) {
            coordRotacionI = coordRotacionI + 1;
        }
        coordenadasOrigenRelativo(-coordRotacionI, -coordRotacionJ);
        for (Celda celda : forma) {
            temp = celda.getPosicionI();
            celda.setPosicionI(celda.getPosicionJ());
            celda.setPosicionJ(numeroFilas - 1 - temp);
        }
        coordenadasOrigenRelativo(coordRotacionI, coordRotacionJ);
        horizontal = !horizontal;
    }
    // TODO: Componente cuadricula permita la rotacion de pieza activa
}

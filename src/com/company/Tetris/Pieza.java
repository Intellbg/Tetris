package com.company.Tetris;

import java.awt.Color;
import java.util.*;

public abstract class Pieza {
    protected ArrayList<Bloque> forma;
    protected int numeroFilas;
    protected int numeroColumnas;
    protected boolean estaColocada;
    private boolean tieneHorientacionVertical;
    private String color;

    public Pieza(String color, Bloque... bloque) {
        this.forma = new ArrayList<Bloque>(Arrays.asList(bloque));
        this.numeroFilas = obtenerCoordenadaMaximaI();
        this.numeroColumnas =obtenerCoordenadaMaximaJ();
        this.color = color;
        this.estaColocada = false;
        this.tieneHorientacionVertical = false;
        asignarColorBloques();
    }

    public void asignarColorBloques() {
        for (Bloque bloque : forma) {
            bloque.setColor(this.color);
        }
    }

    // Metodos de movimiento
    public void moverAbajo() {
        for (Bloque bloque : forma) {
            bloque.moverAbajo();
        }
    }

    public void moverArriba() {
        for (Bloque bloque : forma) {
            bloque.moverArriba();
        }
    }

    public void moverIzquierda() {
        for (Bloque bloque : forma) {
            bloque.moverIzquierda();
        }
    }

    public void moverDerecha() {
        for (Bloque bloque : forma) {
            bloque.moverDerecha();
        }
    }

    public void rotarHorario() {
        int coordRotacionI = obtenerCoordenadaMinimaI();
        int coordRotacionJ = obtenerCoordenadaMinimaJ();
        ajustarCoordenadasBloquesForma(-coordRotacionI, -coordRotacionJ);
        for (Bloque bloque : forma) {
            bloque.setPosicion(bloque.getCoordenadaJ(), numeroFilas - 1 - bloque.getCoordenadaI());
        }
        if (tieneHorientacionVertical) {
            coordRotacionJ++;
        }
        ajustarCoordenadasBloquesForma(coordRotacionI, coordRotacionJ + 1);
        tieneHorientacionVertical = !tieneHorientacionVertical;
    }

    public void rotarAntiHorario() {
        int coordRotacionI = obtenerCoordenadaMinimaI();
        int coordRotacionJ = obtenerCoordenadaMinimaJ();
        ajustarCoordenadasBloquesForma(-coordRotacionI, -coordRotacionJ);
        for (Bloque bloque : forma) {
            bloque.setPosicion(numeroColumnas - 1 - bloque.getCoordenadaJ(), bloque.getCoordenadaI());
        }
        if (!tieneHorientacionVertical) {
            coordRotacionI++;
        }
        ajustarCoordenadasBloquesForma(coordRotacionI, coordRotacionJ);
        tieneHorientacionVertical = !tieneHorientacionVertical;
    }

    // Metodos de control
    public boolean estaColocada() {
        return estaColocada;
    }

    public boolean bloquePerteneceAPieza(Bloque bloque) {
        return forma.contains(bloque);
    }

    // Metodos auxiliares
    public void marcarPiezaComoColocada() {
        estaColocada = true;
    }

    public void resetCoordenadas(){
        ajustarCoordenadasBloquesForma(-obtenerCoordenadaMinimaI(), -obtenerCoordenadaMinimaJ());
    }

    protected void transponerCoordenadasBloquesForma() {
        for (Bloque bloque : forma) {
            bloque.transponerCoordenadas();
        }
    }

    protected void ajustarCoordenadasBloquesForma(int origenPiezasI, int origenPiezasJ) {
        for (Bloque bloque : forma) {
            bloque.setPosicion(origenPiezasI + bloque.getCoordenadaI(), origenPiezasJ + bloque.getCoordenadaJ());
        }
    }


    protected int obtenerCoordenadaMinimaI() {
        Bloque bloqueMasIzquierdo = Collections.min(forma, (a, b) -> a.getCoordenadaI() - b.getCoordenadaI());
        return bloqueMasIzquierdo.getCoordenadaI();
    }

    protected int obtenerCoordenadaMinimaJ() {
        Bloque bloqueMasAlto = Collections.min(forma, (a, b) -> a.getCoordenadaJ() - b.getCoordenadaJ());
        return bloqueMasAlto.getCoordenadaJ();
    }

    public int obtenerCoordenadaMaximaJ() {
        Bloque bloqueMasDerecho = Collections.max(forma, (a, b) -> a.getCoordenadaJ() - b.getCoordenadaJ());
        return bloqueMasDerecho.getCoordenadaJ();
    }

    public int obtenerCoordenadaMaximaI() {
        Bloque bloqueMasBajo = Collections.max(forma, (a, b) -> a.getCoordenadaI() - b.getCoordenadaI());
        return bloqueMasBajo.getCoordenadaI();
    }

    // Getters
    public ArrayList<Bloque> getForma() {
        return forma;
    }

    public String getColor() {
        return color;
    }

}

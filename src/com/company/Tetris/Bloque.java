package com.company.Tetris;

import java.io.Serializable;

public class Bloque implements Serializable{
    private String color;
    private int coordenadaI;
    private int coordenadaJ;

    public Bloque(int coordenadaI, int coordenadaJ) {
        this.color="blanco";
        this.coordenadaI = coordenadaI;
        this.coordenadaJ = coordenadaJ;
    }

    public void moverAbajo() {
        coordenadaI++;
    }

    public void moverArriba() {
        coordenadaI--;
    }

    public void moverDerecha() {
        coordenadaJ++;
    }

    public void moverIzquierda() {
        coordenadaJ--;
    }

    public void setPosicion(int coordenadaI, int coordenadaJ) {
        this.coordenadaI = coordenadaI;
        this.coordenadaJ = coordenadaJ;
    }

    public void setCoordenadaI(int coordenadaI) {
        this.coordenadaI = coordenadaI;
    }

    public void setCoordenadaJ(int coordenadaJ) {
        this.coordenadaJ = coordenadaJ;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getCoordenadaI() {
        return coordenadaI;
    }

    public int getCoordenadaJ() {
        return coordenadaJ;
    }

    public String getColor() {
        return color;
    }

    public void transponerCoordenadas() {
        int coordenadaTemporal=coordenadaI;
        coordenadaI=coordenadaJ;
        coordenadaJ=coordenadaTemporal;
    }

}

package com.company.Tetris;

public class Celda {
    private int color;
    private int coordenadaI;
    private int coordenadaJ;

    public Celda(int coordenadaI, int coordenadaJ) {
        this.color = 100;
        this.coordenadaI = coordenadaI;
        this.coordenadaJ = coordenadaJ;
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

    public void setColor(int color) {
        this.color = color;
    }

    public int getCoordenadaI() {
        return coordenadaI;
    }

    public int getCoordenadaJ() {
        return coordenadaJ;
    }

    public int getColor() {
        return color;
    }

    @Override
    public String toString() {
        return Integer.toString(color);
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

}

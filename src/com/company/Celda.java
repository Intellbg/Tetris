package com.company;

public class Celda {
    private int color;
    private int posicionI;
    private int posicionJ;

    public Celda(int posicionI,int posicionJ) {
        this.color=100;
        this.posicionI=posicionI;
        this.posicionJ=posicionJ;
    }

    public int getPosicionI() {
        return posicionI;
    }

    public void setPosicionI(int posicionI) {
        this.posicionI = posicionI;
    }

    public int getPosicionJ() {
        return posicionJ;
    }

    public void setPosicionJ(int posicionJ) {
        this.posicionJ = posicionJ;
    }
    
    public int getColor() {
        return color;
    }
    public void setColor(int color) {
        this.color=color;
    }

    @Override
    public String toString() {
        return Integer.toString(color);
    }

}

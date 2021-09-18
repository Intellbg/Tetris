package com.company.Tetris;

public class Jugador {
    private String nombre;
    private int puntaje;
    private int nivel;

    public Jugador(String nombre) {
        this.nombre = nombre;
        this.puntaje = 0;
        this.nivel = 1;
    }

    public void subirNivel() {
        nivel++;
    }

    public void sumarPuntaje(int puntos) {
        puntaje += puntos;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public int getNivel() {
        return nivel;
    }

    @Override
    public String toString() {
        return nombre + " nivel: " + nivel + " puntaje: " + puntaje;
    }
}

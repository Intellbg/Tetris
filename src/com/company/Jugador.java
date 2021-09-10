package com.company;

public class Jugador {
    private String nombre;
    private int puntaje;

    public Jugador(String nombre) {
        this.nombre = nombre;
        this.puntaje=0;
    }

    public void setPuntaje(int puntos){
        this.puntaje=this.puntaje+puntos;
    }

    @Override
    public String toString() {
        return "Jugador [nombre=" + nombre + "]";
    }

    public int getPuntaje() {
        return puntaje;
    }

}

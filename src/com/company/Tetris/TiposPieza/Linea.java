package com.company.Tetris.TiposPieza;

import com.company.Tetris.*;

public class Linea extends Pieza {

    public Linea() {
        super("cyan", new Bloque(0, 0), new Bloque(0, 1), new Bloque(0, 2), new Bloque(0, 3));
    }

    @Override
    public void rotarHorario() {
        int coordRotacionI = obtenerCoordenadaMinimaI();
        int coordRotacionJ = obtenerCoordenadaMinimaJ();
        ajustarCoordenadasBloquesForma(-coordRotacionI, -coordRotacionJ);
        super.transponerCoordenadasBloquesForma();
        ajustarCoordenadasBloquesForma(coordRotacionI, coordRotacionJ);
    }

    @Override
    public void rotarAntiHorario() {
        rotarHorario();
    }
}

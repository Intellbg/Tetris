package com.company.Tetris.TiposPieza;

import com.company.Tetris.*;

public class Cuadrado extends Pieza {

    public Cuadrado() {
        super(1,new Celda(0, 0),new Celda(0, 1),new Celda(1, 0),new Celda(1, 1));
    }
    @Override
    public void rotatarAntiHorario(){}
}
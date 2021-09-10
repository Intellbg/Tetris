package com.company;

import java.util.Comparator;

public class comparePositionJ implements Comparator<Celda> {

    @Override
    public int compare(Celda celda1, Celda celda2) {
        return celda1.getPosicionJ() - celda2.getPosicionJ();
    }
}

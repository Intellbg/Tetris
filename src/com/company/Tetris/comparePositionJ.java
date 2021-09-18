package com.company.Tetris;

import java.util.Comparator;

public class comparePositionJ implements Comparator<Celda> {

    @Override
    public int compare(Celda celda1, Celda celda2) {
        return celda1.getCoordenadaJ() - celda2.getCoordenadaJ();
    }
}

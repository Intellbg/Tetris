package com.company.Tetris;

import java.util.Comparator;

public class comparePositionI implements Comparator<Celda> {

    @Override
    public int compare(Celda celda1, Celda celda2) {
        return celda1.getCoordenadaI() - celda2.getCoordenadaI();
    }

}

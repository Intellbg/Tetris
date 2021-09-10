package com.company;

import java.util.Comparator;

public class comparePositionI implements Comparator<Celda> {

    @Override
    public int compare(Celda celda1, Celda celda2) {
        return celda1.getPosicionI() - celda2.getPosicionI();
    }

}

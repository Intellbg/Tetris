package com.company.TiposPieza;

import com.company.Celda;
import com.company.Pieza;

public class T extends Pieza{
    public T() {
        super(6,new Celda(0, 1),new Celda(1, 0),new Celda(1, 1),new Celda(1, 2));
    }
}

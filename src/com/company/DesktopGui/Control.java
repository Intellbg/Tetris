package com.company.DesktopGui;

import com.company.Tetris.Tetris;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Control implements KeyListener {

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {

            case 37: // flecha izquierda
                Tetris.moverPiezaActivaIzquierda();
                break;
            case 39: // flecha derecha
                Tetris.moverPiezaActivaDerecha();
                break;
            case 40: // flecha abajo
                Tetris.moverPiezaActivaAbajo();
                break;
            case 82: // r
                Tetris.rotarPiezaActivaHorario();
                break;
            case 67: // c
                Tetris.guardarPieza();
                break;
            case 27: // ESC
                if (Tetris.estaPausado()) {
                    Tetris.reanudarJuego();
                    break;
                }
                Tetris.pausarJuego();
                break;
            case 71: // g
                Tetris.guardarJuego();
                break;
        }
        // DesktopGui.actualizarGridDeJuego(Tetris.getCuadricula());
        // System.out.println(e.getKeyCode());
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub

    }
}

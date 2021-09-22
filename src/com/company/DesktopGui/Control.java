package com.company.DesktopGui;

import com.company.Tetris.Tetris;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Control implements KeyListener {
    DisplayTetris tetris;
    public Control(DisplayTetris tetris){
        this.tetris=tetris;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {

            case 37: // flecha izquierda
                Tetris.moverPiezaActivaIzquierda();
                tetris.actualizarGridDeJuego(Tetris.getCuadricula());
                break;
            case 39: // flecha derecha
                Tetris.moverPiezaActivaDerecha();
                tetris.actualizarGridDeJuego(Tetris.getCuadricula());
                break;
            case 40: // flecha abajo
                Tetris.moverPiezaActivaAbajo();
                tetris.actualizarGridDeJuego(Tetris.getCuadricula());
                break;
            case 82: // r
                Tetris.rotarPiezaActivaHorario();
                tetris.actualizarGridDeJuego(Tetris.getCuadricula());
                break;
            case 67: // c
                Tetris.guardarPieza();
                tetris.actualizarPiezaGuardada();
                break;
            case 27: // ESC
                if (Tetris.estaPausado()) {
                    tetris.reanudar();
                    break;
                }
                tetris.pausar();
                break;
            case 71: // g
                tetris.guardar();
                break;
        }
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

package com.company.DesktopGui;

import com.company.Tetris.Tetris;

public class PartidaTetris extends Thread {
    DisplayTetris tetrisDisplay;
    public PartidaTetris(DisplayTetris tetrisDisplay){
        this.tetrisDisplay=tetrisDisplay;
    }

    @Override
    public void run() {
        tetrisDisplay.actualizarInformacion();
        tetrisDisplay.actualizarPiezaGuardada();
        while (!Tetris.verificarGameover()) {
            Tetris.ponerPiezaEnCuadricula();
            tetrisDisplay.actualizarProximasPiezas(Tetris.getProximasPiezas());
            tetrisDisplay.actualizarGridDeJuego(Tetris.getCuadricula());
            while (!Tetris.piezaActivaEstaColocada()) {
                if (!Tetris.estaPausado()) {
                    try {
                        Thread.sleep(Tetris.calcularVelocidadCaida());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    Tetris.piezaActivaMovimientoPrincipal();
                    tetrisDisplay.actualizarGridDeJuego(Tetris.getCuadricula());
                }
                System.out.print("");
            }
            Tetris.asignarPuntaje();
            tetrisDisplay.actualizarInformacion();
        }
        tetrisDisplay.alertarGameOver();
    }
}

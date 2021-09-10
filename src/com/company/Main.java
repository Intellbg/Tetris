package com.company;

import com.company.DesktopGui.*;



public class Main {
    public static void main(String[] args) {
        DesktopGui desktopGui=new DesktopGui();
        Tetris.iniciarSesion();
        while(!Tetris.gameover()){
            Tetris.ponerPiezaEnCuadricula();
            desktopGui.actualizarPanelProximasPiezas(Tetris.getProximasPiezas());
            desktopGui.actualizarGridDeJuego(Tetris.getCuadricula());
            while(Tetris.piezaActivaPuedeCaer()){
                try {
                    Thread.sleep(500);
                    Tetris.piezaActivaCae();
                    desktopGui.actualizarGridDeJuego(Tetris.getCuadricula());
                } catch (Exception e) {
                    //TODO: handle exception
                }
            }
            Tetris.limpiarFilasCompletas();
        }

        System.out.println("GG WP");
        System.out.println(Tetris.getPuntaje());
    }
}

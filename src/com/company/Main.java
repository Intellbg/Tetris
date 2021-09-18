package com.company;

import com.company.DesktopGui.*;
import com.company.Tetris.Tetris;



public class Main {
    public static void main(String[] args) {
        DesktopGui desktopGui=new DesktopGui();
        Tetris.iniciarSesion();
        while(!Tetris.verificarGameover()){
            Tetris.ponerPiezaEnCuadricula();
            desktopGui.actualizarPanelProximasPiezas(Tetris.getProximasPiezas());
            desktopGui.actualizarGridDeJuego(Tetris.getCuadricula());
            while(Tetris.piezaActivaPuedeCaer()){
                try {

                    Thread.sleep(500/Tetris.getNivel());
                    Tetris.piezaActivaCae();
                    desktopGui.actualizarGridDeJuego(Tetris.getCuadricula());
                    //System.out.println(Tetris.getCuadricula());
                } catch (Exception e) {
                    //TODO: handle exception
                }
            }
            Tetris.asignarPuntaje();
        }

        System.out.println("GG WP");
        System.out.println(Tetris.getPuntaje());
    }
}

package com.company.Tetris;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import com.company.Tetris.TiposPieza.*;

public class Tetris {

    private static Cuadricula cuadricula;
    private static ArrayList<Pieza> proximasPiezas = new ArrayList<>();
    private static Pieza piezaActiva;
    private static Pieza piezaGuardada;
    private static Jugador jugador;

    public static void iniciarSesion() {
        jugador = new Jugador("Invitado");
        cuadricula = new Cuadricula();
        for (int i = 0; i < 3; i++) {
            proximasPiezas.add(generarPieza());
        }
    }

    public static void guardarPieza(){
        cuadricula.ocultarPieza(piezaActiva);
        if (piezaGuardada==null){
            piezaGuardada=piezaActiva;
            ponerPiezaEnCuadricula();
            return;
        }
        Pieza temporal=piezaActiva;
        piezaActiva=piezaGuardada;
        piezaGuardada=temporal;
        cuadricula.ponerPieza(piezaActiva);
    }

    public static Pieza ponerPiezaEnCuadricula() {
        piezaActiva = proximasPiezas.remove(0);
        cuadricula.ponerPieza(piezaActiva);
        proximasPiezas.add(generarPieza());
        return piezaActiva;
    }

    public static boolean piezaActivaPuedeCaer() {
        return cuadricula.piezaPuedeCaer(piezaActiva);
    }

    public static void piezaActivaCae() {
        if (cuadricula.piezaPuedeCaer(piezaActiva)) {
            cuadricula.ocultarPieza(piezaActiva);
            piezaActiva.caer();
            cuadricula.mostrarPieza(piezaActiva);
        }
    }

    private static Pieza generarPieza() {
        switch (generarNumeroRandom()) {
            case 0:
                return new Cuadrado();
            case 1:
                return new Linea();
            case 2:
                return new T();
            case 3:
                return new S();
            case 4:
                return new Z();
            case 5:
                return new L();
            case 6:
                return new J();
        }
        System.out.println("Error en generacion");
        return null;
    }

    private static int generarNumeroRandom() {
        Random rand = new Random();
        return rand.nextInt(7);
    }

    public static boolean verificarGameover() {
        return cuadricula.verificarGameOver();
    }

    public static Cuadricula getCuadricula() {
        return cuadricula;
    }

    public static ArrayList<Pieza> getProximasPiezas() {
        return proximasPiezas;
    }

    public Pieza getPiezaActiva() {
        return piezaActiva;
    }

    public static void moverPiezaActivaIzquierda() {
        if (cuadricula.piezaPuedeMoverIzquierda(piezaActiva)) {
            cuadricula.ocultarPieza(piezaActiva);
            piezaActiva.moverIzquierda();
            cuadricula.mostrarPieza(piezaActiva);
        }
    }

    public static void moverPiezaActivaDerecha() {
        if (cuadricula.piezaPuedeMoverDerecha(piezaActiva)) {
            cuadricula.ocultarPieza(piezaActiva);
            piezaActiva.moverDerecha();
            cuadricula.mostrarPieza(piezaActiva);
        }
    }

    public static void asignarPuntaje() {
        int puntaje = cuadricula.limpiarFilasCompletas(obtenerPosiblesFilasCompletas());
        if (puntaje == 400) {
            jugador.subirNivel();
        }
        jugador.sumarPuntaje(puntaje);

    }

    public static void cargarJuego() {

    }

    public static int getPuntaje() {
        return jugador.getPuntaje();
    }

    public static void rotarPiezaActiva() {
        cuadricula.ocultarPieza(piezaActiva);
        piezaActiva.rotatarAntiHorario();
        cuadricula.mostrarPieza(piezaActiva);
    }

    public static int getNivel() {
        return jugador.getNivel();
    }

    private static ArrayList<Integer> obtenerPosiblesFilasCompletas() {
        ArrayList<Integer> posiblesFilasCompletas = new ArrayList<Integer>();
        for (Celda celda : piezaActiva.getForma()) {
            if (!posiblesFilasCompletas.contains(celda.getCoordenadaI())) {
                posiblesFilasCompletas.add(celda.getCoordenadaI());
            }
        }
        Collections.sort(posiblesFilasCompletas);
        return posiblesFilasCompletas;
    }

    
}

package com.company.Tetris;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import com.company.Tetris.TiposPieza.*;

public class Tetris {
    private static Pieza piezaActiva;
    private static Pieza piezaGuardada;
    private static Cuadricula cuadricula;
    private static ArrayList<Pieza> proximasPiezas;
    private static Jugador jugador;
    private static boolean estaPausado;
    private static boolean gameOver;

    // Metodos de configuracion y generacion
    public static void iniciarSesion(String nombreJugador) {
        estaPausado = false;
        gameOver = false;
        jugador = new Jugador(nombreJugador);
        cuadricula = new Cuadricula();
        piezaGuardada = generarPieza();
        proximasPiezas = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            proximasPiezas.add(generarPieza());
        }
    }

    public static void iniciarSesion(Jugador jugadorR, Cuadricula cuadriculaR) {
        estaPausado = false;
        gameOver = false;
        jugador = jugadorR;
        cuadricula = cuadriculaR;
        piezaGuardada = generarPieza();
        proximasPiezas = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            proximasPiezas.add(generarPieza());
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

    public static Pieza ponerPiezaEnCuadricula() {
        piezaActiva = proximasPiezas.remove(0);
        cuadricula.mostartPiezaEnOrigen(piezaActiva);
        proximasPiezas.add(generarPieza());
        return piezaActiva;
    }

    public static void guardarPieza() {
        cuadricula.ocultarPieza(piezaActiva);
        Pieza temporal = piezaActiva;
        piezaActiva = piezaGuardada;
        piezaGuardada = temporal;
        piezaGuardada.resetCoordenadas();
        cuadricula.mostartPiezaEnOrigen(piezaActiva);
    }

    // Metodos para control
    public static boolean piezaActivaEstaColocada() {
        return piezaActiva.estaColocada();
    }

    public static boolean verificarGameover() {
        return gameOver;
    }

    // Metodos de Movimientos de pieza Activa
    public static void piezaActivaMovimientoPrincipal() {
        moverPiezaActivaAbajo();
    }

    public static void moverPiezaActivaAbajo() {
        cuadricula.ocultarPieza(piezaActiva);
        piezaActiva.moverAbajo();
        try {
            cuadricula.piezaPuedeMover(piezaActiva);
        } catch (Exception e) {
            piezaActiva.moverArriba();
            piezaActiva.marcarPiezaComoColocada();
        } finally {
            cuadricula.mostrarPieza(piezaActiva);
        }
    }

    public static void moverPiezaActivaIzquierda() {
        cuadricula.ocultarPieza(piezaActiva);
        piezaActiva.moverIzquierda();
        try {
            cuadricula.piezaPuedeMover(piezaActiva);
        } catch (Exception e) {
            piezaActiva.moverDerecha();
        } finally {
            cuadricula.mostrarPieza(piezaActiva);
        }
    }

    public static void moverPiezaActivaDerecha() {
        cuadricula.ocultarPieza(piezaActiva);
        piezaActiva.moverDerecha();
        try {
            cuadricula.piezaPuedeMover(piezaActiva);
        } catch (Exception e) {
            piezaActiva.moverIzquierda();
        } finally {
            cuadricula.mostrarPieza(piezaActiva);
        }
    }

    public static void rotarPiezaActivaHorario() {
        cuadricula.ocultarPieza(piezaActiva);
        piezaActiva.rotarHorario();
        try {
            cuadricula.piezaPuedeRotar(piezaActiva);
        } catch (Exception e) {
            if (piezaActiva instanceof Linea) {
                piezaActiva.ajustarCoordenadasBloquesForma(0, 2);
            }
            piezaActiva.ajustarCoordenadasBloquesForma(0, 1);
            piezaActiva.rotarAntiHorario();
        }
        cuadricula.mostrarPieza(piezaActiva);
    }

    // Metodos relacionados con jugador
    public static void asignarPuntaje() {
        int puntaje = cuadricula.limpiarFilasCompletas(obtenerPosiblesFilasCompletas());
        if (puntaje == 400) {
            jugador.subirNivel();
        }
        jugador.sumarPuntaje(puntaje);
        gameOver = cuadricula.verificarGameOver();
    }

    // Getters
    public static String getNombreJugador() {
        return jugador.getNombre();
    }

    public static int getPuntaje() {
        return jugador.getPuntaje();
    }

    public static int getNivel() {
        return jugador.getNivel();
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

    // Metodos memoriaPermante
    public static void cargarJuego(String pathArchivo) {
        GestorDeArchivos.recuperarPartida(pathArchivo);
    }

    public static void guardarJuego() {
        cuadricula.ocultarPieza(piezaActiva);
        gameOver = true;
        piezaActiva.marcarPiezaComoColocada();
        GestorDeArchivos.guardarPartida();
    }

    // Metodos Auxiliares
    private static int generarNumeroRandom() {
        Random rand = new Random();
        return rand.nextInt(7);
    }

    private static ArrayList<Integer> obtenerPosiblesFilasCompletas() {
        ArrayList<Integer> posiblesFilasCompletas = new ArrayList<Integer>();
        for (Bloque celda : piezaActiva.getForma()) {
            if (!posiblesFilasCompletas.contains(celda.getCoordenadaI())) {
                posiblesFilasCompletas.add(celda.getCoordenadaI());
            }
        }
        Collections.sort(posiblesFilasCompletas);
        return posiblesFilasCompletas;
    }

    public static void reanudarJuego() {
        estaPausado = false;
    }

    public static void pausarJuego() {
        estaPausado = true;
    }

    public static int calcularVelocidadCaida() {
        return 500 / getNivel();
    }

    public static boolean estaPausado() {
        return estaPausado;
    }

    public static Jugador getJugador() {
        return jugador;
    }

    public static void finalizarSesion() {
        ArrayList<Jugador> mejoresJugadores = GestorDeArchivos.obtenerMejoresJugadores();
        mejoresJugadores.add(jugador);
        mejoresJugadores.sort((a, b) -> a.getPuntaje() - b.getPuntaje());
        Collections.reverse(mejoresJugadores);
        mejoresJugadores.remove(mejoresJugadores.size() - 1);
        GestorDeArchivos.guardarMejoresJugadores(mejoresJugadores);
    }

    public static ArrayList<Jugador> obtenerMejoresJugadores(){
        return GestorDeArchivos.obtenerMejoresJugadores();
    }

    public static Pieza getPiezaGuardada(){
        return piezaGuardada;
    }

}

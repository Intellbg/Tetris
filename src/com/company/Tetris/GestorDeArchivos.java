package com.company.Tetris;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.util.ArrayList;

public class GestorDeArchivos {

    public static void guardarPartida() {
        try {
            File archivo = new File("Tetris_" + Tetris.getNombreJugador() + Tetris.getPuntaje() + ".txt");
            FileOutputStream flujoDeSalida = new FileOutputStream(archivo);
            ObjectOutputStream manejadorEscritura = new ObjectOutputStream(flujoDeSalida);
            manejadorEscritura.writeObject(Tetris.getJugador());
            manejadorEscritura.writeObject(Tetris.getCuadricula());
            manejadorEscritura.close();
        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    public static void recuperarPartida(String pathArchivo){
        try {
            File archivo = new File(pathArchivo);
            FileInputStream flujoDeEntrada= new FileInputStream(archivo);
            ObjectInputStream manejador= new ObjectInputStream(flujoDeEntrada);
            Jugador jugador=(Jugador) manejador.readObject();
            Cuadricula cuadricula=(Cuadricula) manejador.readObject();
            manejador.close();
            Tetris.iniciarSesion(jugador, cuadricula);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("No encontrado");
            Tetris.iniciarSesion("Invitado");
        }
    }
    
    public static ArrayList<Jugador> obtenerMejoresJugadores(){
        ArrayList<Jugador> mejoresJugadores=new ArrayList<>();
        File archivo = new File("mejoresJugadores.txt");
        if(!archivo.exists()){
            inicializarMejoresJugadores();
            archivo = new File("mejoresJugadores.txt");
        }
        try {
            FileInputStream flujoDeEntrada= new FileInputStream(archivo);
            ObjectInputStream manejador= new ObjectInputStream(flujoDeEntrada);
            for(int i=0;i<5;i++){
                mejoresJugadores.add((Jugador) manejador.readObject());
            }
            manejador.close();
        } catch (IOException | ClassNotFoundException e) {      
            e.printStackTrace();
        }
        return mejoresJugadores;
    }

    public static void guardarMejoresJugadores(ArrayList<Jugador> mejoresJugadores){
        try {
            File archivo = new File("mejoresJugadores.txt");
            FileOutputStream flujoDeSalida = new FileOutputStream(archivo);
            ObjectOutputStream manejadorEscritura = new ObjectOutputStream(flujoDeSalida);    
            for(Jugador jugador: mejoresJugadores){
                manejadorEscritura.writeObject(jugador);
            }
            manejadorEscritura.close();
        } catch (IOException e) {      
            e.printStackTrace();
        }
    }

    public static void inicializarMejoresJugadores(){
        try {
            File archivo = new File("mejoresJugadores.txt");
            FileOutputStream flujoDeSalida = new FileOutputStream(archivo);
            ObjectOutputStream manejadorEscritura = new ObjectOutputStream(flujoDeSalida);    
            for(int i=0;i<5;i++){
                manejadorEscritura.writeObject(new Jugador("Dummy"+i));
            }
            manejadorEscritura.close();
        } catch (IOException e) {      
            e.printStackTrace();
        }
    }
}

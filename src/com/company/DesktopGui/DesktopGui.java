package com.company.DesktopGui;

import java.util.ArrayList;

import javax.swing.*;
import java.awt.*;
import com.company.Tetris.*;

public class DesktopGui extends JFrame{
    static Container mainContainer;
    static CardLayout layout;
    DisplayTetris displayTetris;
    public DesktopGui() throws HeadlessException {
        super("Tetris");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        setSize(1200,900);
        mainContainer=getContentPane();
        layout=new CardLayout();
        mainContainer.setLayout(layout);
        //mainContainer.add(new DisplayMenuPrincipal());
        displayTetris=new DisplayTetris();
        mainContainer.add(displayTetris);
        //mainContainer.add(new DisplayHighscores(),"HighscoresDisplay");
        setVisible(true);
        pack();
    }

    public static void cambiarVista(String nombreVista) {  
        layout.show(mainContainer, nombreVista);  
    }  

    public static void regresarMenu() {  
        layout.first(mainContainer);  
    }

    public void actualizarPanelProximasPiezas(ArrayList<Pieza> proximasPiezas) {
        displayTetris.actualizarProximasPiezas(proximasPiezas);
    }

    public void actualizarGridDeJuego(Cuadricula cuadricula) {
        displayTetris.actualizarGridDeJuego(cuadricula);
    }

}

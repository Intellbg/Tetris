package com.company.DesktopGui;

import com.company.Tetris.*;
import java.awt.*;
import javax.swing.*;
import java.util.ArrayList;


public class PanelTetrisAuxiliar extends JLabel{
    private static PanelPiezaGuardada piezaGuardada;
    private static PanelSiguientesPiezas siguientesPiezas;
    private static PanelJugadorInfo jugadorInfo;
    private JButton pausar;
    private JButton reanudar;
    private JButton guardar;

    public PanelTetrisAuxiliar(){
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

        setPreferredSize(new Dimension(300, 900));
        
        add(Box.createRigidArea(new Dimension(10, 15)));
        
        jugadorInfo=new PanelJugadorInfo();
        jugadorInfo.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(jugadorInfo);
        
        JLabel label1=new JLabel("Pieza Guardada");
        label1.setAlignmentX(Component.CENTER_ALIGNMENT);
        label1.setFont(new Font("Arial", Font.PLAIN, 15));
        add(label1);
        
        add(Box.createRigidArea(new Dimension(10, 15)));

        piezaGuardada = new PanelPiezaGuardada();
        piezaGuardada.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(piezaGuardada);
        
        add(Box.createRigidArea(new Dimension(10, 15)));
        
        JLabel label2=new JLabel("Piezas Proximas");
        label2.setAlignmentX(Component.CENTER_ALIGNMENT);
        label2.setFont(new Font("Arial", Font.PLAIN, 15));
        add(label2);

        siguientesPiezas = new PanelSiguientesPiezas();
        siguientesPiezas.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(siguientesPiezas);
        
        pausar= new JButton("Pausar");
        pausar.setAlignmentX(Component.CENTER_ALIGNMENT);
        pausar.addActionListener(l->pausar());
        add(pausar);
        
        reanudar= new JButton("Reanudar");
        reanudar.setAlignmentX(Component.CENTER_ALIGNMENT);
        reanudar.addActionListener(l->resumir());
        reanudar.setVisible(false);
        add(reanudar);
        
        guardar= new JButton("Guardar");
        guardar.setAlignmentX(Component.CENTER_ALIGNMENT);
        guardar.addActionListener(x->guardar());
        guardar.setVisible(false);
        add(guardar);

        JButton salir= new JButton("Salir");
        salir.setAlignmentX(Component.CENTER_ALIGNMENT);
        salir.addActionListener(x->salir());
        add(salir);
    }

    public void actualizarProximasPiezas(ArrayList<Pieza> piezas){
        siguientesPiezas.actualizar(piezas);
    }

    public void actualizarInformacion(){
        jugadorInfo.actualizarInformacion();
    }

    public void actualizarPiezaGuardada(){
        piezaGuardada.actualizarPiezaGuardada();
    }

    public void pausar(){
        Tetris.pausarJuego();
        pausar.setVisible(false);
        reanudar.setVisible(true);
        guardar.setVisible(true);
    }
    
    public void resumir(){
        Tetris.reanudarJuego();
        pausar.setVisible(true);
        reanudar.setVisible(false);
        guardar.setVisible(false);
    }

    public void salir(){
        SwingUtilities.getWindowAncestor(this).dispose();
    }

    public void guardar(){
        Tetris.guardarJuego();
        salir();
        JOptionPane.showMessageDialog(null,"Guardado con exito");
    }
}

package com.company.DesktopGui;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileSystemView;

import com.company.Tetris.Tetris;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class DisplayMenuPrincipal extends JPanel {
    BoxLayout layout;
    BufferedImage logo;
    JButton botonJugar, botonHighscore;
    JLabel titulo;

    public DisplayMenuPrincipal() {
        setPreferredSize(new Dimension(1200, 900));

        layout = new BoxLayout(this, BoxLayout.PAGE_AXIS);
        setLayout(layout);

        try {
            logo = ImageIO.read(new File("src/Img/logo.png"));
            titulo = new JLabel(new ImageIcon(logo));
            titulo.setAlignmentX(Component.CENTER_ALIGNMENT);
            add(titulo);
        } catch (IOException e) {
            e.printStackTrace();
        }

        botonJugar = new JButton("Jugar");
        botonJugar.setAlignmentX(Component.CENTER_ALIGNMENT);
        botonJugar.setMaximumSize(new Dimension(700, 125));
        botonJugar.setFont(new Font("Arial", Font.PLAIN, 50));
        botonJugar.addActionListener(a->iniciarJuego());
        add(botonJugar);

        add(Box.createRigidArea(new Dimension(10, 60)));

        JButton botonCargar = new JButton("Cargar Partida");
        botonCargar.setAlignmentX(Component.CENTER_ALIGNMENT);
        botonCargar.setMaximumSize(new Dimension(700, 125));
        botonCargar.setFont(new Font("Arial", Font.PLAIN, 50));
        botonCargar.addActionListener(a->cargarJuego());
        add(botonCargar);

        add(Box.createRigidArea(new Dimension(10, 60)));

        botonHighscore = new JButton("Highscores");
        botonHighscore.setAlignmentX(Component.CENTER_ALIGNMENT);
        botonHighscore.setMaximumSize(new Dimension(700, 125));
        botonHighscore.setFont(new Font("Arial", Font.PLAIN, 50));
        botonHighscore.addActionListener(a->mostrarHighscore());
        add(botonHighscore);
        
    }

    private void mostrarHighscore(){
        this.getParent().add(new DisplayHighscores());
        this.getParent().remove(this);
    }

    private void iniciarJuego(){
        String nombre = JOptionPane.showInputDialog("Ingrese su nombre");
        Tetris.iniciarSesion(nombre);
        DisplayTetris tetrisDisplay=new DisplayTetris();
        new PartidaTetris(tetrisDisplay).start();
    }

    private void cargarJuego(){
        Tetris.cargarJuego(obtenerNombreArchivo());
        DisplayTetris tetrisDisplay=new DisplayTetris();
        new PartidaTetris(tetrisDisplay).start();
    }

    private String obtenerNombreArchivo(){
        JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
		int returnValue = jfc.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
			File selectedFile = jfc.getSelectedFile();
			return selectedFile.getAbsolutePath();
		}
        return "nada";
    }
    
}

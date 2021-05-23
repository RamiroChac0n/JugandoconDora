/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.jugandocondora;

import javax.swing.*;

/**
 *Esta clase es creada para tener una base en todas las ventanas que se ocuparan
 *en el proyecto.
 * @author ramir
 */
public class VentanaGeneral extends JFrame{
    /**
     * Se da una forma especifica a la ventana, tamaño, locacion, redimensionable y visible.
     * @param panel Solicita un objeto de tipo panel.
     */
    public VentanaGeneral(JPanel panel){
        this.setSize(1500,1000);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setResizable(false);
        this.setTitle("Jugando con Dora");
        agregarPanel(panel);
        this.setVisible(true);
    } 
    
    /**
     * Crea una ventana de un tamaño general.
     */
    public VentanaGeneral(){
        this.setSize(1500,1000);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setResizable(false);
        this.setTitle("Jugando con Dora");
        this.setVisible(true);
    }
    
    /**
     * Crea una ventana con un tamaño personalizado.
     * @param longitudHorizontal Longitud horizontal de la ventana.
     * @param longitudVertical Longitud vertical de la ventana.
     */
    public VentanaGeneral(int longitudHorizontal, int longitudVertical){
        this.setSize(longitudHorizontal, longitudVertical);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setResizable(false);
        this.setTitle("Jugando con Dora");
        this.setVisible(true);
    }

    /**
     * Crea una ventana con un tamaño personalizado y agregando un panel.
     * @param longitudHorizontal Longitud horizontal de la ventana.
     * @param longitudVertical  Longitud vertical de la ventana.
     * @param panel Solicita un objeto de tipo panel.
     */
    public VentanaGeneral(int longitudHorizontal, int longitudVertical, JPanel panel){  
        this.setSize(longitudHorizontal, longitudVertical);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setResizable(false);
        this.setTitle("Jugando con Dora");
        agregarPanel(panel);
        this.setVisible(true);
    }
    
    /**
     * Agrega el panel a la ventana.
     * @param panel Solicita el panel que se desea colocar en la ventana.
     */
    private void agregarPanel(JPanel panel){
        this.add(panel);
    }
    /**
     * Cierra la ventana creada.
     */
    public void cerrarVentana(){
        this.dispose();
    }
}

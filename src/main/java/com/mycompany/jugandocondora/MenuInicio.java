/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.jugandocondora;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * Esta clase es la encargada de crear el menu de inicio del juego, tiene botones 
 * de Jugar, salir y acerca de.
 * @author ramir
 */
public class MenuInicio implements ActionListener{
    private JButton botonJugar;
    private JButton botonSalir;
    private JButton botonAcercaDe;
    private final VentanaGeneral menuVentana;
    private String jugador;
    
    /**
     * Crea una ventana y botones.
     */
    public MenuInicio(){
        menuVentana = new VentanaGeneral(1500, 1000, crearPanel() );
        makeBoton();
        jugador = "";
    }
    
    /**
     * Crea un panel.
     * @return Retorna un objeto de tipo panel.
     */
    private JPanel crearPanel(){
        PanelMenuInicio panel = new PanelMenuInicio();
        return panel;
    }
    /**
     * Crea los botones Jugar, Salir y Acerca de.
     */
    private void makeBoton(){
        botonJugar = new JButton("Jugar");
        botonJugar.setSize(150, 50);
        botonJugar.setLocation(675, 475);                                       //x = (1500/2)-(tamaño/2) y = (1000/2)-(tamaño/2)
        botonJugar.addActionListener(this);
        menuVentana.add(botonJugar);
        
        botonSalir = new JButton("Salir");
        botonSalir.setSize(100, 50);
        botonSalir.setLocation(700, 550);                                       //x=(750)-(50) , y
        botonSalir.addActionListener(this);
        menuVentana.add(botonSalir);
        
        botonAcercaDe = new JButton("Acerca de");
        botonAcercaDe.setSize(150, 50);
        botonAcercaDe.setLocation(1325, 700);                                   //botonAcercaDe.setLocation(1325, 900); Para PcEscritorio
        botonAcercaDe.addActionListener(this);
        menuVentana.add(botonAcercaDe);
    }
    
    /**
     * Maneja las acciones que tendran los botones.
     * @param event Variable de tipo ActionEvent
     */
    @Override
    public void actionPerformed(ActionEvent event) { 
        switch (event.getActionCommand()) {
            case "Acerca de":
                mostrarAcercaDe();
                break;
            case "Salir":
                menuVentana.cerrarVentana();
                break;
            case "Jugar": 
                menuVentana.cerrarVentana();
                pedirNombre();
                iniciaJuego();
                break;
            default:
                break;
        }
    }
    
    /**
     * Crea una ventana en la cual se tiene que introducir un nick pero porfavor no de cancel si el campos esta vacio.
     */
    public void pedirNombre(){
        while(jugador.trim().isEmpty()){
            jugador = JOptionPane.showInputDialog(null, "Ingrese nick, porfavor no lo deje vacio.", "Ingreso", JOptionPane.OK_CANCEL_OPTION);
        }
    }
    
    /**
     * Muestra la información necesaria sobre el juego.
     */
    public void mostrarAcercaDe(){
        JOptionPane.showMessageDialog(null, "Este juego está diseñado para aprender a leer de forma interactica.\n"
                + "Creador: Ramiro Chacón\n"
                + "Versión: 1.0.0"
                , "Acerca de", 1);
    }
    public void iniciaJuego(){
        Juego1 juego1 = new Juego1(getJugador());
    }
    
    /**
     * Nick del jugador.
     * @return Retorna el nick del jugador.
     */
    public String getJugador() {
        return jugador;
    }
    
    /**
     * Cambia el nick del jugador.
     * @param jugador Nuevo nick del jugador.
     */
    public void setJugador(String jugador) {
        this.jugador = jugador;
    }     
}

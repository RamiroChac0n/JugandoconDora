/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.jugandocondora;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

/**
 * Esta clase es la encargada de crear la ventana de puntuaciones, guardar y
 * leer y los nicks con sus respectivos punteos.
 * @author ramir
 */
public class Punteos implements ActionListener{
    private final String nombreJugador;
    private final int puntaje;
    private final VentanaGeneral punteo;
    private JTextArea areaNombre;
    private JTextArea areaPuntos;
    private JLabel labelNombre;
    private JLabel labelPuntos;
    private JButton salir;
    private JButton volverAJugar;
    
    /**
     * Inicializa los componentes.
     * @param nombreJugador Nick que el jugador colocó al inicio del juego.
     * @param puntaje Punteo final que le jugador a obtenido al pasar el juego.
     */
    public Punteos(String nombreJugador, int puntaje) {
        this.nombreJugador = nombreJugador;
        this.puntaje = puntaje;
        guardarNick(nombreJugador);
        guardarPunteo(puntaje);
        
        punteo = new VentanaGeneral(400, 600);
        
        crearLabel();
        crearAreas();
        crearBotones();
        leerNick();
        leerPunteo();
    }
    
    /**
     * Crea las areas de texto para ver los nicks y punteos de los jugadores.
     */
    private void crearAreas(){
        areaNombre = new JTextArea();
        areaNombre.setSize(100, 500);
        areaNombre.setLocation(10, 50);
        punteo.add(areaNombre);
        
        areaPuntos = new JTextArea();
        areaPuntos.setSize(100, 500);
        areaPuntos.setLocation(120, 50);
        punteo.add(areaPuntos);
    }
    
    /**
     * Crea las etiquetas que indican las columnas de nombres y puntos.
     */
    private void crearLabel(){
        labelNombre = new JLabel("Nombres: ");
        labelNombre.setSize(100, 30);
        labelNombre.setLocation(10, 20);
        punteo.add(labelNombre);
        
        labelPuntos = new JLabel("Puntos sobre 15: ");
        labelPuntos.setSize(100, 30);
        labelPuntos.setLocation(120, 20);
        punteo.add(labelPuntos);
    }
    
    /**
     * Crea los botones de la pantalla de punteos.
     */
    private void crearBotones(){
        volverAJugar = new JButton("Volver a jugar");
        volverAJugar.setSize(120, 50);
        volverAJugar.setLocation(244, 230);
        volverAJugar.addActionListener(this);
        punteo.add(volverAJugar);
        
        salir = new JButton("Salir");
        salir.setSize(100, 50);
        salir.setLocation(255, 300);
        salir.addActionListener(this);
        punteo.add(salir);
    }
    
    /**
     * Este método guarda el nick del jugador.
     * @param nick Solicita la entrada el nick que el jugador ingresó.
     */
    private void guardarNick(String nick){
        try {
            FileWriter escritor = new FileWriter("C:\\Users\\ramir\\OneDrive\\Documentos\\NetBeansProjects\\JugandoConDora\\src\\main\\resources\\files\\Nicks.txt", true);
            
            escritor.write(nick + "\r\n");
            
            escritor.close();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Ocurrío un error con el archivo.", "Alerta", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    /**
     * Lee el archivo de nombres y los coloca en el área de texto correspondiente.
     */
    private void leerNick(){       
        String nick = "";
        int letra;                                                                 //Letra es entero, porque para la maquina, lo que contiene el archivo está en código ASCII.
        
        try {
            FileReader lector = new FileReader("C:\\Users\\ramir\\OneDrive\\Documentos\\NetBeansProjects\\JugandoConDora\\src\\main\\resources\\files\\Nicks.txt");          
            letra = lector.read();  //read() devuelve un entero.
            
            while (letra != -1) {                
                nick += (char) letra;             
                letra = lector.read();
            }           
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "No se encontró el archivo", "Alerta", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Ocurrío un error con el archivo.", "Alerta", JOptionPane.ERROR_MESSAGE);
        }
        
        areaNombre.append(nick);
        
    }
    
    /**
     * Este método guardar el punteo del jugador.
     * @param puntos Pide el punteo acumulado que lleva el jugador.
     */
    private void guardarPunteo(int puntos){
        try {
            FileWriter escritor = new FileWriter("C:\\Users\\ramir\\OneDrive\\Documentos\\NetBeansProjects\\JugandoConDora\\src\\main\\resources\\files\\Puntos.txt", true);
            escritor.write(puntos + "\r\n");
            escritor.close();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Ocurrío un error con el archivo.", "Alerta", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    /**
     * Lee el archivo de punteos y los coloca en el area de texto correspondiente.
     */
    private void leerPunteo(){
        String puntos = "";
        int numero;
        try {
            FileReader lector = new FileReader("C:\\Users\\ramir\\OneDrive\\Documentos\\NetBeansProjects\\JugandoConDora\\src\\main\\resources\\files\\Puntos.txt");
            numero = lector.read();
            
            while (numero != -1) {                
                puntos += (char)numero;
                numero = lector.read();
            }
            
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "No se encontró el archivo", "Alerta", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Ocurrío un error con el archivo.", "Alerta", JOptionPane.ERROR_MESSAGE);
        }
        areaPuntos.append(puntos);
    }
    
    private void reinciar(){
        MenuInicio juego = new MenuInicio();
    }
    
    /**
     * Método encargado de manejar las funcionalidades de los botones de la pantalla de punteos.
     * @param event Evento que se escuchó.
     */
    @Override
    public void actionPerformed(ActionEvent event) {
        switch(event.getActionCommand()){
            case "Volver a jugar":
                punteo.cerrarVentana();
                reinciar();
                break;
            case "Salir":
                punteo.cerrarVentana();
                break;
        }
    }
}

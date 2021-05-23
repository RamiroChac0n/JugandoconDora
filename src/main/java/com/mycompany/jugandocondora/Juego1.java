/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.jugandocondora;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Esta clase crea la primera pantalla del Juego.
 * @author ramir
 */
public class Juego1 implements ActionListener{
    private final Font fuente;
    private final VentanaGeneral juego1;
    private JTextField campo1;
    private JTextField campo2;
    private JTextField campo3;
    private JTextField campo4;
    private JTextField campo5;
    private JLabel instrucciones;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JLabel label5;
    private JButton siguiente;
    private String silaba1;
    private String silaba2;
    private String silaba3;
    private String silaba4;
    private String silaba5;
    private final String nombreJugador;
    private final String[] silabasOrdenadas = {"LA", "LE", "LI", "LO", "LU"};
    private int puntaje;
    
    /**
     * Inicializa los componetes de la primera pantalla del juego.
     * @param nombreJugador Nick que el jugador ingresó.
     */
    public Juego1(String nombreJugador) {
        this.nombreJugador = nombreJugador;  
        fuente = new Font("fuente", 1, 30);
        juego1 = new VentanaGeneral(1500, 1000, crearPanel());
        crearLabel();
        crearCamposTexto();
        crearBoton();
    }
    /**
     * Crea el panel de la primera Pantalla.
     * @return Retorna el panel.
     */
    private JPanel crearPanel(){
        PanelJuego1 panel = new PanelJuego1();
        return panel;
    }
    
    /**
     * Crea los campos de texto, para que el jugador ponga en orden las sílabas.
     */
    private void crearCamposTexto(){
        campo1 = new JTextField();
        campo1.setSize(100,50);
        campo1.setLocation(200,105);
        campo1.setFont(fuente);
        juego1.add(campo1);
        
        campo2 = new JTextField();
        campo2.setSize(100, 50);
        campo2.setLocation(200, 200);
        campo2.setFont(fuente);
        juego1.add(campo2);
        
        campo3 = new JTextField();
        campo3.setSize(100, 50);
        campo3.setLocation(200, 295);
        campo3.setFont(fuente);
        juego1.add(campo3);
        
        campo4 = new JTextField();
        campo4.setSize(100, 50);
        campo4.setLocation(200, 390);
        campo4.setFont(fuente);
        juego1.add(campo4);
        
        campo5 = new JTextField();
        campo5.setSize(100, 50);
        campo5.setLocation(200, 485);
        campo5.setFont(fuente);
        juego1.add(campo5);
    }
    
    /**
     * Crea las etiquetas para el orden de las sílabas. 
     */
    private void crearLabel(){
        instrucciones = new JLabel("Ordene las sílabas");
        instrucciones.setSize(300, 50);
        instrucciones.setLocation(250, 25);
        instrucciones.setFont(fuente);
        juego1.add(instrucciones);
        
        label1 = new JLabel("1º");
        label1.setSize(50, 50);
        label1.setLocation(150, 105);
        label1.setFont(fuente);
        juego1.add(label1);
        
        label2 = new JLabel("2º");
        label2.setSize(50, 50);
        label2.setLocation(150, 200);
        label2.setFont(fuente);
        juego1.add(label2);
        
        label3 = new JLabel("3º");
        label3.setSize(50, 50);
        label3.setLocation(150, 295);
        label3.setFont(fuente);
        juego1.add(label3);
        
        label4 = new JLabel("4º");
        label4.setSize(50, 50);
        label4.setLocation(150, 390);
        label4.setFont(fuente);
        juego1.add(label4);
        
        label5 = new JLabel("5º");
        label5.setSize(50, 50);
        label5.setLocation(150, 485);
        label5.setFont(fuente);
        juego1.add(label5);
    }
    
    /**
     * Crea el boton de siguiente.
     */
    private void crearBoton(){
        siguiente = new JButton("Siguiente");
        siguiente.setSize(100, 50);
        siguiente.setLocation(175, 605);
        siguiente.addActionListener(this);
        juego1.add(siguiente);
    }
    
    /**
     * Maneja la función del botón.
     * @param event Variable de tipo ActionEvent.
     */
    @Override
    public void actionPerformed(ActionEvent event) {
        silaba1 = campo1.getText().toUpperCase();
        silaba2 = campo2.getText().toUpperCase();
        silaba3 = campo3.getText().toUpperCase();
        silaba4 = campo4.getText().toUpperCase();
        silaba5 = campo5.getText().toUpperCase();
        
        contarPuntos(silaba1, silaba2, silaba3, silaba4, silaba5);
        
        juego1.cerrarVentana();
        segundaPantalla();
    }
    
    /**
     * Compara las silabas mediante dos array, y hace las operaciones necesarias para sacar el punteo.
     * @param pos1 Primera silaba que el jugador coloca.
     * @param pos2 Segunda silaba que el jugador coloca.
     * @param pos3 Tercera silaba que el jugador coloca.
     * @param pos4 Cuarta silaba que el jugador coloca.
     * @param pos5 Quinta silaba que el jugador coloca.
     */
    private void contarPuntos(String pos1, String pos2, String pos3, String pos4, String pos5){
        String[] silabasJugador = {pos1, pos2, pos3, pos4, pos5};
        for (int i = 0; i < 5; i++) {
            if (silabasJugador[i].equals(silabasOrdenadas[i])) {
                puntaje++;
                setPuntaje(puntaje);
            }
        }
    }
    
    /**
     * Crea la segunda pantalla del juego.
     */
    private void segundaPantalla(){
        Juego2 juego2 = new Juego2(nombreJugador, getPuntaje());
    }
    
    /**
     * Puntaje del jugador.
     * @return Retorna el puntaje del jugador.
     */
    public int getPuntaje() {
        return puntaje;
    }
    
    /**
     * Cambia el punteo del jugador.
     * @param puntaje Nuevo punteo.
     */
    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }
    
}

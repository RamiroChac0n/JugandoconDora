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
 * Crea la tercera pantalla del juego.
 * @author ramir
 */
public class Juego3 implements ActionListener{
    private final String nombreJugador;
    private int puntaje;
    private final VentanaGeneral juego3;
    private final Font fuente;
    private JTextField campo1;
    private JTextField campo2;
    private JTextField campo3;
    private JTextField campo4;
    private JTextField campo5;
    private JButton siguiente;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JLabel label5;
    private String silaba1;
    private String silaba2;
    private String silaba3;
    private String silaba4;
    private String silaba5;
    private final String[] silabasOrdenadas = {"MA", "ME", "MI", "MO", "MU"};
    
    /**
     * Inicia los componentes de la tercera pantalla del juego
     * @param nombreJugador Solicita el nick que ingreso el jugador.
     * @param puntaje Solicita el puntaje que va obteniendo el jugador.
     */
    public Juego3(String nombreJugador, int puntaje) {
        this.nombreJugador = nombreJugador;
        this.puntaje = puntaje;
        juego3 = new VentanaGeneral(1500, 1000, crearPanel() );
        fuente = new Font("fuente", 1, 30);
        
        crearLabel();
        crearCamposTexto();
        crearBoton();
    }
    
    /**
     * Crea el panel de la tercera pantalla.
     * @return Retorna el panel.
     */
    private JPanel crearPanel(){
        PanelJuego3 panel = new PanelJuego3();
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
        juego3.add(campo1);
        
        campo2 = new JTextField();
        campo2.setSize(100, 50);
        campo2.setLocation(200, 200);
        campo2.setFont(fuente);
        juego3.add(campo2);
        
        campo3 = new JTextField();
        campo3.setSize(100, 50);
        campo3.setLocation(200, 295);
        campo3.setFont(fuente);
        juego3.add(campo3);
        
        campo4 = new JTextField();
        campo4.setSize(100, 50);
        campo4.setLocation(200, 390);
        campo4.setFont(fuente);
        juego3.add(campo4);
        
        campo5 = new JTextField();
        campo5.setSize(100, 50);
        campo5.setLocation(200, 485);
        campo5.setFont(fuente);
        juego3.add(campo5);
    }
    
    /**
     * Crea las etiquetas que indican el orden.
     */
    private void crearLabel(){
        label1 = new JLabel("1º");
        label1.setSize(50, 50);
        label1.setLocation(150, 105);
        label1.setFont(fuente);
        juego3.add(label1);
        
        label2 = new JLabel("2º");
        label2.setSize(50, 50);
        label2.setLocation(150, 200);
        label2.setFont(fuente);
        juego3.add(label2);
        
        label3 = new JLabel("3º");
        label3.setSize(50, 50);
        label3.setLocation(150, 295);
        label3.setFont(fuente);
        juego3.add(label3);
        
        label4 = new JLabel("4º");
        label4.setSize(50, 50);
        label4.setLocation(150, 390);
        label4.setFont(fuente);
        juego3.add(label4);
        
        label5 = new JLabel("5º");
        label5.setSize(50, 50);
        label5.setLocation(150, 485);
        label5.setFont(fuente);
        juego3.add(label5);
    }
    
    /**
     * Crea el boton para pasar a la siguiente pantalla.
     */
    private void crearBoton(){
        siguiente = new JButton("Siguiente");
        siguiente.setSize(100, 50);
        siguiente.setLocation(175, 605);
        siguiente.addActionListener(this);
        juego3.add(siguiente);
    }
    
    /**
     * Maneja las funcionalidades del boton.
     * @param arg0 Variable encargada del escuchar los eventos.
     */
    @Override
    public void actionPerformed(ActionEvent arg0) {
        silaba1 = campo1.getText().toUpperCase();
        silaba2 = campo2.getText().toUpperCase();
        silaba3 = campo3.getText().toUpperCase();
        silaba4 = campo4.getText().toUpperCase();
        silaba5 = campo5.getText().toUpperCase();
        
        contarPuntos(silaba1, silaba2, silaba3, silaba4, silaba5);
        juego3.cerrarVentana();
        crearPunteos();
    }
    
    /**
     * Crea la ventana para ver los punteos de los jugadores.
     */
    private void crearPunteos(){
        Punteos punteos = new Punteos(nombreJugador, getPuntaje());
    }
    
    /**
     * Compara las silabas mediante dos array, y hace las operaciones necesarias para sacar el punteo.
     * @param pos1 Primera silaba que el jugador colaca.
     * @param pos2 Segunda silaba que el jugador colaca.
     * @param pos3 Tercera silaba que el jugador colaca.
     * @param pos4 Cuarta silaba que el jugador colaca.
     * @param pos5 Quinta silaba que el jugador colaca.
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
     * Puntaje del jugador.
     * @return Retorna el puntaje del jugador.
     */
    public int getPuntaje() {
        return puntaje;
    }
    
    /**
     * Cambia el puntaje del jugador.
     * @param puntaje Nuevo punteo.
     */
    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }
    
    
}

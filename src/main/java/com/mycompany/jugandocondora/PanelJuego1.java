/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.jugandocondora;

import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 * Clase encargada de colocar la imagen de la primera pantalla del juego.
 * @author ramir
 */
public class PanelJuego1 extends JPanel{
    private final ImageIcon img;
    private final ImageIcon imgFondo;
    
    /**
     * Inicializa el panel, como el ancho, la alura y la ruta de la imagen.
     */
    public PanelJuego1() {
        setSize(750, 1000);
        setLocation(750 , 0);
        
        imgFondo = new ImageIcon(getClass().getResource("/img/Fondo.jpg"));
        img = new ImageIcon(getClass().getResource("/img/DoraLa.png"));
    }
    
    /**
     * Pinta la imagen.
     * @param g Variable de tipo Graphics.
     */
    @Override
    public void paint(Graphics g) {
        super.paintComponent(g);
        
        g.drawImage(imgFondo.getImage(), 0, 0, 750, 1000, this);
        
        g.drawImage(img.getImage(), 0, 0, 750, 1000, this);
        setOpaque(false);
    }
    
    
}

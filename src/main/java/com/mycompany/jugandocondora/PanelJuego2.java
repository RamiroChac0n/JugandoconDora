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
 * Coloca la imagen de la segunda pantalla del juego.
 * @author ramir
 */
public class PanelJuego2 extends JPanel{
    private final ImageIcon img;
    
    /**
     * Inicializa el panel, como el ancho, la alura y la ruta de la imagen.
     */
    public PanelJuego2() {
        setSize(1500, 500);
        setLocation(0, 0);
        
        img = new ImageIcon(getClass().getResource("/img/DoraFa.png"));
    }
    
    /**
     * Pinta la imagen.
     * @param g Variable de tipo Graphics.
     */
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        
        g.drawImage(img.getImage(), 0, 0, 1500, 500, this);
        setOpaque(false);
    }
}

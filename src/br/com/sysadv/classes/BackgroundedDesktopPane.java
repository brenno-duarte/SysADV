/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sysadv.classes;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Insets;
import java.awt.image.BufferedImage;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.JDesktopPane;
import javax.swing.border.Border;

/**
 *
 * @author brenno
 */
public class BackgroundedDesktopPane implements Border {

    public BufferedImage back;

    public BackgroundedDesktopPane() {
        try {
            URL imagePath = new URL(getClass().getResource("backgroundLogo.png").toString());
            back = ImageIO.read(imagePath);
        } catch (Exception e) {
        }
    }
    
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height){
        g.drawImage(back, (x + (width - back.getWidth())/2), (y + (height - back.getHeight())/2), null);
    }
    
    public Insets getBorderInsets(Component c){
        return new Insets(0,0,0,0);
    }

    public boolean isBorderOpaque(){
        return false;
    }
}

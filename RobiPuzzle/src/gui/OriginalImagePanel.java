package gui;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * TODO DESCRIPTION
 * 
 * @author Adrian.Haidu
 */
public class OriginalImagePanel extends JPanel {


    private BufferedImage image;

    public OriginalImagePanel() {
      ClassLoader classLoader = null;
       try {              
         classLoader = Thread.currentThread().getContextClassLoader();
         InputStream input = classLoader.getResourceAsStream("ak47.jpg");
          //this.image = ImageIO.read(input);
         this.image = ImageIO.read(input);
       } catch (IOException ex) {
            System.out.println(ex.getStackTrace().toString());
       }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, null);            
    }

}


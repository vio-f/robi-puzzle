/*
 * Copyright (C) TBA BV
 * All rights reserved.
 * www.tba.nl
 */
package test;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.imageio.ImageTypeSpecifier;
import javax.swing.JFrame;

/**
 * TODO DESCRIPTION
 * 
 * @author viorel.florian
 */
public class GraphicsTest extends JFrame{
  /** classLoader */
  private ClassLoader classLoader = null;
  
  private BufferedImage image;
  /**
   * Constructs a new instance.
   * @throws IOException 
   */
  public GraphicsTest() throws IOException {
    super();
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    this.setSize(800, 600);
    this.classLoader = Thread.currentThread().getContextClassLoader();
    InputStream input = this.classLoader.getResourceAsStream("resources/ic_board.jpg");
    this.image = ImageIO.read(input);
    this.image = scaleImage(this.image, this.image.getType());
    this.setVisible(true);
  }
  
  /**
   * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
   */
  @Override
  public void paint(Graphics g) {
    super.paint(g);
    g.drawImage(scaleImage(this.image, this.image.getType()), 0, 0, null);
  }


  /*
  @Override
  public void paint(Graphics g) {
    super.paint(g);
    BufferedImage nextSize = new BufferedImage(this.getWidth()/2, this.getHeight()/2, this.image.getType());
    Graphics2D nextG = nextSize.createGraphics();
    nextG.drawImage(this.image, 0, 0, this.getWidth()/2, this.getHeight()/2, null);
    nextG.dispose();
  }*/
  
  
  /**
   * TODO DESCRIPTION
   * @param originalImage
   * @param type
   * @return
   */
  private BufferedImage scaleImage(BufferedImage originalImage, int type){
    BufferedImage resizedImage = new BufferedImage(this.getWidth()/2, this.getHeight()/2, type);
    Graphics2D g = resizedImage.createGraphics();
    g.drawImage(originalImage, 0, 0, this.getWidth()/2, this.getHeight()/2, null);
    g.dispose();
 
    return resizedImage;
    }
  
  /**
   * Entry point
   * @param args
   */
  public static void main(String[] args) {
    try {
      new GraphicsTest();
    } catch (IOException e) {
      // TODO Add your own exception handling here, consider logging
      e.printStackTrace();
    }
  }

}

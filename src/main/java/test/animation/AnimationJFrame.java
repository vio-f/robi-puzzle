/*
 * Copyright Viorel Florian
 * All rights reserved.
 * viorel.florian@gmail.com
 */
package test.animation;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import util.ImageUtil;

/**
 * TODO DESCRIPTION
 * 
 * @author viorel.florian
 */
public class AnimationJFrame extends JFrame {

  /** serialVersionUID */
  private static final long serialVersionUID = 3552998459913919939L;

  /** defaultDim */
  private Dimension defaultDimenision = new Dimension(240, 200);

  /** imagePath */
  private String imagePath = "d:/_Work/_JavaWorkspace/samples/mario2.png";

  /** image */
  private BufferedImage image;

  /** canavasPanel */
  private CanavasPanel canavasPanel;

  /** animationFrames */
  private BufferedImage[] animationFrames;

  /**
   * Constructs a new instance.
   */
  public AnimationJFrame() {
    super();
    this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    // this.setSize(this.defaultDimenision);
    // ImageUtil.loadAndDisplayImage(this);
    this.image = ImageUtil.loadImage(this.imagePath);
    this.setSize(this.image.getWidth(), this.image.getHeight());
    this.animationFrames = ImageUtil.splitImage(this.image, 6, 4);

    this.canavasPanel = new CanavasPanel(this.image, this.animationFrames);
    this.add(this.canavasPanel);
    
    
    //this.canavasPanel.draw(this, this.animationFrames);
    

  }
}

class CanavasPanel extends JPanel {

  /** serialVersionUID */
  private static final long serialVersionUID = -3039938479500474916L;

  /** img */
  private BufferedImage img;

  /** frames */
  private BufferedImage[] frames;

  /**
   * Constructs a new instance.
   * 
   * @param image
   */
  public CanavasPanel(BufferedImage image, BufferedImage[] animationFrames) {
    super();
    this.img = image;
    this.frames = animationFrames;
  }

  public void draw(JFrame frame, BufferedImage[] imgs){
    Graphics2D g2d = (Graphics2D) frame.getGraphics();
    //g2d.drawImage(bimg, 0, 0, null);
    
    for (int i = 0; i < imgs.length; i++) {
      
      try {
        Thread.sleep(1*1000);
      } catch (InterruptedException e) {
        // TODO Add your own exception handling here, consider logging
        e.printStackTrace();
      }
    }
    
  }

  /**
   * @see javax.swing.JComponent#paint(java.awt.Graphics)
   */
  @Override
  public void paint(Graphics g) {
    //super.paint(g);
    // g.drawImage(this.img, 0, 0, null);
    
   for (int i = 0; i < this.frames.length; i++) {
     g.drawImage(this.frames[i], 0, 0, null);
      try {
        Thread.sleep(1*1000);
      } catch (InterruptedException e) {
        // TODO Add your own exception handling here, consider logging
        e.printStackTrace();
      }
    }
  }
}// EOF

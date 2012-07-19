package gui;

import java.awt.Dimension;

import javax.swing.JFrame;

/**
 * TODO DESCRIPTION
 * 
 * @author Adrian.Haidu
 */
public class FirstFrame extends JFrame {
  /** initialDimension */
  private Dimension initialDimension = new Dimension(640, 480);
  
  /**
   * Constructs a new instance.
   */
  public FirstFrame() {
    super();
    this.setVisible(true);
    this.configureFrame();
    
    
    pack();
  }
  
  /**
   * Set initial properties of the frame
   */
  private void configureFrame() {
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    this.setPreferredSize(this.initialDimension);
    
  }

}

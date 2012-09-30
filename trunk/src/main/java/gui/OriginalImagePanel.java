package gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;

import util.ImageUtil;

/**
 * A JPanel that paints a given image
 * 
 * @author Adrian.Haidu & Viorel.Florian
 */
public class OriginalImagePanel extends JPanel {

  /** serialVersionUID */
  private static final long serialVersionUID = 6657943048017255942L;

  /** image */
  private BufferedImage image;
  
  /** imagePath - path to image resource*/
  //TODO - make this dynamic
  private String imagePath = "resources/ic_board.jpg";

  /**
   * Constructs a new instance.
   */
  public OriginalImagePanel() {
    this.image = ImageUtil.loadImageFromResources(this.imagePath);
    // add a border to JPanel
    Border blackline = BorderFactory.createLineBorder(Color.black);
    this.setBorder(blackline);
  }

  /**
   * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
   */
  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    // move this to be executed only once
    // this.image = this.resizeImageToSize(this.image, this.getWidth(), this.getHeight(),
    // this.getBackground());
    // g.drawImage(this.image, 0, 0, null);
    
    //if I use this the image is folded -> WHY???
    //this.image = this.scaleImage(this.image);
    g.drawLine(0, 0, this.getWidth(), this.getHeight());
    g.drawLine(this.getWidth(), 0, 0,this.getHeight());
    g.drawImage(ImageUtil.scaleImage(this.image, this), 10, 10, null);
  }

}//EOF

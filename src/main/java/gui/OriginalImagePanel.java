package gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 * A JPanel that paints a given image
 * 
 * @author Adrian.Haidu
 */
public class OriginalImagePanel extends JPanel {

  /** serialVersionUID */
  private static final long serialVersionUID = 6657943048017255942L;
  /** image */
  private BufferedImage image;

  /**
   * Constructs a new instance.
   */
  public OriginalImagePanel() {
    ClassLoader classLoader = null;
    try {
      classLoader = Thread.currentThread().getContextClassLoader();
      InputStream input = classLoader.getResourceAsStream("resources/ic_board.jpg");
      this.image = ImageIO.read(input);
    } catch (Exception ex) {
      System.out.println(ex.getStackTrace().toString());
    }
  }

  /**
   * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
   */
  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    //move this to be executed only once
    //this.image = this.resizeImageToSize(this.image, this.getWidth(), this.getHeight(), this.getBackground());
    //g.drawImage(this.image, 0, 0, null);
    g.drawImage(this.scaleImage(this.image), 0, 0, null);
  }

  /**
   * Resize image to the specified dimensions while keeping the scale
   * 
   * @param img
   * @param width
   * @param height
   * @param background
   * @return
   */
  private BufferedImage resizeImageToSize(BufferedImage img, int width, int height, Color background) {
    int imgWidth = img.getWidth();
    int imgHeight = img.getHeight();
    //figure out how this magic works
    if (imgWidth * height < imgHeight * width) {
      width = imgWidth * height / imgHeight;
    } else {
      height = imgHeight * width / imgWidth;
    }
    BufferedImage newImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
    Graphics2D g = newImage.createGraphics();
    try {
      g.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
          RenderingHints.VALUE_INTERPOLATION_BICUBIC);
      g.setBackground(background);
      g.clearRect(0, 0, width, height);
      g.drawImage(img, 0, 0, width, height, null);
    } finally {
      g.dispose();
    }
    return newImage;
  }
  
  /**
   * TODO DESCRIPTION
   * @param originalImage
   * @return
   */
  private BufferedImage scaleImage(BufferedImage originalImage){
    int nextWidth = this.getWidth();
    int nextHeight = this.getHeight();
    BufferedImage resizedImage = new BufferedImage(nextWidth, nextHeight, originalImage.getType());
    Graphics2D g = resizedImage.createGraphics();
    g.drawImage(originalImage, 0, 0, nextWidth, nextHeight, null);
    g.dispose();
 
    return resizedImage;
    }
  
  /**
   * TODO DESCRIPTION
   */
  private void iNeedABreak() {
    try {
      Thread.sleep(5*1000);
    } catch (InterruptedException e) {
      // TODO Add your own exception handling here, consider logging
      e.printStackTrace();
    }
  }

}

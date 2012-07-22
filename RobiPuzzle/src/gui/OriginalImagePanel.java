package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
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
      this.image = ImageIO.read(input);
      
    } catch (Exception ex) {
      System.out.println(ex.getStackTrace().toString());
    }
  }

  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    this.image = this.resizeImageToScale(this.image, this.getWidth(), this.getHeight(), this.getBackground());
    g.drawImage(image, 0, 0, null);
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
  public BufferedImage resizeImageToScale(BufferedImage img, int width, int height, Color background) {
    int imgWidth = img.getWidth();
    int imgHeight = img.getHeight();
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

}

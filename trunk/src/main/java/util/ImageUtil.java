/*
 * Copyright Viorel Florian
 * All rights reserved.
 * viorel.florian@gmail.com
 */
package util;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

/**
 * Static implementation of image manipulation utility methods
 * 
 * @author viorel.florian
 */
public class ImageUtil {
  
  
  /**
   * Load image
   * @param ref
   * @return BufferedImage
   */
  public static BufferedImage loadImage(String ref) {  
    BufferedImage bimg = null;  
    try {  
        bimg = ImageIO.read(new File(ref));  
    } catch (Exception e) {  
        e.printStackTrace();  
    }  
    return bimg;  
}  
  
  /**
   * Get an image from resources, via ImageStream
   * @param resourcePath 
   * @return 
   */
  public static BufferedImage loadImageFromResources(String resourcePath) {
    ClassLoader classLoader = null;
    BufferedImage image = null;
    try {
      classLoader = Thread.currentThread().getContextClassLoader();
      InputStream input = classLoader.getResourceAsStream(resourcePath);
      image = ImageIO.read(input);
    } catch (Exception ex) {
      System.out.println(ex.getStackTrace().toString());
    }
    return image;
  }
  
  /**
   * For testing purposes only
   * @param frame
   */
  public static void loadAndDisplayImage(JFrame frame) {
    //image path as string
    String imagePath = "d:/_Work/_JavaWorkspace/samples/mario2.png";
    // Load the img
    BufferedImage loadImg = ImageUtil.loadImage(imagePath);
    frame.setBounds(0, 0, loadImg.getWidth(), loadImg.getHeight());
    // Set the panel visible and add it to the frame
    frame.setVisible(true);
    // Get the surfaces Graphics object
    Graphics2D g = (Graphics2D) frame.getRootPane().getGraphics();
    // Now draw the image
    g.drawImage(loadImg, null, 0, 0);
    frame.repaint();
  }

  
  /**
   * Split image by number of colons and rows
   * @param img
   * @param cols
   * @param rows
   * @return
   */
  public static BufferedImage[] splitImage(BufferedImage img, int rows, int cols) {  
    int w = img.getWidth()/cols;  
    int h = img.getHeight()/rows;  
    int num = 0;  
    BufferedImage imgs[] = new BufferedImage[w*h];  
    for(int y = 0; y < rows; y++) {  
        for(int x = 0; x < cols; x++) {  
            imgs[num] = new BufferedImage(w, h, img.getType());  
            // Tell the graphics to draw only one block of the image  
            Graphics2D g = imgs[num].createGraphics();  
            g.drawImage(img, 0, 0, w, h, w*x, h*y, w*x+w, h*y+h, null);  
            g.dispose();  
            num++;  
        }  
    }  
    return imgs;  
}  
  
  /**
   * Resize image to the specified dimensions while keeping the scale
   * @param img
   * @param width
   * @param height
   * @param background
   * @return
   */
  public static BufferedImage resizeImageToSize(BufferedImage img, int width, int height, Color background) {
    //TODO make this more easily readable
    int imgWidth = img.getWidth();
    int imgHeight = img.getHeight();
    // figure out how this magic works
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
   * 
   * @param originalImage
   * @param component 
   * @return
   */
  public static BufferedImage scaleImage(BufferedImage originalImage, Component component) {
    int nextWidth = component.getWidth() - 20;
    int nextHeight = component.getHeight() - 20;
    BufferedImage resizedImage = new BufferedImage(nextWidth, nextHeight, originalImage.getType());
    Graphics2D g = resizedImage.createGraphics();
    g.drawImage(originalImage, 0, 0, nextWidth, nextHeight, null);
    g.dispose();
    return resizedImage;
  }
  
  /**
   * Converts a BufferedImage
   * @param bufferedImage
   * @return
   */
  public static Image bufferedImageToImage(BufferedImage bufferedImage) {
    return Toolkit.getDefaultToolkit().createImage(bufferedImage.getSource());
}

}//EOF

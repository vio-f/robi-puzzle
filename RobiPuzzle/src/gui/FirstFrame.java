package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.List;
import java.util.ArrayList;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * The first JFrame displayed when the application starts
 * 
 * @author Adrian.Haidu
 */
public class FirstFrame extends JFrame {
  /** initialDimension */
  private Dimension initialDimension = new Dimension(640, 480);
  /** buttonList */
  private ArrayList<JButton> buttonList = new ArrayList<JButton>();
  
  /**
   * Constructs a new instance.
   */
  public FirstFrame() {
    super();
    this.setVisible(true);
    this.configureFrame();
    this.addComponents();
    this.changeText();
    pack();
  }
  
  /**
   * Set initial properties of the frame
   */
  private void configureFrame() {
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    this.setPreferredSize(this.initialDimension);
    BorderLayout borderLayout = new BorderLayout();
    this.setLayout(borderLayout);
  }
  
  /**
   * Populate the frame with content
   */
  private void addComponents() {
    JPanel northPanel = new JPanel();
    JPanel southPanel = new JPanel();
    //add panels to appropriate location
    this.add(northPanel, BorderLayout.NORTH);
    this.add(southPanel, BorderLayout.SOUTH);
    
    for (int i = 0; i < 40; i++) {
      JButton but = new JButton(i + "");
      //set destination
      if (i%2==0){
      northPanel.add(but);
      }
      else {
        southPanel.add(but);
      }
      this.buttonList.add(but);
          }
  }
  
  /**
   * Change the text of all buttons
   */
  private void changeText() {
    try {
      Thread.sleep(5*1000);
    } catch (InterruptedException e) {
      // TODO Add your own exception handling here, consider logging
      e.printStackTrace();
    }
    for (int i = 0; i < this.buttonList.size(); i++) {
      JButton jb = this.buttonList.get(i);
      jb.setText("New text " + i);
      
    }
  }

}

package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;

/**
 * The first JFrame displayed when the application starts
 * 
 * @author Adrian.Haidu
 */
public class FirstFrame extends JFrame {
  /** serialVersionUID */
  private static final long serialVersionUID = 6910499871776922363L;

  /** initialDimension */
  private Dimension initialDimension = new Dimension(800, 600);

  /** mainGridLayout */
  private GridLayout mainGridLayout = new GridLayout(2, 2);

  /** imagePanel */
  private OriginalImagePanel imagePanel = null;

  /** puzzlePiecesPanel */
  private PuzzlePiecesPanel puzzlePiecesPanel = null;

  /** reconstructionPanel */
  private ReconstructionPanel reconstructionPanel = null;

  /** optionsPanel */
  private JPanel optionsPanel = new JPanel();

  /** panelDimensions */
  private Dimension panelDimensions = null;
  
  /** defaultBorder */
  Border defaultBorder = BorderFactory.createLineBorder(Color.BLACK, 2);

  /**
   * Constructs a new instance.
   */
  public FirstFrame() {
    super();
    this.setVisible(true);
    this.configureFrame();
    this.configComponents();
    pack();
  }

  /**
   * Set initial properties of the frame
   */
  private void configureFrame() {
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    this.setPreferredSize(this.initialDimension);
    this.setLayout(this.mainGridLayout);
  }

  /**
   * Configure components before they are added to the frame
   */
  private void configComponents() {
    this.panelDimensions = new Dimension(this.getWidth() / 2, this.getHeight() / 2);
    //this.panelDimensions = new Dimension(400, 300);
    this.imagePanel = new OriginalImagePanel();
    this.puzzlePiecesPanel = new PuzzlePiecesPanel(this.panelDimensions);
    this.reconstructionPanel = new ReconstructionPanel(this.panelDimensions);
    
    //TODO make this dynamic
    
    this.imagePanel.setBorder(this.defaultBorder);
    this.puzzlePiecesPanel.setBorder(this.defaultBorder);
    this.reconstructionPanel.setBorder(this.defaultBorder);
    this.optionsPanel.setBorder(this.defaultBorder);
    
    this.add(this.imagePanel);
    this.add(this.puzzlePiecesPanel);
    this.add(this.reconstructionPanel);
    this.add(this.optionsPanel);
  }

}//EOF
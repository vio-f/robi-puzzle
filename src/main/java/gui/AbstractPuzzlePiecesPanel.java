package gui;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.image.BufferedImage;
import java.util.LinkedList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import util.ImageUtil;

/**
 * TODO DESCRIPTION
 * 
 * @author viorel.florian
 */
public abstract class AbstractPuzzlePiecesPanel extends JPanel {

  /** serialVersionUID */
  private static final long serialVersionUID = 1071124093044620247L;

  // TODO make this dynamic
  /** defaultLayout */
  private GridLayout layout = null;

  /** puzzlePieces */
  private LinkedList<JLabel> puzzlePiecesContainerList = new LinkedList<JLabel>();
  
  /** rows */
  int rows;
  /** columns */
  int columns;

  /** puzzlePieces */
  private BufferedImage[] puzzlePieces;
  
  /**
   * Constructs a new instance.
   */
  public AbstractPuzzlePiecesPanel() {
    super();
   // this.setLayout(this.defaultLayout);
  }

  /**
   * Constructs a new instance.
   * 
   * @param layout
   */
  public AbstractPuzzlePiecesPanel(LayoutManager layout) {
    super(layout);
  }

  /**
   * Constructs a new instance.
   * 
   * @param isDoubleBuffered
   */
  public AbstractPuzzlePiecesPanel(boolean isDoubleBuffered) {
    super(isDoubleBuffered);
  }

  /**
   * Constructs a new instance.
   * 
   * @param layout
   * @param isDoubleBuffered
   */
  public AbstractPuzzlePiecesPanel(LayoutManager layout, boolean isDoubleBuffered) {
    super(layout, isDoubleBuffered);
  }

  /**
   * Constructs a new instance.
   * @param panelDimensions
   */
  public AbstractPuzzlePiecesPanel(Dimension panelDimensions) {
    this.setSize(panelDimensions);
  }

  /**
   * Add puzzle pieces to the panel
   * @param rows 
   * @param cols 
   */
  public void addPuzzleContainersAndPopulate(int rows, int cols) {
    this.rows = rows;
    this.columns = cols;
    this.puzzlePieces = this.getPuzzlePieces();
    this.layout = new GridLayout(rows, cols, 5, 5);
    this.setLayout(this.layout);
     for (int i = 0; i < rows*cols; i++) {
     JLabel label = new JLabel();
     
     Image image = this.puzzlePieces[i];
     ImageIcon imageIcon = new ImageIcon(image);
     label.setIcon(imageIcon);
     //label.getGraphics().drawImage(this.puzzlePieces[i], 0, 0, null);
     this.puzzlePiecesContainerList.add(label);
     this.add(label);
     }
  }
  
  

  /**
   * Create an array of puzzle pieces
   * @return
   */
  private BufferedImage[] getPuzzlePieces() {
    //String imagePath = "d:/_Work/_JavaWorkspace/samples/mario2.png";
    String imagePath = "resources/ic_board.jpg";
    return ImageUtil.splitImage(ImageUtil.loadImageFromResources(imagePath), this.rows, this.columns);
  }
  
  /**
   * Set puzzlePiecesContainer.
   * 
   * @param puzzlePiecesContainer
   */
  public void setPuzzlePiecesContainerList(LinkedList<JLabel> puzzlePiecesContainer) {
    this.puzzlePiecesContainerList = puzzlePiecesContainer;
  }

  /**
   * Get puzzlePiecesContainer.
   * 
   * @return puzzlePiecesContainer
   */
  public LinkedList<JLabel> getPuzzlePiecesContainerList() {
    return this.puzzlePiecesContainerList;
  }

}// EOF

package gui;

import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JPanel;

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
  private GridLayout defaultLayout = new GridLayout(5, 4);

  /** puzzlePieces */
  private LinkedList<JButton> puzzlePiecesContainerList = new LinkedList<JButton>();

  /**
   * Constructs a new instance.
   */
  public AbstractPuzzlePiecesPanel() {
    super();
    this.setLayout(this.defaultLayout);
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
   * Add puzzle pieces to the panel
   */
  protected void addPuzzleContainers() {
    // TODO make this configurable
    for (int i = 0; i < 20; i++) {
      JButton but = new JButton("Test");
      this.puzzlePiecesContainerList.add(but);
      this.add(but);

    }
  }

  /**
   * Set puzzlePiecesContainer.
   * 
   * @param puzzlePiecesContainer
   */
  public void setPuzzlePiecesContainerList(LinkedList<JButton> puzzlePiecesContainer) {
    this.puzzlePiecesContainerList = puzzlePiecesContainer;
  }

  /**
   * Get puzzlePiecesContainer.
   * 
   * @return puzzlePiecesContainer
   */
  public LinkedList<JButton> getPuzzlePiecesContainerList() {
    return puzzlePiecesContainerList;
  }

}// EOF

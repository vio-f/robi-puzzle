package gui;

import java.awt.Dimension;


/**
 * TODO DESCRIPTION
 * 
 * @author viorel.florian
 */
public class PuzzlePiecesPanel extends AbstractPuzzlePiecesPanel {

  /** serialVersionUID */
  private static final long serialVersionUID = 1L;

  /**
   * Constructs a new instance.
   * @param panelDimensions 
   */
  public PuzzlePiecesPanel(Dimension panelDimensions) {
    super(panelDimensions);
    this.addPuzzleContainersAndPopulate(3, 3);
  }

}

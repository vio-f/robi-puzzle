package gui;

import java.awt.Dimension;

/**
 * Panel containing the puzzle pieces at their final places
 * 
 * @author viorel.florian
 */
public class ReconstructionPanel extends AbstractPuzzlePiecesPanel{
  /** serialVersionUID */
  private static final long serialVersionUID = 1L;

  /**
   * Constructs a new instance.
   * @param panelDimensions 
   */
  public ReconstructionPanel(Dimension panelDimensions) {
    super(panelDimensions);
    this.addPuzzleContainersAndPopulate(3, 3);
  }

}//EOF
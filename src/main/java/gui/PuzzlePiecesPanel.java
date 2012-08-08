/*
 * Copyright (C) TBA BV
 * All rights reserved.
 * www.tba.nl
 */
package gui;

import java.awt.GridLayout;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * TODO DESCRIPTION
 * 
 * @author viorel.florian
 */
public class PuzzlePiecesPanel extends JPanel{

  /** serialVersionUID */
  private static final long serialVersionUID = 1L;
 
  
  //TODO make this dynamic
  /** defaultLayout */
  private GridLayout defaultLayout = new GridLayout(5, 4);
  
  /** puzzlePieces */
  private LinkedList<JButton> puzzlePiecesContainerList = new LinkedList<JButton>();
  
  /**
   * Constructs a new instance.
   */
  public PuzzlePiecesPanel() {
  super();
  this.setLayout(this.defaultLayout);
  this.addPuzzleContainers();
  }

  /**
   * Add puzzle pieces to the panel
   */
  private void addPuzzleContainers() {
    //TODO make this configurable
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

}

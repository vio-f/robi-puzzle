/*
 * Copyright Viorel Florian
 * All rights reserved.
 * viorel.florian@gmail.com
 */
package util;

/**
 * TODO DESCRIPTION
 * 
 * @author viorel.florian
 */
public class Utilities {
  
  /**
   * Put thread to sleep.
   * @param breakLengthInSeconds 
   */
  public static void iNeedABreak(int breakLengthInSeconds) {
    try {
      Thread.sleep(breakLengthInSeconds * 1000);
    } catch (InterruptedException e) {
      // TODO Add your own exception handling here, consider logging
      e.printStackTrace();
    }
  }

}

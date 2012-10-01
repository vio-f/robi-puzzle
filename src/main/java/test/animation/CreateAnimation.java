package test.animation;

import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JFrame;

public class CreateAnimation extends JFrame {
private static int DELAY = 90;
Insets insets;

  Color colors[] = { Color.PINK, Color.YELLOW, Color.GREEN, Color.RED,
      Color.BLUE, Color.CYAN };

  public void paint(Graphics graphics) {
    super.paint(graphics);
    if (insets == null) {
      insets = getInsets();
    }
  int steps=colors.length;
    int x = insets.left;
    int y = insets.top;
    int width = getWidth() - insets.left - insets.right;
    int height = getHeight() - insets.top - insets.bottom;
 
    synchronized (colors) {
      for (int i = 0; i < steps; i++) {
        graphics.setColor(colors[i]);
        graphics.fillRect(x, y, width, height);
      }
    }
  }
  public void go() {
    TimerTask timerTask = new TimerTask() {
      public void run() {
        Color color = colors[0];
        synchronized (colors) {
          System.arraycopy(colors, 1, colors, 0, colors.length - 1);
          colors[colors.length - 1] = color;
        }
        repaint();
      }
    };
    Timer timer = new Timer();
    timer.schedule(timerTask, 0, DELAY);
  }
   public static void main(String args[]) {
    CreateAnimation animation = new CreateAnimation();
    animation.setSize(250, 200);
    animation.show();
    animation.go();
  }
}
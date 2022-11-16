package ClockTime;

import java.awt.Dimension;

import javax.swing.JFrame;

public class TestDrive {
   public static void main(String[] args) {
      JFrame frame1 = new JFrame("Digital Clock");
      JFrame frame2 = new JFrame("Analog Clock");
      ClockTime clock = new ClockTime(5, 14, 36);
      DigitalClock digitalClock = new DigitalClock(clock);
      AnalogClock analogClock = new AnalogClock(clock);
      
      frame1.setSize(100, 70);
      frame1.setContentPane(digitalClock);
      frame2.setSize(100, 150);
      frame2.setContentPane(analogClock);
      frame1.setVisible(true);
      frame2.setVisible(true);
   }
}

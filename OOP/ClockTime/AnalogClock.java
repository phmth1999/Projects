package ClockTime;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

import javax.swing.JPanel;

public class AnalogClock extends JPanel implements Observer {
	private static final int MARGIN = 5;
	private static final Color HAND_COLOR = Color.BLACK;
	private static final Color SWEEP_COLOR = Color.RED;
	private static final Color FACE_COLOR = Color.WHITE;
	private static final Color FRAME_COLOR = Color.BLACK;
	private static final Color BACKGROUND_COLOR = Color.LIGHT_GRAY;

	private ClockTime clock;
	private Point center;
	private int diameter = 0;
	private int hourRange = 12;
	private int hourHandLength;
	private int minuteHandLength;
	private int secondHandLength;

	public AnalogClock(ClockTime clock) {
		this.clock = clock;
	}

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		diameter = Math.min(getWidth() - (2 * MARGIN), getHeight() - (2 * MARGIN));
		center = new Point((diameter / 2) + MARGIN, (diameter / 2) + MARGIN);
		hourHandLength = (int) (diameter * 0.30);
		minuteHandLength = (int) (diameter * 0.45);
		secondHandLength = (int) (diameter * 0.45);
		g.setColor(BACKGROUND_COLOR);
		g.fillRect(0, 0, getWidth(), getHeight());
		g.setColor(FACE_COLOR);
		g.fillOval(MARGIN, MARGIN, diameter, diameter);
		g.setColor(FRAME_COLOR);
		g.drawOval(MARGIN, MARGIN, diameter, diameter);
		int hour = clock.getHour();
		hour = hour > hourRange ? hour - hourRange : hour;
		drawClockHand(g, HAND_COLOR, hourHandLength, hour, hourRange);
		drawClockHand(g, HAND_COLOR, minuteHandLength, clock.getMinute(), 60);
		drawClockHand(g, SWEEP_COLOR, secondHandLength, clock.getSecond(), 60);
	}

	protected void drawClockHand(Graphics g, Color color, int length, int value, int range) {
		Point tip = calculateHandTip(center.x, center.y, length, value, range);
		g.setColor(color);
		g.drawLine(center.x, center.y, tip.x, tip.y);
	}

	protected Point calculateHandTip(int x, int y, int length, int value, int range) {
		double angle = (Math.PI * (((value * 360) / range) - 90)) / 180;
		return new Point(x + (int) (length * Math.cos(angle)), y + (int) (length * Math.sin(angle)));
	}

	@Override
	public void Update(int hour, int minute, int second) {
		clock = new ClockTime(hour, minute, second);
	}
}

package ClockTime;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class DigitalClock extends JPanel implements Observer {
	private JLabel clockLabel;
	private ClockTime clock;

	public DigitalClock(ClockTime clock) {
		clockLabel = new JLabel();
		add(clockLabel);
		this.clock = clock;
		showTime();
	}

	public void showTime() {
		StringBuffer text = new StringBuffer();
		text.append(clock.getHour() + ":");
		if (clock.getMinute() < 10)
			text.append("0");
		text.append(clock.getMinute() + ":");
		if (clock.getSecond() < 10)
			text.append("0");
		text.append(clock.getSecond());
		clockLabel.setText(text.toString());
	}

	@Override
	public void Update(int hour, int minute, int second) {
		clock = new ClockTime(hour, minute, second);
	}
}

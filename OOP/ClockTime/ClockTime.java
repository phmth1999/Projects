package ClockTime;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Observable;

import javax.swing.Timer;

public class ClockTime implements Subject {
	private Timer timer;
	private int hour;
	private int minute;
	private int second;
	private ArrayList<Observer> observers = new ArrayList<>();

	public ClockTime(int hour, int minute, int second) {
		this.hour = hour;
		this.minute = minute;
		this.second = second;
		timer = new Timer(1000, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tick();
			}
		});
		timer.start();
	}

	public void tick() {
		second++;
		if ((second %= 60) == 0)
			minute++;
		if ((minute %= 60) == 0)
			hour++;
		hour %= 24;
	}

	public int getHour() {
		return hour;
	}

	public int getMinute() {
		return minute;
	}

	public int getSecond() {
		return second;
	}

	@Override
	public void Register(Observer o) {
		observers.add(o);
	}

	@Override
	public void Remove(Observer o) {
		observers.remove(o);
	}

	@Override
	public void Notify() {
		for (Observer observer : observers) {
			observer.Update(hour, minute, second);
		}

	}
}

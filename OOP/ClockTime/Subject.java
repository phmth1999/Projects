package ClockTime;

public interface Subject {
	public void Register(Observer o);

	public void Remove(Observer o);

	public void Notify();
}

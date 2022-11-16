package CongTyDuLichXYZ;

public abstract class Tour {
	protected String name;
	protected String description;
	protected int days;
	protected double basePrice;



	public abstract double Price();
	public abstract String Description();
}

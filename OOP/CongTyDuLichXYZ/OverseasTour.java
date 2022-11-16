package CongTyDuLichXYZ;

public class OverseasTour extends Tour {
	private String country;
	private double visaSurtax;

	public OverseasTour(String name, String description, int days, double basePrice, String country,
			double visaSurtax) {
		this.name = name;
		this.description = description;
		this.days = days;
		this.basePrice = basePrice;
		this.country = country;
		this.visaSurtax = visaSurtax;
	}

	@Override
	public double Price() {
		return this.basePrice + this.visaSurtax;
	}

	@Override
	public String Description() {
		return this.description;
	}

}

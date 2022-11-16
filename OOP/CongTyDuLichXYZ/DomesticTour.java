package CongTyDuLichXYZ;

public class DomesticTour extends Tour {

	public DomesticTour(String name, String description, int days, double basePrice) {
		this.name = name;
		this.description = description;
		this.days = days;
		this.basePrice = basePrice;
	}

	@Override
	public double Price() {
		return this.basePrice;
	}

	@Override
	public String Description() {
		return this.description;
	}

}

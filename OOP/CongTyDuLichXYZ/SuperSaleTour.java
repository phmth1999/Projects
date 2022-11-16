package CongTyDuLichXYZ;

public class SuperSaleTour extends DecoratorTour {
	private double saleRate;

	public SuperSaleTour(Tour tour, double saleRate) {
		super(tour);
		this.saleRate = saleRate;
	}

	public SuperSaleTour(Tour tour) {
		super(tour);
	}

	@Override
	public double Price() {
		return this.basePrice*(1-this.saleRate);
	}

	@Override
	public String Description() {
		return tour.description+" + SuperSaleTour";
	}

}

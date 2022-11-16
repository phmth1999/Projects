package CongTyDuLichXYZ;

public class FiveStarTour extends DecoratorTour {

	public FiveStarTour(Tour tour) {
		super(tour);
	}

	@Override
	public double Price() {
		return this.basePrice * 1.5;
	}

	@Override
	public String Description() {
		return tour.description + " +FiveStarTour";
	}

}

package CongTyDuLichXYZ;

public abstract class DecoratorTour extends Tour{
	protected Tour tour;

	public DecoratorTour( Tour tour) {
		this.tour = tour;
	}
	
}

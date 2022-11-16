package shape;

public class Circle implements IShape {
	private double radius;

	public Circle(double radius) {
		this.radius = radius;
	}

	@Override
	public String draw() {
		return "Ve duong tron co ban kinh " + this.radius;

	}

}

package shape;

public class Rectangle implements IShape {
	private int width;
	private int heigth;

	public Rectangle(int width, int heigth) {
		this.width = width;
		this.heigth = heigth;
	}

	@Override
	public String draw() {
		return "ve hinh chu nhat co chieu dai: " + this.width +", va chieu rong: " + this.heigth;
	}

}

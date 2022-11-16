package shape;

public class Square implements IShape {
	private int width;

	public Square(int width) {
		this.width = width;
	}

	@Override
	public String draw() {
		return "ve hinh vuong co canh: " + this.width;
	}

}

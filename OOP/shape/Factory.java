package shape;

import java.util.Random;

public class Factory {
	Random rd = new Random();

	public IShape createShape() {
		int create = rd.nextInt(100);
		if (create < 30) {
			return new Circle(rd.nextInt(100));
		} else if (create >= 30 && create <= 60) {
			return new Rectangle(rd.nextInt(100), rd.nextInt(100));
		} else if (create > 60) {
			return new Square(rd.nextInt(100));
		}
		return null;

	}
}

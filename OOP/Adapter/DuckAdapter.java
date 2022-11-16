package Adapter;

import java.util.Random;

public class DuckAdapter implements Turkey {
	private Duck duck;
	private Random rand;

	public DuckAdapter(Duck duck) {
		rand = new Random();
		this.duck = duck;
	}

	@Override
	public void gooble() {
		duck.quack();
	}

	@Override
	public void fly() {
		if (rand.nextInt(5) == 0) {
			duck.fly();
		}
	}
}

package shape;

public class Test {
public static void main(String[] args) {
	
	Factory c = new Factory();
	IShape s = c.createShape();
	System.out.println(s.draw());
	
	Factory c2 = new Factory();
	IShape s2 =  c2.createShape();
	System.out.println(s2.draw());
}
}

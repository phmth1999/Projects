package TextComponent;

public class checkNumber implements ValidationStrategy {

	@Override
	public void check(String text) {
		try {
			Integer.parseInt(text);
			System.out.println("day la so");
		} catch (NumberFormatException e) {
			System.out.println("day khong phai la so");
		}
	}

}

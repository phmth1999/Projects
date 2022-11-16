package TextComponent;

public class checkPhone implements ValidationStrategy {

	@Override
	public void check(String text) {
		if (text.startsWith("08") && text.length() == 10) {
			System.out.println("day la sdt");
		} else {
			System.out.println("day khong pahi la sdt");
		}
	}

}

package TextComponent;

public class checkEmail implements ValidationStrategy {

	@Override
	public void check(String text) {
		if (text.contains("@")) {
			System.out.println("day la email");
		} else {
			System.out.println("day khong phai email");
		}
	}

}

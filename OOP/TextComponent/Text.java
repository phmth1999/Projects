package TextComponent;

public class Text {
	public static void main(String[] args) {
		TextComponent t= new TextComponent("a@gmail.com", new checkEmail());
//		t.setValidation(new checkNumber());
//		t.setValidation(new checkEmail());
//		t.setValidation(new checkPhone());
		t.check();
	}
}

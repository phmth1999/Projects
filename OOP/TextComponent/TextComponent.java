package TextComponent;

public class TextComponent {
	private String text;
	private ValidationStrategy validation;

	public TextComponent(String text, ValidationStrategy validation) {
		this.text = text;
		this.validation = validation;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public ValidationStrategy getValidation() {
		return validation;
	}

	public void setValidation(ValidationStrategy validation) {
		this.validation = validation;
	}

	public void check() {
		validation.check(text);
	}

}

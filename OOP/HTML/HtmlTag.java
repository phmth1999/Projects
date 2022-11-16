package HTML;

public abstract class HtmlTag {

	public abstract void setStartTag(String tag);

	public abstract void setEndTag(String tag);

	public void setTagBody(String tagBody) {
		
	}

	public void addChildTag(HtmlTag htmlTag) {
		
	}

	public abstract void generateHtml();
}

package HTML;

import java.util.ArrayList;
import java.util.List;

public class HtmlParentElement extends HtmlTag {
	private String tagName;
	private String startTag;
	private String endTag;
	private List<HtmlTag> childrenTag;

	public HtmlParentElement() {
		this.tagName = "";
		this.startTag = "";
		this.endTag = "";
		this.childrenTag = new ArrayList<>();
	}

	@Override
	public void setStartTag(String tag) {
		this.startTag = tag;
	}

	@Override
	public void setEndTag(String tag) {
		this.endTag = tag;
	}

	@Override
	public void addChildTag(HtmlTag htmlTag) {
		childrenTag.add(htmlTag);
	}

	@Override
	public void generateHtml() {
		System.out.println(startTag);
		for (HtmlTag tag : childrenTag) {
			tag.generateHtml();
		}
		System.out.println(endTag);

	}
}

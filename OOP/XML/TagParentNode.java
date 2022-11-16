package XML;

import java.util.ArrayList;
import java.util.List;

public class TagParentNode extends TagXML {
	private String tagName;
	private List<Property> properties;
	private List<TagXML> tags;

	public TagParentNode(String tagName) {
		this.tagName = tagName;
		this.properties = new ArrayList<Property>();
		this.tags = new ArrayList<TagXML>();
	}

	@Override
	public void generateHtml() {
		System.out.print("<" + tagName);
		for (Property property : properties) {
			System.out.print(" " + property);
		}
		System.out.println(">");
		for (TagXML tag : tags) {
			tag.generateHtml();
		}
		System.out.println("</" + tagName + ">");
	}

	@Override
	public void addProperties(Property pro) {
		properties.add(pro);
	}

	@Override
	public void addChillTag(TagXML tagXML) {
		tags.add(tagXML);
	}

}

package XML;

import java.util.ArrayList;
import java.util.List;

public class TagNode extends TagXML {
	private String tagName;
	private String tagValue;
	private List<Property> properties;

	public TagNode(String tagName, String tagValue) {
		this.tagName = tagName;
		this.tagValue = tagValue;
		this.properties = new ArrayList<Property>();
	}

	@Override
	public void generateHtml() {
		System.out.print("<" + tagName);
		for (Property property : properties) {
			System.out.print(" " + property);
		}
		System.out.println(">" + tagValue + "</" + tagName + ">");
	}

	@Override
	public void addProperties(Property pro) {
		properties.add(pro);
	}


}

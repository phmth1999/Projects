package XML;

public class Test {
public static void main(String[] args) {
	TagXML parent= new TagParentNode("orders");
	
	TagXML p1 = new TagParentNode("order");
	p1.addProperties(new Property("number", "123"));
	parent.addChillTag(p1);
	
	TagXML c1 = new TagNode("item", "Dog House");
	c1.addProperties(new Property("number", "12660"));
	c1.addProperties(new Property("quantity", "1"));
	p1.addChillTag(c1);
	
	TagXML c2 = new TagNode("item", "Bird Feeder");
	c2.addProperties(new Property("number", "54678"));
	c2.addProperties(new Property("quantity", "2"));
	p1.addChillTag(c2);
	
	parent.generateHtml();
}
}

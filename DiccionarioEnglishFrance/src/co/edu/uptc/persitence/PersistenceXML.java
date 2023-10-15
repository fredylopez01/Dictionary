package co.edu.uptc.persitence;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Set;
import java.util.Map.Entry;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import co.edu.uptc.model.DictionaryTraduction;

public class PersistenceXML {
	private Document doc;
	private String route;
	
	
	public PersistenceXML(String route) throws ParserConfigurationException, SAXException, IOException {
		this.route = route;
		File xmlFile = new File(route);
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder;
		dBuilder = dbFactory.newDocumentBuilder();
		doc = dBuilder.parse(xmlFile);
	}
	
	public void readDates(DictionaryTraduction dictionary){
		doc.getDocumentElement().normalize();
		NodeList nodeList = doc.getElementsByTagName("word");
		for(int i=0; i<nodeList.getLength(); i++)
			getWords(nodeList.item(i), dictionary.getWords());
	}
	
	public void getWords(Node node, HashMap<String, String> words ){
		if(node.getNodeType()==Node.ELEMENT_NODE){
			Element element = (Element)node;
			String key = getTagValue("key",element);
			String value = getTagValue("value",element);
			words.put(key, value);
		}
	}
	
	public String getTagValue(String tag, Element element){
		NodeList nodeList = element.getElementsByTagName(tag).item(0).getChildNodes();
		Node node = (Node) nodeList.item(0);
		return node.getNodeValue();
	}
	
	public void writeDOM2(/*DictionaryTraduction dictionary*/String key, String value) {
		Element rootElement = doc.getDocumentElement();
//		Set<Entry<String, String>> words = dictionary.getWords().entrySet();
//		for (Entry<String, String> entry: words) {
			rootElement.appendChild(newWord(key,value));
//			rootElement.appendChild(newWord(entry.getKey(),entry.getValue()));
//		}
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer;
		try {
			transformer = transformerFactory.newTransformer();
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
			DOMSource source = new DOMSource(doc);
			StreamResult file2 = new StreamResult(new File(route));
			transformer.transform(source, file2);
		} catch (TransformerException e1) {
			e1.printStackTrace();
		}
	}

	public Node newWord(String key, String value) {
		Element word = doc.createElement("word");
		word.appendChild(getWordElements("key", key));
		word.appendChild(getWordElements("value", value));
		return word;
	}

	public Node getWordElements(String name, String value) {
		Element node = doc.createElement(name);
		node.appendChild(doc.createTextNode(value));
		return node;
	}

	public String getRoute() {
		return route;
	}

	public void setRoute(String route) {
		this.route = route;
	}
	
}

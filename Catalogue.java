package FMA_7AGA;
import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.openqa.selenium.Keys;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

public class Catalogue {
	File xmlFile;

	public Catalogue() {
		try {
			getDocument();
		} catch (SAXException | IOException | ParserConfigurationException e) {
			e.printStackTrace();
		}
	}

	public Document getDocument() throws SAXException, IOException, ParserConfigurationException {

		File xmlFile = new File("C:\\Users\\modaser\\Desktop\\FMA_7AGA\\Catalogue.xml");

		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		Document doc;

		DocumentBuilder db = dbf.newDocumentBuilder();
		if(xmlFile.length() > 0){
           
			doc = db.parse(xmlFile);
			
		}else{
			
			doc = db.newDocument();
			Element root1 = doc.createElement("catalogue");
			doc.appendChild(root1);

		}
		
		return doc;
	}

	public void addBook(Book B1) {
		Document doc = null;
		try {
			doc = getDocument();
		} catch (SAXException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		} catch (ParserConfigurationException e1) {
			e1.printStackTrace();
		}
		Element root = doc.getDocumentElement();

		Element BOOK = doc.createElement("BOOK");
		root.appendChild(BOOK);
		Attr bookId = doc.createAttribute("ID");
		bookId.setValue(B1.getId());
		BOOK.setAttributeNode(bookId);
		Element anauthor = doc.createElement("Author");
		Element atitle = doc.createElement("Title");
		Element agenre = doc.createElement("Genre");
		Element aprice = doc.createElement("Price");
		Element apublishDate = doc.createElement("Publish_Date");
		Element adescription = doc.createElement("Description");
		
		anauthor.appendChild(doc.createTextNode(B1.getAuthor()));
		atitle.appendChild(doc.createTextNode(B1.getTitle()));
		agenre.appendChild(doc.createTextNode(B1.getGenre()));
		aprice.appendChild(doc.createTextNode(B1.getPrice()));
		apublishDate.appendChild(doc.createTextNode(B1.getPublishDate()));
		adescription.appendChild(doc.createTextNode(B1.getDescription()));

		BOOK.appendChild(anauthor);
		BOOK.appendChild(agenre);
		BOOK.appendChild(aprice);
		BOOK.appendChild(apublishDate);
		BOOK.appendChild(adescription);
		BOOK.appendChild(atitle);

		TransformerFactory factory = TransformerFactory.newInstance();
		Transformer transformer = null;
		try {
			transformer = factory.newTransformer();
		} catch (TransformerConfigurationException e) {
			e.printStackTrace();
		}
		DOMSource domSource = new DOMSource(doc);
		StreamResult streamResult = new StreamResult(new File("Catalogue.xml"));
		try {
			transformer.setOutputProperty ( OutputKeys.INDENT, "yes" );
        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "1");
        //transformer.transform(source, result);
			transformer.transform(domSource, streamResult);
		} catch (TransformerException e) {
			e.printStackTrace();
		}

	}

	public Node search(String elem) {
		Document doc = null;
		try {
			doc = getDocument();
		} catch (SAXException | IOException | ParserConfigurationException e) {
			e.printStackTrace();
		}

		NodeList nodeList = doc.getElementsByTagName("BOOK");
		Node ans = null;
		for (int itr = 0; itr < nodeList.getLength(); itr++) {
			Node node = nodeList.item(itr);
			if (node.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element) node;
				String aTitle = eElement.getElementsByTagName("Title").item(0).getTextContent();
				String anAuthor = eElement.getElementsByTagName("Author").item(0).getTextContent();
				if (aTitle.toLowerCase().equals(elem.toLowerCase())
						|| anAuthor.toLowerCase().equals(elem.toLowerCase())) {
					ans = node;
				}
			}

		}

		return ans;
	}


	public void searchAll(String elem) {
		Document doc = null;
		try {
			doc = getDocument();
		} catch (SAXException | IOException | ParserConfigurationException e) {
			e.printStackTrace();
		}
int x=0;
		NodeList nodeList = doc.getElementsByTagName("BOOK");
		//Node ans = null;
		for (int itr = 0; itr < nodeList.getLength(); itr++) {
			Node node = nodeList.item(itr);
			if (node.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element) node;
				String aTitle = eElement.getElementsByTagName("Title").item(0).getTextContent();
				String anAuthor = eElement.getElementsByTagName("Author").item(0).getTextContent();
				if (aTitle.toLowerCase().equals(elem.toLowerCase())
						|| anAuthor.toLowerCase().equals(elem.toLowerCase())) {
							x++;
							Element eeElement = (Element) node;
							System.out.println("Book ID: " + eeElement.getAttribute("ID"));
							System.out.println("Author: " + eeElement.getElementsByTagName("Author").item(0).getTextContent());
							System.out.println("Title: " + eeElement.getElementsByTagName("Title").item(0).getTextContent());
							System.out.println("Genre: " + eeElement.getElementsByTagName("Genre").item(0).getTextContent());
							System.out.println("Price: " + eeElement.getElementsByTagName("Price").item(0).getTextContent());
							System.out.println("Publish_Date: " + eeElement.getElementsByTagName("Publish_Date").item(0).getTextContent());
							System.out.println("Description: " + eeElement.getElementsByTagName("Description").item(0).getTextContent());
											System.out.println("_______________________________________________________");

				}
			}

		}
	}
		public void searchAll2(String elem) {
			Document doc = null;
			try {
				doc = getDocument();
			} catch (SAXException | IOException | ParserConfigurationException e) {
				e.printStackTrace();
			}
	int x=0;
			NodeList nodeList = doc.getElementsByTagName("BOOK");
			//Node ans = null;
			for (int itr = 0; itr < nodeList.getLength(); itr++) {
				Node node = nodeList.item(itr);
				if (node.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) node;
					String aTitle = eElement.getElementsByTagName("Title").item(0).getTextContent();
					String anAuthor = eElement.getElementsByTagName("Author").item(0).getTextContent();
					if (aTitle.toLowerCase().contains(elem.toLowerCase())
							|| anAuthor.toLowerCase().contains(elem.toLowerCase())) {
								x++;
								Element eeElement = (Element) node;
								System.out.println("Book ID: " + eeElement.getAttribute("ID"));
								System.out.println("Author: " + eeElement.getElementsByTagName("Author").item(0).getTextContent());
								System.out.println("Title: " + eeElement.getElementsByTagName("Title").item(0).getTextContent());
								System.out.println("Genre: " + eeElement.getElementsByTagName("Genre").item(0).getTextContent());
								System.out.println("Price: " + eeElement.getElementsByTagName("Price").item(0).getTextContent());
								System.out.println("Publish_Date: " + eeElement.getElementsByTagName("Publish_Date").item(0).getTextContent());
								System.out.println("Description: " + eeElement.getElementsByTagName("Description").item(0).getTextContent());
												System.out.println("_______________________________________________________");
	
					}
				}
	
			}
		if(x==0)
		System.out.println("Not found");
	}
	void delete(String key)
	{
Document doc = null;
		try {
			doc = getDocument();
		} catch (SAXException | IOException | ParserConfigurationException e) {
			e.printStackTrace();
		}
		int x=0;
		NodeList nodeList = doc.getElementsByTagName("BOOK");
		Node ans = null;
		for (int itr = 0; itr < nodeList.getLength(); itr++) {
			Node node = nodeList.item(itr);
			if (node.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element) node;
				String Id = eElement.getAttribute("ID");
				if (Id.toLowerCase().equals(key.toLowerCase())) {
					x++;
					doc.getDocumentElement().removeChild(node);
					TransformerFactory factory = TransformerFactory.newInstance();
					Transformer transformer = null;
					try {
						transformer = factory.newTransformer();
					} catch (TransformerConfigurationException e) {
						e.printStackTrace();
					}
					DOMSource domSource = new DOMSource(doc);
					StreamResult streamResult = new StreamResult(new File("Catalogue.xml"));
					try {
						transformer.transform(domSource, streamResult);
					} catch (TransformerException e) {
						e.printStackTrace();
					}
					
                System.out.println("Successfully deleted");

	}
}

		}
		if(x==0)
System.out.println("Not found");

	}
}

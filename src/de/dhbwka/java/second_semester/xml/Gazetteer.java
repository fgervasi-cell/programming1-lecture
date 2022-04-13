package de.dhbwka.java.second_semester.xml;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class Gazetteer {
	public static void main(String[] args) {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder parser = factory.newDocumentBuilder();
			Document document = parser.parse("https://www.iai.kit.edu/javavl/data/static/karlsruhe.xml");
			System.out
					.println("Adresse: " + document.getElementsByTagName("formatted_address").item(0).getTextContent());
			System.out.println("Long Name: " + document.getElementsByTagName("long_name").item(0).getTextContent());
			String latitude = document.getElementsByTagName("lat").item(0).getTextContent();
			String longitude = document.getElementsByTagName("lng").item(0).getTextContent();
			System.out.println("Location: (latitude=" + latitude + ", longitude=" + longitude + ")");
			String east = document.getElementsByTagName("lng").item(4).getTextContent();
			String north = document.getElementsByTagName("northeast").item(1).getChildNodes().item(1).getTextContent();
			String west = document.getElementsByTagName("lng").item(3).getTextContent();
			String south = document.getElementsByTagName("lat").item(3).getTextContent();
			System.out.println(
					"Bounds: (east=" + east + ", north=" + north + ", west=" + west + ", south=" + south + ")");
		} catch (ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
		}
	}
}

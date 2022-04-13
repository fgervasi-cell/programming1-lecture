package de.dhbwka.java.second_semester.xml;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class Grid {
	public static void main(String[] args) {
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder parser = factory.newDocumentBuilder();
			Document document = parser.newDocument();
			Element kml = document.createElementNS("http://earth.google.com/kml/2.2", "kml");
			Element documentElement = document.createElement("Document");
			double southwestLat = 48.9404298;
			double southwestLng = 8.2774096;
			double northeastLat = 49.0912684;
			double northeastLng = 8.5416581;
			double d = Math.sqrt(Math.pow(((southwestLng + northeastLng) / 2) - southwestLng, 2)
					+ Math.pow(((southwestLat + northeastLat) / 2) - southwestLat, 2));
			System.out.println(d);

			for (int i = 0; i < 3; i++) {
				Element placemark = document.createElement("Placemark");
				Element name = document.createElement("name");
				name.setTextContent("Punkt " + i);
				placemark.appendChild(name);
				Element point = document.createElement("Point");
				Element coordinates = document.createElement("coordinates");
				if (i == 0) {
					coordinates.setTextContent(String.format("%s, %s", southwestLng, southwestLat));
				} else if (i == 2) {
					coordinates.setTextContent(String.format("%s, %s", northeastLng, northeastLat));
				} else if (i == 1) {
					coordinates.setTextContent(String.format("%s, %s", (southwestLng + northeastLng) / 2,
							(southwestLat + northeastLat) / 2));
				}
				point.appendChild(coordinates);
				placemark.appendChild(point);
				documentElement.appendChild(placemark);
			}

			kml.appendChild(documentElement);
			document.appendChild(kml);

			TransformerFactory tf = TransformerFactory.newInstance();
			Transformer transformer = tf.newTransformer();
			FileOutputStream outStream = new FileOutputStream(
					new File("C:\\Users\\fgerv\\eclipse-workspace\\University\\FileExperimentsFolder\\grid.xml"));
			transformer.transform(new DOMSource(document), new StreamResult(outStream));
		} catch (ParserConfigurationException | TransformerException | IOException e) {
			e.printStackTrace();
		}
	}
}

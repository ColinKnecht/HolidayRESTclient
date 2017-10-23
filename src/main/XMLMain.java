package main;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import generated.NewDataSet;
import generated.NewDataSet.Holidays;

public class XMLMain {
	public static final String XML_FILE_NAME = "GetHolidaysForYear.xml";
	public static void main(String[] args) {
		// Get an unmarsheller
		
		
		try {
			JAXBContext jc;
			jc = JAXBContext.newInstance("generated");
			Unmarshaller u = jc.createUnmarshaller();
			
			//Build a DOM
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			dbf.setNamespaceAware(true);
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document doc = db.parse(new File(XML_FILE_NAME));
			//traverse the document until "NewDataSet" is reached
			Element subtree = doc.getDocumentElement();
			Node node = subtree.getElementsByTagName("NewDataSet")
					.item(0);
			//unmarshall "NewDataSet" AKA convert XML into java object
			JAXBElement<NewDataSet> dataSet = u.unmarshal(node, NewDataSet.class);
			//print the holidays
			List<Holidays> holidays = dataSet.getValue().getHolidays();
			for(Holidays h : holidays){
				System.out.printf("%30s: %d\n", h.getName(), h.getDate());
			}
		
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		try
//		{
//			Unmarshaller u = jc.createUnmarshaller();
//		} catch (JAXBException e)
//		{
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
 catch (ParserConfigurationException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e)
{
	// TODO Auto-generated catch block
	e.printStackTrace();
} catch (IOException e)
{
	// TODO Auto-generated catch block
	e.printStackTrace();
}

	}

}

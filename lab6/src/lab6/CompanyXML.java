package lab6;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.TreeSet;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlRootElement;

public class CompanyXML implements Serialize<Company> {

	@Override
	public void serialize(Company obj, String title) throws IOException {
		File file = new File("output/" + title);
		String xmlString = "";
		try {
			JAXBContext context = JAXBContext.newInstance(Company.class);
			Marshaller m = context.createMarshaller();

			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE); // To format XML

			StringWriter sw = new StringWriter();
			m.marshal(obj, sw);
			xmlString = sw.toString();
			System.out.println(xmlString);

		} catch (JAXBException e) {
			e.printStackTrace();
		}
		FileWriter fw = new FileWriter(file);
		fw.write(xmlString);
		fw.close();
	}

	@Override
	public Company deserialize(String title) throws IOException {
		Company c = null;

		try {

			File file = new File("output/" + title);
			JAXBContext jaxbContext = JAXBContext.newInstance(Company.class);

			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			c = (Company) jaxbUnmarshaller.unmarshal(file);
			System.out.println(c.toString());

		} catch (JAXBException e) {
			e.printStackTrace();
		}

		return c;

	}


}

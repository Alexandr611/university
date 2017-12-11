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

public class EmployeeXML implements Serialize<Employee> {

	@Override
	public void serialize(Employee obj, String title) throws IOException {
		File file = new File("output/"+title);
		String xmlString = "";
		try {
			JAXBContext context = JAXBContext.newInstance(Employee.class);
			Marshaller m = context.createMarshaller();

			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE); // To format XML

			StringWriter sw = new StringWriter();
			m.marshal(obj, sw);
			xmlString = sw.toString();

		} catch (JAXBException e) {
			e.printStackTrace();
		}
		FileWriter fw = new FileWriter(file);
		fw.write(xmlString);
		fw.close();
	}

	@Override
	public Employee deserialize(String title) throws IOException {
		
		Employee e = null;
		try {

			File file = new File("output/"+title);
			JAXBContext jaxbContext = JAXBContext.newInstance(Employee.class);

			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			e = (Employee) jaxbUnmarshaller.unmarshal(file);

		} catch (JAXBException err) {
			err.printStackTrace();
		}

		return e;

	}


}

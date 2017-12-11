package lab6;

import java.io.IOException;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.Set;
import java.util.TreeSet;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class CompanyJson implements Serialize<Company> {

	@Override
	public void serialize(Company obj, String title) throws IOException {

		ObjectMapper mapper = new ObjectMapper();

		mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
		mapper.writeValue(new File("output/" + title), obj);

	}

	@Override
	public Company deserialize(String title) throws IOException {
		ObjectMapper mapper = new ObjectMapper();

		Company c = mapper.readValue(new File("output/" + title), Company.class);
		System.out.println(c.toString());
		return c;

	}


}

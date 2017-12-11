package lab5;

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

public class EmployeeJson implements Serialize<Employee> {

	@Override
	public void serialize(Employee obj, String title) throws IOException {

		ObjectMapper mapper = new ObjectMapper();

		mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
		// Convert object to JSON string and save into a file directly
		mapper.writeValue(new File("output/" + title), obj);

	}

	
	@Override
	public Employee deserialize(String title) throws IOException {
		ObjectMapper mapper = new ObjectMapper();

		Employee e = mapper.readValue(new File("output/" + title), Employee.class);
		return e;

	}

	
}

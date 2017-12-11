package lab6;

import java.io.IOException;
import java.util.TreeSet;

import org.testng.AssertJUnit;

public class Tmain {

	public static void main(String[] args) throws IOException {
		

		Company c3 = new CompanyJson().deserialize("CompanyJson.json");
		
		new CompanyXML().serialize(c3, "test.xml");

	}

}

package lab5;

import org.testng.annotations.Test;

import org.testng.AssertJUnit;
import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.Collection;
import java.util.TreeSet;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestOutput {

	@Test
	public void TestEmployeeJson() throws IOException {

		Employee e1 = new Employee.Builder("Alex", "Malinovsky").setEmail("alexandr@gmail.com")
				.setPhone("+380951474136").createEmployee();
		Employee e11 = new Employee.Builder("IIvan", "Pastula").setEmail("IPastula@gmail.com").setPhone("+380664474331")
				.createEmployee();
		Employee e2 = new Employee.Builder("Mike", "Jidora").setEmail("IVasovsk@gmail.com").setPhone("+380952274136")
				.createEmployee();
		Employee e3 = new Employee.Builder("Kiril", "Kirilich").setEmail("KKirili@gmail.com").setPhone("+380993755999")
				.createEmployee();

		e1.setPost(Employee.Post.JUNIOR);
		e1.setSalaryByPost();
		e11.setPost(Employee.Post.JUNIOR);
		e11.setSalaryByPost();
		e2.setPost(Employee.Post.MIDLE);
		e2.setSalaryByPost();
		e3.setPost(Employee.Post.SENIOR);
		e3.setSalaryByPost();

		new EmployeeJson().serialize(e1, "EmployeeJson.json");

		Employee res = new EmployeeJson().deserialize("EmployeeJson.json");

		AssertJUnit.assertEquals(res.toString(), res.toString());
	}

	@Test
	public void TestEmployeeXML() throws IOException {

		Employee e1 = new Employee.Builder("Alex", "Malinovsky").setEmail("alexandr@gmail.com")
				.setPhone("+380951474136").createEmployee();
		Employee e11 = new Employee.Builder("IIvan", "Pastula").setEmail("IPastula@gmail.com").setPhone("+380664474331")
				.createEmployee();
		Employee e2 = new Employee.Builder("Mike", "Ivasovsky").setEmail("IVasovsk@gmail.com").setPhone("+380952274136")
				.createEmployee();
		Employee e3 = new Employee.Builder("Kiril", "Kirilich").setEmail("KKirili@gmail.com").setPhone("+380993755999")
				.createEmployee();

		e1.setPost(Employee.Post.JUNIOR);
		e1.setSalaryByPost();
		e11.setPost(Employee.Post.JUNIOR);
		e11.setSalaryByPost();
		e2.setPost(Employee.Post.MIDLE);
		e2.setSalaryByPost();
		e3.setPost(Employee.Post.SENIOR);
		e3.setSalaryByPost();

		new EmployeeXML().serialize(e1, "employeeXml.xml");

		Employee res = new EmployeeXML().deserialize("employeeXML.xml");

		AssertJUnit.assertEquals(e1.toString(), res.toString());
	}

	@Test
	public void TestCompanyXML() throws IOException {

		Employee e1 = new Employee.Builder("Alex", "Malinovsky").setEmail("alexandr@gmail.com")
				.setPhone("+380951474136").createEmployee();
		Employee e11 = new Employee.Builder("IIvan", "Pastula").setEmail("IPastula@gmail.com").setPhone("+380664474331")
				.createEmployee();
		Employee e2 = new Employee.Builder("Mike", "Ivasovsky").setEmail("IVasovsk@gmail.com").setPhone("+380952274136")
				.createEmployee();
		Employee e3 = new Employee.Builder("Kiril", "Kirilich").setEmail("KKirili@gmail.com").setPhone("+380993755999")
				.createEmployee();

		e1.setPost(Employee.Post.JUNIOR);
		e1.setSalaryByPost();
		e11.setPost(Employee.Post.JUNIOR);
		e11.setSalaryByPost();
		e2.setPost(Employee.Post.MIDLE);
		e2.setSalaryByPost();
		e3.setPost(Employee.Post.SENIOR);
		e3.setSalaryByPost();

		TreeSet<Employee> E1 = new TreeSet<>();
		E1.add(e1);
		E1.add(e11);
		E1.add(e2);
		E1.add(e3);

		TreeSet<Employee> E2 = new TreeSet<>();
		E2.add(e2);
		E2.add(e3);

		Company c1 = new Company.CompanyBuilder("WebDev").setEmployees(E1).createCompany();
		Company c2 = new Company.CompanyBuilder("GameDev").setEmployees(E2).createCompany();

		new CompanyXML().serialize(c1, "CompanyXML.xml");

		Company c3 = new CompanyXML().deserialize("CompanyXML.xml");


		AssertJUnit.assertEquals(c3.getName(), c1.getName());
	}
	
	@Test
	public void TestCompanyJson() throws IOException {

		Employee e1 = new Employee.Builder("Alex", "Malinovsky").setEmail("alexandr@gmail.com")
				.setPhone("+380951474136").createEmployee();
		Employee e11 = new Employee.Builder("IIvan", "Pastula").setEmail("IPastula@gmail.com").setPhone("+380664474331")
				.createEmployee();
		Employee e2 = new Employee.Builder("Mike", "Ivasovsky").setEmail("IVasovsk@gmail.com").setPhone("+380952274136")
				.createEmployee();
		Employee e3 = new Employee.Builder("Kiril", "Kirilich").setEmail("KKirili@gmail.com").setPhone("+380993755999")
				.createEmployee();

		e1.setPost(Employee.Post.JUNIOR);
		e1.setSalaryByPost();
		e11.setPost(Employee.Post.JUNIOR);
		e11.setSalaryByPost();
		e2.setPost(Employee.Post.MIDLE);
		e2.setSalaryByPost();
		e3.setPost(Employee.Post.SENIOR);
		e3.setSalaryByPost();

		TreeSet<Employee> E1 = new TreeSet<>();
		E1.add(e1);
		E1.add(e11);
		E1.add(e2);
		E1.add(e3);

		TreeSet<Employee> E2 = new TreeSet<>();
		E2.add(e2);
		E2.add(e3);

		Company c1 = new Company.CompanyBuilder("WebDev").setEmployees(E1).createCompany();
		Company c2 = new Company.CompanyBuilder("GameDev").setEmployees(E2).createCompany();

		new CompanyJson().serialize(c1, "CompanyJson.json");

		Company c3 = new CompanyJson().deserialize("CompanyJson.json");


		AssertJUnit.assertEquals(c3.getName(), c1.getName());
	}

}
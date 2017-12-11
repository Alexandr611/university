package lab6;

import java.io.IOException;
import java.sql.SQLException;
import java.util.TreeSet;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;

public class TestBD {
	@Test
	public void TestCompanyDB() throws IOException, ClassNotFoundException, SQLException {

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
		new CompanyBD().SetCompanyDB();
		new CompanyBD().addCompany(c1);
		Company c = new CompanyBD().getCompanyWithEmployee(1);
		AssertJUnit.assertEquals(c.getName(), c1.getName());
	}
	
	@Test
	public void TestEmployeeDB() throws IOException, ClassNotFoundException, SQLException {
		new CompanyBD().SetCompanyDB();
		new CompanyBD().updateEmployeeField("lastName", "Jidora", 3);
		Employee e = new CompanyBD().getEmployee(3);
		System.out.println(e.getLastName());

		AssertJUnit.assertEquals(e.getLastName(), "Jidora");
	}

}

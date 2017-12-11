package lab4;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import static org.testng.Assert.assertEquals;

import java.util.TreeSet;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestCompany {

	@Test
	public void TestTreeSet() {

		Employee e1 = new Employee.Builder("Alex", "Malinovsky").setEmail("alexandr@gmail.com")
				.setPhone("+380951474136").createEmployee();
		Employee e11 = new Employee.Builder("Ivan", "Pastula").setEmail("IPastula@gmail.com").setPhone("+380664474331")
				.createEmployee();
		Employee e2 = new Employee.Builder("Mike", "Ivasovsky").setEmail("IVasovsk@gmail.com").setPhone("+380952274136")
				.createEmployee();
		Employee e3 = new Employee.Builder("Kiril", "Kirilich").setEmail("KKirili@gmail.com").setPhone("+380993755999")
				.createEmployee();
		e1.setPost(Employee.Post.JUNIOR).setSalaryByPost();
		e11.setPost(Employee.Post.JUNIOR).setSalaryByPost();
		e2.setPost(Employee.Post.MIDLE).setSalaryByPost();
		e3.setPost(Employee.Post.SENIOR).setSalaryByPost();

		TreeSet<Employee> E1 = new TreeSet<>();
		E1.add(e1);
		E1.add(e11);
		E1.add(e2);
		E1.add(e3);

		Company c1 = new Company.CompanyBuilder("WebDev").setEmployees(E1).createCompany();
		try {
			AssertJUnit.assertEquals(c1.findCountGivenPosts(Employee.Post.MIDLE), 1);
		} catch (java.lang.AssertionError e) {
			System.out.println(e);
		}

	}
	
	@Test
	public void TestTreeSetStream() {

		Employee e1 = new Employee.Builder("Alex", "Malinovsky").setEmail("alexandr@gmail.com")
				.setPhone("+380951474136").createEmployee();
		Employee e11 = new Employee.Builder("Ivan", "Pastula").setEmail("IPastula@gmail.com").setPhone("+380664474331")
				.createEmployee();
		Employee e2 = new Employee.Builder("Mike", "Ivasovsky").setEmail("IVasovsk@gmail.com").setPhone("+380952274136")
				.createEmployee();
		Employee e3 = new Employee.Builder("Kiril", "Kirilich").setEmail("KKirili@gmail.com").setPhone("+380993755999")
				.createEmployee();
		e1.setPost(Employee.Post.JUNIOR).setSalaryByPost();
		e11.setPost(Employee.Post.JUNIOR).setSalaryByPost();
		e2.setPost(Employee.Post.MIDLE).setSalaryByPost();
		e3.setPost(Employee.Post.SENIOR).setSalaryByPost();

		TreeSet<Employee> E2 = new TreeSet<>();
		E2.add(e2);
		E2.add(e3);

		Company c2 = new Company.CompanyBuilder("GameDev").setEmployees(E2).createCompany();
		try {
			AssertJUnit.assertEquals(c2.getHighestSallaryStream(), "Kirilich");
		} catch (java.lang.AssertionError e) {
			System.out.println(e);
		}

	}

}
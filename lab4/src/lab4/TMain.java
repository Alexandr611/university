package lab4;

import java.util.TreeSet;

public class TMain {

	public static void main(String[] args) {

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

		TreeSet<Employee> E2 = new TreeSet<>();
		E2.add(e2);
		E2.add(e3);

		Company c1 = new Company.CompanyBuilder("WebDev").setEmployees(E1).createCompany();
		Company c2 = new Company.CompanyBuilder("GameDev").setEmployees(E2).createCompany();

		for (Employee e : c1.employees) {
			System.out.println(e.toString());
		}
		for (Employee e : c2.employees) {
			System.out.println(e.toString());
		}

		System.out.println(c1.getHighestSallaryStream());

		System.out.println(c1.findCountGivenPosts(Employee.Post.JUNIOR));

	}

}

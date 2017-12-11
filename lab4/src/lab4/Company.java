package lab4;

import java.util.Comparator;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class Company {

	String name;
	TreeSet<Employee> employees = new TreeSet<>(new Comparator<Employee>() {
		public int compare(Employee e1, Employee e2) {
			return e1.getLastName().compareTo(e2.getLastName());
		}
	});

	public Company(String name, TreeSet<Employee> employees) {
		this.name = name;
		this.employees.addAll(employees);
	}

	public Company() {
		this("Name", null);
	}

	public Company(CompanyBuilder builder) {
		this.name = builder.name;
		for (Employee employee : builder.employees) {
			this.addEmployee(employee);

		}
	}

	public int getCountEmployees() {

		return employees.size();
	}

	public void addEmployee(Employee e) {

		employees.add(e);
	}

	public String getName() {

		return this.name;
	}

	public String getHighestSallaryStream() {

		Employee e = employees.stream().max((e1, e2) -> compareSalart(e1, e2)).get();
		return e.getLastName();
	}

	public int compareSalart(Employee e1, Employee e2) {

		return e1.getSalary() > e2.getSalary() ? 1 : -1;

	}

	public long findCountGivenPosts(Employee.Post post) {

		long count = employees.stream().filter((e) -> e.getPost() != null && e.getPost().equals(post)).count();

		return count;

	}

	public static class CompanyBuilder {
		String name;
		final static String Employee_NAME_PATERN = "^[A-Z][A-z-]+$";
		TreeSet<Employee> employees = new TreeSet<>(new Comparator<Employee>() {
			// @Overrride
			public int compare(Employee e1, Employee e2) {
				return e1.getLastName().compareTo(e2.getLastName());
			}
		});

		public CompanyBuilder(String name) {
			Pattern p1 = Pattern.compile(Employee_NAME_PATERN);
			Matcher m1 = p1.matcher(name);
			if (m1.matches())
				this.name = name;
			else
				throw new IllegalArgumentException("Name is incorrect");
		}

		public CompanyBuilder setEmployees(TreeSet<Employee> employees) {
			for (Employee employee : employees) {
				this.employees.add(employee);
				// System.out.println(employee.toString());
			}
			return this;
		}

		public Company createCompany() {
			return new Company(this);
		}

		public CompanyBuilder getBuilder() {
			return this;
		}

	}

}

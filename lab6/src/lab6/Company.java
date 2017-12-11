package lab6;

import java.util.Comparator;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnore;
@XmlRootElement(name = "Company")
public class Company  implements Comparable<Company> {
	int id;
	String name;
	TreeSet<Employee> employees = new TreeSet<>(new Comparator<Employee>() {
		public int compare(Employee e1, Employee e2) {
			return e1.getLastName().compareTo(e2.getLastName());
		}
	});

	public Company(String name, TreeSet<Employee> employees) {
		super();
		this.name = name;
		this.employees.addAll(employees);
	}

	public Company() {
		super();
	}

	public Company(CompanyBuilder builder) {
		this.name = builder.name;
		for (Employee employee : builder.employees) {
			this.addEmployee(employee);

		}
	}
	
	public TreeSet<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(TreeSet<Employee> employees) {
		this.employees.addAll(employees);
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void setId(int id) {
		this.id = id;
		
	}

	@JsonIgnore
	public int getCountEmployees() {

		return employees.size();
	}

	public void addEmployee(Employee e) {

		employees.add(e);
	}

	public String getName() {

		return this.name;
	}
	
	public int getId() {
		return this.id;
	}

	@JsonIgnore
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

	// public int equilsPost(Employee.Post post1,Employee.Post post2){
	//
	// return post2 == post1 ? 1: -1;
	//
	// }


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
			}
			return this;
		}

		public Company createCompany() {
			return new Company(this);
		}

		public CompanyBuilder getBuilder() {
			return this;
		}

		@Override
		public String toString() {
			
			String result = null;
			
			for(Employee e : employees) {
				result = "["+e.toString()+"],";
			}
			
			return result;
		}
		

	}

	@Override
	public int compareTo(Company c) {
		Company one = (Company)c;
		if(one.name.length()<this.name.length())
			return -1;
		else return 1;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((employees == null) ? 0 : employees.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Company other = (Company) obj;
		if (employees == null) {
			if (other.employees != null)
				return false;
		} else if (!employees.equals(other.employees))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
}

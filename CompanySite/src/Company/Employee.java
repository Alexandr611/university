package Company;


import java.util.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@XmlRootElement(name = "Employee")
public
class Employee implements Comparable<Employee> {
	int id;
	public enum Post {
		JUNIOR,
		MIDLE,
		SENIOR,
		TEAMLEAD;

	};
	private Post post;
	private String firstName;
	private String lastName;
	private String email;
	private LocalDate dateOfBirthday;
	private double salary;
	private String phoneNumber;
	public static final String NAMEPATTERN = "^[A-Z][A-z-]+$";
	public static final String PHONEPATTERN = "^\\+?\\d{11,12}$";
	public static final String EMAILPATTERN = "^[A-Za-z0-9-_ ]+@\\w{2,15}.\\w+$";

	public Employee(int id, Post post, String firstName, String lastName, String email, LocalDate dateOfBirthday,
			double salary, String phoneNumber) {
		super();
		this.id = id;
		this.post = post;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.dateOfBirthday = dateOfBirthday;
		this.salary = salary;
		this.phoneNumber = phoneNumber;
	}

	public Employee() {
		super();
	}

	public static class Builder {
		public String firstName;
		public String lastName;
		public String email;
		public String phoneNumber;

		public Builder(String firstName, String lastName) {

			Pattern p1 = Pattern.compile(NAMEPATTERN);
			Matcher m1 = p1.matcher(firstName);
			if (m1.matches())
				this.firstName = firstName;
			else
				throw new IllegalArgumentException("Bad first name");
			Pattern p2 = Pattern.compile(NAMEPATTERN);
			Matcher m2 = p2.matcher(lastName);
			if (m2.matches())
				this.lastName = lastName;
			else
				throw new IllegalArgumentException("Bad last name");

		}

		public Builder setPhone(String number) {

			Pattern p2 = Pattern.compile(PHONEPATTERN);
			Matcher m2 = p2.matcher(number);
			if (m2.matches())
				this.phoneNumber = number;
			else
				throw new IllegalArgumentException("Bad phone number");

			return this;

		}

		public Builder setEmail(String email) {

			Pattern p1 = Pattern.compile(EMAILPATTERN);
			Matcher m1 = p1.matcher(email);
			if (m1.matches())
				this.email = email;
			else
				throw new IllegalArgumentException("Bad email");

			return this;
		}

		public Employee createEmployee() {

			return new Employee(this);
		}
	}

	public Employee(Builder builder) {
		this(builder.firstName, builder.lastName, builder.email, builder.phoneNumber);
	}

	public Employee(String firstName, String lastName, String email, String phoneNumber) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
	}

	// getters

	@XmlElement
	public int getId() {
		return id;
	}

	
	public double getSalary() {
		return salary;
	}


	public String getEmail() {
		return email;
	}


	public Post getPost() {
		return post;
	}
	
	public String getPostString() {
		return post.name();
	}

	public String getFirstName() {
		return firstName;
	}


	public String getLastName() {
		return lastName;
	}
	@JsonIgnore
	public LocalDate getDateOfBirthday() {
		return dateOfBirthday;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	// setters

	public Employee setId(int id) {
		this.id = id;
		return this;
	}

	public Employee setSalary(double salary) {
		this.salary = salary;
		return this;
	}

	public Employee setEmail(String email) {
		this.email = email;
		return this;
	}

	public Employee setPostString(String post) {
		post = post.toUpperCase();
		switch (post) {
		case "JUNIOR":
			this.post = Employee.Post.JUNIOR;
			break;
		case "MIDLE":
			this.post = Employee.Post.MIDLE;
			break;
		case "SENIOR":
			this.post = Employee.Post.SENIOR;
			break;
		}
		return this;
	}
	@JsonIgnore
	public Employee setPost(Post post) {

		this.post = post;

		if (salary == 0) {
			setSalaryByPost();
		}

		return this;
	}

	public Employee setFirstName(String firstName) {
		this.firstName = firstName;
		return this;
	}

	public Employee setLastName(String lastName) {
		this.lastName = lastName;
		return this;
	}

	public Employee setDateOfBirthday(int year, int month, int day) {
		this.dateOfBirthday = LocalDate.of(year, month, day);
		return this;
	}

	public Employee setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
		return this;
	}

	public Employee setSalaryByPost() {
		// assert (post != null): "Enter post to set salary";

		switch (post) {
		case JUNIOR:
			setSalary(800);
			break;
		case MIDLE:
			setSalary(1200);
			break;
		case SENIOR:
			setSalary(2000);
			break;
		}

		return this;
	}

	public Employee increasePost() {

		assert (post != null) : "You don't have already post!";

		switch (post) {

		case JUNIOR:
			setPost(Post.MIDLE);
			break;
		case MIDLE:
			setPost(Post.SENIOR);
			break;
		case SENIOR:
			setPost(Post.TEAMLEAD);
			break;

		}

		return this;

	}

	@Override
	public String toString() {
		return "Employee [post=" + post + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", dateOfBirthday=" + dateOfBirthday + ", salary=" + salary + ", phoneNumber=" + phoneNumber + "]";
	}

	@Override
	public boolean equals(Object obj) {

		return (firstName == ((Employee) obj).firstName && lastName == ((Employee) obj).lastName
				&& phoneNumber == ((Employee) obj).phoneNumber);
	}

	@Override
	public int compareTo(Employee o) {
		Employee one = (Employee) o;
		if (one.lastName.length() < this.lastName.length())
			return -1;
		else
			return 1;
	}
}

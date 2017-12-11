package lab3;

import java.util.*;
import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import lab3.Employee;

class Employee{

	   private String firstName;
	    private String lastName;
	    private String email;
	    private LocalDate dateOfBirthday;
	    private double salary;
	    private String post;
	    private String phoneNumber;
	    private String paidOrFreeGroup;
	    public static final String NAMEPATTERN = "^[A-Z][A-z-]+$";
	    public static final String PHONEPATTERN = "^\\+?\\d{11,12}$";
	    public static final String EMAILPATTERN = "^[A-Za-z0-9-_ ]+@\\w{2,15}.\\w+$";
	    
	    public static class Builder {
	    	public String firstName;
	    	public String lastName;
	    	public String email;
	    	public String phoneNumber;
			
			public Builder(String firstName,String lastName) {
			
				Pattern p1 = Pattern.compile(NAMEPATTERN);
				Matcher m1 = p1.matcher(firstName);
				if(m1.matches())
				  this.firstName=firstName;
				else throw new IllegalArgumentException("Bad first name");
				Pattern p2 = Pattern.compile(NAMEPATTERN);
				Matcher m2 = p2.matcher(lastName);
				if(m2.matches())
				  this.lastName=lastName;
				else throw new IllegalArgumentException("Bad last name");
			
			}
			
			public Builder setPhone(String number) {

				Pattern p2 = Pattern.compile(PHONEPATTERN);
				Matcher m2 = p2.matcher(number);
				if(m2.matches())
					this.phoneNumber=number;
				else throw new IllegalArgumentException("Bad phone number");
		
				return this;
			
			}
			
			public Builder setEmail(String email) {
				
				Pattern p1 = Pattern.compile(EMAILPATTERN);
				Matcher m1 = p1.matcher(email);
				if(m1.matches())
					this.email=email;
				else throw new IllegalArgumentException("Bad email");
		
				return this;
			}
			
			public	Employee createEmployee() {
				
				return new Employee(this);
			}
		}
			
		public Employee(Builder builder) {
			this(builder.firstName,builder.lastName,builder.email,builder.phoneNumber);
		}
			
	    
	    public Employee(String firstName,String lastName,String email,String phoneNumber) {
			this.firstName=firstName;
			this.lastName=lastName;
			this.email=email;
			this.phoneNumber=phoneNumber;
		}
		
		
	    
	    // getters
	    
	    public double getSalary() {
	    	return salary;
	    }
	    
	    public String getEmail() {
	        return email;
	    }
	    
	    public String getPost() {
	        return post;
	    }
	    
	    public String getFirstName() {
	        return firstName;
	    }

	    public String getLastName() {
	        return lastName;
	    }

	    public LocalDate getDateOfBirthday() {
	        return dateOfBirthday;
	    }

	    public double getAverageMark() {
	        return salary;
	    }

	    public String getPhoneNumber() {
	        return phoneNumber;
	    }

	    public String getPaidOrFreeGroup() {
	        return paidOrFreeGroup;
	    }

	    // setters
	    
	    public Employee setSalary(int salary) {
	        this.salary = salary;
	        return this;
	    }
	    
	    public Employee setEmail(String email) {
	        this.email = email;
	        return this;
	    }

	    public Employee setPost(String post) {
	        this.post = post;
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


	    @Override
	    public String toString(){
	        return "\nFirst name: " + firstName + "\nLast name: " + lastName +
	                "\nBirthday: " + dateOfBirthday + "\nSalary: " + salary +
	                "\nPhone number: " + phoneNumber + "\nPost: " + post +"\n";
	    }

	    @Override
	    public boolean equals (Object obj){

	        return  (firstName == ((Employee) obj).firstName &&
	                lastName == ((Employee) obj).lastName &&
	                phoneNumber == ((Employee) obj).phoneNumber);
	    }
	    
	    public Employee SetSalaryByPost() {
	    
	    	assert (getPost().length() != 0 ): "Enter post to set salary";
	    	
	    	switch(post) {
				case "junior":
					setSalary(800);
					break;
				case "midle":
					setSalary(1200);
					break;
				case "senior":
					setSalary(2000);
					break;
	    	}
	    	
	    	return this;
	    }
	    
	    public Employee increasePost() {
	    	
	    	assert (getPost().length() != 0 ): "You don't have already post!";
	    	
	    	switch(post) {
			
	    	case "junior":
				setPost("midle");
				break;
			case "midle":
				setPost("senior");
				break;
			case "senior":
				setPost("teamlead");
				break;
				
	    	}
	    	
	    	this.SetSalaryByPost();
	   
	    	return this;
	    	
	    }
    
}





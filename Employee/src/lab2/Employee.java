package lab2;

import java.util.*;
import java.time.LocalDate;
import java.util.regex.Matcher;

class Employee{

	public  enum Post {
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
        // getters
    
    public Post getPost() {
    	return post;
    }
    
    public double getSalary() {
    	return salary;
    }
    
    public String getEmail() {
        return email;
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

    public String getPhoneNumber() {
        return phoneNumber;
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


    @Override
    public String toString(){
        return "\nFirst name: " + firstName + "\nLast name: " + lastName +
                "\nBirthday: " + dateOfBirthday + "\nSalary: " + salary +
                "\nPhone number: " + phoneNumber + "\nPost: " + post +"\n";
    }
    

    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((phoneNumber == null) ? 0 : phoneNumber.hashCode());
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
		Employee other = (Employee) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (phoneNumber == null) {
			if (other.phoneNumber != null)
				return false;
		} else if (!phoneNumber.equals(other.phoneNumber))
			return false;
		return true;
	}
    
    
    // set salary by post   
    
    public Employee setSalaryByPost() {
    	//assert (post != null): "Enter post to set salary";
    	
    	switch(post) {
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
    
    //    update post to next level
    
    public Employee increasePost() {
    	
    	assert (post != null): "You don't have already post!";
    	
    	switch(post) {
		
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
    
    
}

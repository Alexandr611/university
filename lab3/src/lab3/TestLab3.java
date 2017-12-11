package lab3;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import static org.testng.Assert.assertEquals;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import lab3.Employee;


public class TestLab3 {


	@Test
	public void CheckInputedData() {
		Employee e1 = new Employee.Builder("Alex","Malinovsky").setEmail("alexandr@gmail.com").setPhone("+380951474136").createEmployee();
		
		
	    try {
			AssertJUnit.assertEquals(e1.getLastName(), "Mal232inovsky");
			
	    }catch(java.lang.AssertionError e) {
	    	System.out.println(e);
	    }
	    try {
	    	AssertJUnit.assertEquals(e1.getPhoneNumber(), "+3801231951474136");
			
	    }catch(java.lang.AssertionError e) {
	    	System.out.println(e);
	    }
	    try {
	    	AssertJUnit.assertEquals(e1.getEmail(), "alexa123ndr@23awdawd23gm2ail.com");
			
	    }catch(java.lang.AssertionError e) {
	    	System.out.println(e);
	    }
	    try {
	    	AssertJUnit.assertEquals(e1.getFirstName(), "Al123ex");
			
	    }catch(java.lang.AssertionError e) {
	    	System.out.println(e);
	    }
		
		Employee e2 = new Employee.Builder("Mike","Ivasovsky").setEmail("IVasovsk@gmail.com").setPhone("+380952274136").createEmployee();
		
		try {
			AssertJUnit.assertEquals(e2.getLastName(), "Ivasovsky");
			
	    }catch(java.lang.AssertionError e) {
	    	System.out.println(e);
	    }
	    try {
	    	AssertJUnit.assertEquals(e2.getPhoneNumber(), "+380952274136");
			
	    }catch(java.lang.AssertionError e) {
	    	System.out.println(e);
	    }
	    try {
	    	AssertJUnit.assertEquals(e2.getEmail(), "IVasovsky@gmail.com");
			
	    }catch(java.lang.AssertionError e) {
	    	System.out.println(e);
	    }
	    try {
	    	AssertJUnit.assertEquals(e2.getFirstName(), "Mike");
			
	    }catch(java.lang.AssertionError e) {
	    	System.out.println(e);
	    }
	}
	
}

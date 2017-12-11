package lab2;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import static org.testng.Assert.assertEquals;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import lab2.Employee;


public class TestEmployee {

	@Test(dataProvider = "updatePostProvider")
	public void updatePostTest(Employee e1,Employee.Post res) {
		AssertJUnit.assertEquals(e1.increasePost().getPost(), res);
	}

	@DataProvider
	public Object updatePostProvider() {
		Employee e1 = new Employee();
        e1.setFirstName("John").setLastName("Johnson").
	        setDateOfBirthday(1993, 5, 13).
	        setPost(Employee.Post.JUNIOR).setPhoneNumber("587774632");
        Employee e2 = new Employee();
        e2.setFirstName("Drake").setLastName("Standwood").
	        setDateOfBirthday(1993, 5, 13).
	        setPost(Employee.Post.MIDLE).setPhoneNumber("587774632");
        Employee e3 = new Employee();
        e3.setFirstName("July").setLastName("Morgan").
	        setDateOfBirthday(1993, 5, 13).
	        setPost(Employee.Post.SENIOR).setPhoneNumber("587774632");
		return new Object[][] { {e1,Employee.Post.MIDLE } ,{e2,Employee.Post.SENIOR} , {e3 , Employee.Post.TEAMLEAD} };
	}
	
	
	
	@Test(dataProvider = "updateSalaryByPostProvider")
	public void updateSalaryByPostTest(Employee e1,double res) {
		AssertJUnit.assertEquals(e1.getSalary(), res);
	}

	@DataProvider
	public Object updateSalaryByPostProvider() {
		Employee e1 = new Employee();
        e1.setFirstName("John").setLastName("Johnson").
	        setDateOfBirthday(1998, 5, 13).
	        setPost(Employee.Post.JUNIOR).setPhoneNumber("587774632");
        Employee e2 = new Employee();
        e2.setFirstName("Drake").setLastName("Standwood").
	        setDateOfBirthday(1993, 3, 3).
	        setPost(Employee.Post.MIDLE).setSalary(2100).setPhoneNumber("587774632");
        Employee E2 = new Employee();
        E2.setFirstName("Drake").setLastName("Standwood").
        setDateOfBirthday(1993, 3, 3).
        setPost(Employee.Post.MIDLE).setPhoneNumber("587774632");
        Employee e3 = new Employee();
        e3.setFirstName("July").setLastName("Morgan").
	        setDateOfBirthday(1988, 6, 22).
	        setPost(Employee.Post.SENIOR).setPhoneNumber("587774632");
		return new Object[][] { {e1,800 } ,{e2.increasePost(), 2100} ,{E2, 1200} , {e3 , 2000} };
	}
	
}

package lab2;

public class Main {
	public static void main(String[] args) {

        // ----------------------------------------------

        Employee s1 = new Employee();
        s1.setFirstName("Georg").setLastName("Bush").
                setDateOfBirthday(1993, 5, 13).
                setPost(Employee.Post.SENIOR).setPhoneNumber("587774632").setSalaryByPost();

        Employee s2 = new Employee();
        s2.setFirstName("Kim").setLastName("Cach").
                setDateOfBirthday(19976, 2, 21).
                setPost(Employee.Post.JUNIOR).setPhoneNumber("58574892").setSalaryByPost();

        Employee s3 = new Employee();
        s3.setFirstName("Alex").setLastName("Midleton").
                setDateOfBirthday(1989, 5, 3).
                setPost(Employee.Post.JUNIOR).setPhoneNumber("46634442");

        Employee s4 = new Employee();
        s4.setFirstName("Joe").setLastName("Clark").
                setDateOfBirthday(1979, 5, 22).
                setPost(Employee.Post.MIDLE).setPhoneNumber("46444442");

        Employee s5 = new Employee();
        s5.setFirstName("Mark").setLastName("Cooper").
                setDateOfBirthday(1990, 2, 3).
                setPost(Employee.Post.JUNIOR).setPhoneNumber("45534442");

        Employee s6 = new Employee();
        s6.setFirstName("Kelly").setLastName("Tyler").
                setDateOfBirthday(1985, 4, 7).
                setPost(Employee.Post.JUNIOR).setPhoneNumber("46634442");

        s1.increasePost();
        System.out.println(s1.toString());
        // -----------------------------------------------
    }
}

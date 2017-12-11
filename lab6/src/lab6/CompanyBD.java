package lab6;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.TreeSet;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class CompanyBD {
	private static Connection con = null;
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Properties properties = PropertyManager.getProperties();
        String url = properties.getProperty("jdbc.url");
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = (Connection) DriverManager.getConnection(url, properties);
		return connection;
	}

	public static void SetCompanyDB() throws ClassNotFoundException, SQLException {
		Connection conn = getConnection();
		createComanyTable(conn);
		createEmployeeTable(conn);
		conn.close();
	}
	
	public static void createComanyTable(Connection con)  throws SQLException  {
		Statement s =  (Statement) con.createStatement();
		s.executeUpdate("CREATE TABLE IF NOT EXISTS company(\r\n" + 
				"	id INTEGER PRIMARY KEY AUTO_INCREMENT NOT NULL,\r\n" + 
				"	name VARCHAR(80) NOT NULL UNIQUE\r\n" + 
				"	\r\n" + 
				")");
	}
	
	public static void createEmployeeTable(Connection con) throws SQLException{
		Statement s = (Statement) con.createStatement();
		s.executeUpdate("CREATE TABLE IF NOT EXISTS employee (\r\n" + 
				"	id int PRIMARY KEY AUTO_INCREMENT NOT NULL,\r\n" + 
				"   company_id int,\r\n " +
				"	firstName VARCHAR(50),\r\n" + 
				"	lastName VARCHAR(50),\r\n" + 
				"	post ENUM(\"JUNIOR\",\"MIDLE\",\"SENIOR\",\"TEAMLEAD\"),\r\n" + 
				"	phoneNumber VARCHAR(20),\r\n" + 
				"	salary REAL,\r\n" + 
				"	email VARCHAR(50) UNIQUE ,\r\n" + 
				"   FOREIGN KEY(company_id) REFERENCES company(id)\n" +
				")");
		
	}

	public static void addCompany(Company c) throws ClassNotFoundException, SQLException {
		Connection con = getConnection();
		PreparedStatement pstm = (PreparedStatement) con.prepareStatement("INSERT INTO company(name) VALUES(?);");
		
		pstm.setString(1, c.getName());
		pstm.executeUpdate();
		PreparedStatement pst = (PreparedStatement) con.prepareStatement("SELECT id FROM company WHERE name=?;");
		
		pst.setString(1, c.getName());
		ResultSet rs = pst.executeQuery();
	    rs.next();
	    
	    int Id = rs.getInt("id");
        c.setId(Id);
        for (Employee e: c.employees) {
            addEmployee(e, Id);
        }
	    
		con.close();
	}
	
	public static Company getCompanyWithEmployee(int id) throws SQLException, ClassNotFoundException {
		Connection con = getConnection();
		PreparedStatement pstm = (PreparedStatement) con.prepareStatement("SELECT * FROM company c WHERE c.id =?;");
		pstm.setInt(1, id);
		ResultSet res = pstm.executeQuery();
		res.next();
		Company c = new Company();
		c.setId(res.getInt("id")); c.setName(res.getString("name"));
		TreeSet<Employee> E = new CompanyBD().findEmployeesByCompany(c);
		c.setEmployees(E);
		con.close();
		return c;
	}
	
	public static Company getCompany(int id) throws SQLException, ClassNotFoundException {
		Connection con = getConnection();
		PreparedStatement pstm = (PreparedStatement) con.prepareStatement("SELECT * FROM company c WHERE c.id =?;");
		pstm.setInt(1, id);
		ResultSet res = pstm.executeQuery();
		res.next();
		Company c = new Company();
		c.setId(res.getInt("id")); c.setName(res.getString("name"));
		con.close();
		return c;
	}
	
	public static Employee getEmployee(int id) throws SQLException, ClassNotFoundException {
		Connection con = getConnection();
		PreparedStatement pstm = (PreparedStatement) con.prepareStatement("SELECT * FROM employee e WHERE e.id=?;");
		pstm.setInt(1, id);
		ResultSet result = pstm.executeQuery();
		result.next();
		Employee e = new Employee.Builder(result.getString("firstName"),
				result.getString("lastName")).setEmail(result.getString("email"))
				.setPhone(result.getString("phoneNumber")).createEmployee()
				.setSalary(result.getDouble("salary")).setId(result.getInt("id"));
		con.close();
		return e;
	}
	
	public static void addEmployee(Employee e,int id) throws SQLException, ClassNotFoundException {
		Connection con = getConnection();
		PreparedStatement pstm = (PreparedStatement) con.prepareStatement("INSERT INTO employee(firstName,lastName,email,phoneNumber,salary,company_id) VALUES(?,?,?,?,?,?);");
		pstm.setString(1, e.getFirstName());
		pstm.setString(2, e.getLastName());
		pstm.setString(3, e.getEmail());
		pstm.setString(4, e.getEmail());
		pstm.setString(5, e.getPhoneNumber());
		pstm.setDouble(6, e.getSalary());
		pstm.executeUpdate();
		PreparedStatement pst = (PreparedStatement) con.prepareStatement("SELECT id FROM employee WHERE email=?;");
		pst.setString(1, e.getEmail());
		ResultSet result = pst.executeQuery();
		result.next();
		int Id = result.getInt("id");
		e.setId(Id);
		con.close();
	}

    public static void deleteEmployee(int id) throws SQLException, ClassNotFoundException, IllegalArgumentException {
        Connection conn = getConnection();
        PreparedStatement pst = (PreparedStatement) conn.prepareStatement("DELETE FROM employee WHERE id=?;");
        pst.setInt(1, id);
        int rs = pst.executeUpdate();
        conn.close();
    }
    
    public static void deleteCompanyWithEmployees(int id) throws SQLException, ClassNotFoundException {
        Connection conn = getConnection();
        PreparedStatement pstm = (PreparedStatement) conn.prepareStatement("DELETE FROM employee WHERE compamy_id=?;");
        pstm.setInt(1, id);
        pstm.executeUpdate();
        PreparedStatement pst = (PreparedStatement) conn.prepareStatement("DELETE FROM company WHERE id=?;");
        pst.setInt(1, id);
        int rs = pst.executeUpdate();
       
        conn.close();
    }
    
    public static void updateCompany(String newValue,int id) throws ClassNotFoundException, SQLException {
    	Connection con = getConnection();
    	PreparedStatement pstm = (PreparedStatement) con.prepareStatement("Update company SET name=? WHERE id=?;");
    	pstm.setString(1, newValue);
    	pstm.setInt(2, id);
    	pstm.executeUpdate();
    	con.close();
    }
    
    public static void updateEmployeeField(String employeeField,String newValue,int id) throws ClassNotFoundException, SQLException {
    	Connection con = getConnection();
    	PreparedStatement pstm = (PreparedStatement) con.prepareStatement("UPDATE employee e SET ?=? WHERE e.id=?;");
    	pstm.setString(1, employeeField);
    	pstm.setString(2, newValue);
    	pstm.setInt(3, id);
    	pstm.executeUpdate();
    	con.close();
    }

    private static void drop() throws SQLException, ClassNotFoundException {
        Connection conn = getConnection();
        Statement st = (Statement) conn.createStatement();
        st.executeUpdate("DROP TABLE IF EXISTS employee;");
        st.executeUpdate("DROP TABLE IF EXISTS company;");
        conn.close();
    }
	
    public static TreeSet<Employee> findEmployeesByCompany(Company c) throws ClassNotFoundException, SQLException {
    	Connection con = getConnection();
    	PreparedStatement pstm = (PreparedStatement) con.prepareStatement("SELECT e.* FROM company c INNER JOIN employee e ON e.company_id=?;");
    	pstm.setInt(1, c.getId());
    	ResultSet result = pstm.executeQuery();
    	TreeSet<Employee> E = new TreeSet<>();
    	while(result.next()) {
    		E.add(new Employee.Builder(result.getString("firstName"), result.getString("lastName")).setEmail(result.getString("email"))
    				.setPhone(result.getString("phoneNumber")).createEmployee().setSalary(result.getDouble("salary")).setId(result.getInt("id")));
    	}
    	con.close();
    	return E;
    }
}

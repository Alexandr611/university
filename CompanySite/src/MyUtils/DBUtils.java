package MyUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

import javax.servlet.http.HttpServletRequest;

import com.mysql.jdbc.Statement;

import Company.Company;
import Company.Employee;
import Company.MySqlConnector;
import Company.UserAccount;

public class DBUtils {

	public static UserAccount findUser(Connection conn, //
			String userName, String password) throws SQLException {

		String sql = "SELECT a.USER_NAME, a.PASSWORD, a.Gender FROM USER_ACCOUNT a "
				+ " WHERE a.User_Name = ? AND a.password= ?";

		PreparedStatement pstm = conn.prepareStatement(sql);

		pstm.setString(1, userName);
		pstm.setString(2, password);
		ResultSet rs = pstm.executeQuery();

		if (rs.next()) {

			String gender = rs.getString("Gender");
			UserAccount user = new UserAccount();
			user.setUserName(userName);
			user.setPassword(password);
			user.setGender(gender);
			return user;
		}
		return null;
	}

	public static UserAccount findUser(Connection conn, String userName) throws SQLException {

		String sql = "Select a.User_Name, a.Password, a.Gender from User_Account a "//
				+ " where a.User_Name = ? ";

		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, userName);

		ResultSet rs = pstm.executeQuery();

		if (rs.next()) {
			String password = rs.getString("Password");
			String gender = rs.getString("Gender");
			UserAccount user = new UserAccount();
			user.setUserName(userName);
			user.setPassword(password);
			user.setGender(gender);
			return user;
		}
		return null;
	}

	public static TreeSet<Company> queryCompany(Connection conn) throws SQLException {
		String sql = "SELECT c.id , c.Name FROM Company c ";

		PreparedStatement pstm = conn.prepareStatement(sql);

		ResultSet rs = pstm.executeQuery();
		TreeSet<Company> list = new TreeSet<Company>();
		while (rs.next()) {
			String name = rs.getString("name");
			int id = rs.getInt("id");
			Company company = new Company();
			company.setName(name);
			company.setId(id);
			;
			list.add(company);
		}
		return list;
	}

	public static Company findCompany(Connection conn, String code) throws SQLException {
		String sql = "SELECT c.id, c.name FROM Company c WHERE c.name='%?%'";

		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, code);

		ResultSet rs = pstm.executeQuery();

		while (rs.next()) {
			String name = rs.getString("Name");
			int id = rs.getInt("id");
			Company company = new Company();
			company.setId(id);
			company.setName(name);
			return company;
		}
		return null;
	}

	public static void updateProduct(Connection conn, Company company) throws SQLException {
		String sql = "UPDATE Company SET name =? WHERE id=? ";

		PreparedStatement pstm = conn.prepareStatement(sql);

		pstm.setString(1, company.getName());
		pstm.executeUpdate();
	}

	public static void insertProduct(Connection conn, Company company) throws SQLException {
		String sql = "INSERT INTO Company(name) VALUES (?)";

		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, company.getName());

		pstm.executeUpdate();
	}

	public static void deleteProduct(Connection conn, int id) throws SQLException {
		String sql = "Delete From Product where id= ?";

		PreparedStatement pstm = conn.prepareStatement(sql);

		pstm.setInt(1, id);

		pstm.executeUpdate();
	}

	public List<Company> queryCompany() throws SQLException, ClassNotFoundException {
		Connection conn = MySqlConnector.getConnection();
		String sql = "SELECT c.id , c.Name FROM Company c ";

		PreparedStatement pstm = conn.prepareStatement(sql);

		ResultSet rs = pstm.executeQuery();
		List<Company> list = new ArrayList<Company>();
		while (rs.next()) {
			String name = rs.getString("name");
			int id = rs.getInt("id");
			Company company = new Company();
			company.setName(name);
			company.setId(id);

			list.add(company);
		}
		conn.close();
		return list;
	}

	public TreeSet<Employee> queryCompanyEmployees(int CompanyId) throws SQLException, ClassNotFoundException {
		Connection conn = MySqlConnector.getConnection();
		String sql = "SELECT e.* FROM employee e WHERE e.company_id = ?  ";

		PreparedStatement pstm = conn.prepareStatement(sql);

		pstm.setInt(1, CompanyId);

		ResultSet rs = pstm.executeQuery();
		TreeSet<Employee> list = new TreeSet<Employee>();
		while (rs.next()) {
			Employee e = new Employee.Builder(rs.getString("firstName"), rs.getString("lastName"))
					.setEmail(rs.getString("email")).setPhone(rs.getString("phoneNumber")).createEmployee()
					.setSalary(rs.getDouble("salary")).setId(rs.getInt("id")).setPostString(rs.getString("post"));
			list.add(e);
		}
		conn.close();
		return list;
	}

	public static void insertCompany(Company company) throws SQLException, ClassNotFoundException {
		Connection conn = MySqlConnector.getConnection();
		String sql = "INSERT INTO Company(name) VALUES (?)";

		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, company.getName());

		pstm.executeUpdate();
		conn.close();
	}

	public static Employee insertEmployee(Employee employee, int id) throws SQLException, ClassNotFoundException {
		Connection conn = MySqlConnector.getConnection();
		String sql = "INSERT INTO employee(firstName,lastName,email,phoneNumber,salary,company_id,post) VALUES(?,?,?,?,?,?,?);";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, employee.getFirstName());
		pstm.setString(2, employee.getLastName());
		pstm.setString(3, employee.getEmail());
		pstm.setString(4, employee.getPhoneNumber());
		pstm.setDouble(5, employee.getSalary());
		pstm.setInt(6, id);
		pstm.setString(7, employee.getPostString());
		pstm.executeUpdate();
		conn.close();
		return employee;
	}

	public static void deleteEmptyCompany(int id) throws ClassNotFoundException, SQLException {
		Connection conn = MySqlConnector.getConnection();
		String sql = "DELETE FROM company WHERE id= ?";

		PreparedStatement pstm = conn.prepareStatement(sql);

		pstm.setInt(1, id);

		pstm.executeUpdate();
	}

	public static void deleteEmployee(int id) throws ClassNotFoundException, SQLException {
		Connection conn = MySqlConnector.getConnection();
		String sql = "DELETE FROM employee WHERE id= ?";

		PreparedStatement pstm = conn.prepareStatement(sql);

		pstm.setInt(1, id);

		pstm.executeUpdate();
	}

	public static Company findCompany(int Id) throws ClassNotFoundException, SQLException {
		Connection conn = MySqlConnector.getConnection();
		String sql = "SELECT c.id, c.name FROM Company c WHERE c.id=?";

		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setInt(1, Id);

		ResultSet rs = pstm.executeQuery();

		while (rs.next()) {
			String name = rs.getString("name");
			int id = rs.getInt("id");
			Company company = new Company();
			company.setId(id);
			company.setName(name);
			conn.close();
			return company;
		}
		return null;
	}

	public static void updateCompany(Company company) throws ClassNotFoundException, SQLException {
		Connection conn = MySqlConnector.getConnection();
		String sql = "UPDATE Company SET name =? WHERE id=? ";

		PreparedStatement pstm = conn.prepareStatement(sql);

		pstm.setString(1, company.getName());
		pstm.setInt(2, company.getId());
		pstm.executeUpdate();
		conn.close();
	}

	public static Employee findEmployee(int Id) throws ClassNotFoundException, SQLException {
		Connection conn = MySqlConnector.getConnection();
		String sql = "SELECT e.* FROM Employee e WHERE e.id=?";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setInt(1, Id);

		ResultSet rs = pstm.executeQuery();

		rs.next();
		Employee employee = new Employee.Builder(rs.getString("firstName"), rs.getString("lastName"))
				.setEmail(rs.getString("email")).setPhone(rs.getString("phoneNumber")).createEmployee()
				.setSalary(rs.getDouble("salary")).setId(rs.getInt("id")).setPostString(rs.getString("post"));
		conn.close();

		return employee;

	}

	public static void updateEmployee(HttpServletRequest request, Employee employee)
			throws ClassNotFoundException, SQLException {
		Connection conn = MySqlConnector.getConnection();
		String sql = "UPDATE employee SET firstName = ? , lastName = ? ,post = ? , email = ? , phoneNumber = ? , salary = ? WHERE id=? ";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, employee.getFirstName());
		pstm.setString(2, employee.getLastName());
		pstm.setString(3, employee.getPostString());
		pstm.setString(4, employee.getEmail());
		pstm.setString(5, employee.getPhoneNumber());
		pstm.setDouble(6, employee.getSalary());
		pstm.setInt(7, Integer.parseInt(request.getParameter("id")));
		pstm.executeUpdate();
		conn.close();
	}

	public UserAccount findUser(String userName, String password) throws ClassNotFoundException, SQLException {

		Connection conn = MySqlConnector.getConnection();

		String sql = "SELECT a.USER_NAME, a.PASSWORD, a.Gender FROM USER_ACCOUNT a "
				+ " WHERE a.User_Name = ? AND a.password= ?";

		PreparedStatement pstm = conn.prepareStatement(sql);

		pstm.setString(1, userName);
		pstm.setString(2, password);
		ResultSet rs = pstm.executeQuery();

		if (rs.next()) {

			String gender = rs.getString("Gender");
			UserAccount user = new UserAccount();
			user.setUserName(userName);
			user.setPassword(password);
			user.setGender(gender);
			return user;
		}
		return null;
	}

	public List<String> findByTag(String searched) throws SQLException, ClassNotFoundException {
		Connection conn = MySqlConnector.getConnection();
		String Sql = "SELECT e.firstName,e.post,c.name,e.lastName,e.email,e.id as employeeId,c.id as companyId\r\n"
				+ "FROM employee e INNER JOIN company c ON c.id = e.company_id\r\n" + "WHERE (e.post LIKE '%" + searched
				+ "%') OR (e.lastName LIKE '%" + searched + "%') \r\n" + "OR (e.firstName LIKE '%" + searched
				+ "%') OR (e.email LIKE '%" + searched + "%') OR (c.name LIKE '%" + searched + "%');";
		Statement pstm = (Statement) conn.createStatement();

		ResultSet rs = pstm.executeQuery(Sql);
		List<String> list = new ArrayList<String>();
		while (rs.next()) {
			String res = "<td><a href='/CompanySite/company?id=" + rs.getString("companyId") + "&mame"
					+ rs.getString("name") + "'>" + rs.getString("name") + "</a></td><td>" + rs.getString("firstName")
					+ "</td><td>" + rs.getString("lastName") + "</td><td>" + rs.getString("post") + "</td>"
					+ "</td><td>" + rs.getString("email") + "</td>";
			list.add(res);
		}
		conn.close();
		return list;
	}
	
public UserAccount createUser(String userName,String password,String gender) throws ClassNotFoundException, SQLException {
    	
    	Connection conn = MySqlConnector.getConnection();
    	
    	String sql = "INSERT INTO user_account (USER_NAME,PASSWORD,GENDER) VALUES (?,?,?);";

		PreparedStatement pstm = conn.prepareStatement(sql);
		
		pstm.setString(1, userName);
		pstm.setString(2, password);
		pstm.setString(3, gender);
		pstm.executeUpdate();
		String sql1 = "SELECT * FROM user_account WHERE user_name =? AND password =? ;";
		
		PreparedStatement pst = conn.prepareStatement(sql1);
		pst.setString(1, userName);
		pst.setString(2, password);
		
		
		ResultSet rs = pst.executeQuery();
	
		if (rs.next()) {
			
			String gend = rs.getString("Gender");
			UserAccount user = new UserAccount();
			user.setUserName(userName);
			user.setPassword(password);
			user.setGender(gend);
			
			conn.close();
			return user;
		}
		
		conn.close();
		return null;
    }

}

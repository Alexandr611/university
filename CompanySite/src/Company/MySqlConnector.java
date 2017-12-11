package Company;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;


public class MySqlConnector {
	private static Connection con = null;
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
//		Properties properties = PropertyManager.getProperties();
//        String url = properties.getProperty("jdbc.url");
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/javadb", "root","");
		return connection;
	}
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Connection con = MySqlConnector.getConnection();
		Statement st = (Statement) con.createStatement();
		ResultSet rs = st.executeQuery("SELECT * FROM USER_ACCOUNT");
		rs.next();
		System.out.println(rs.getString("USER_NAME")+" : "+rs.getString("GENDER"));
	}
}

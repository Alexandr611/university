package Servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Company.Company;
import Company.Employee;
import Company.MySqlConnector;
import MyUtils.MyUtils;
import MyUtils.DBUtils;

@WebServlet(urlPatterns = { "/createEmployee" })
public class CreateEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CreateEmployeeServlet() {
		super();
	}

	// Show product creation page.
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println(request.getParameter("id"));
		request.setAttribute("id", request.getParameter("id"));
		RequestDispatcher dispatcher = request.getServletContext()
				.getRequestDispatcher("/WEB-INF/views/createEmployee.jsp");
		dispatcher.forward(request, response);
	}

	// When the user enters the product information, and click Submit.
	// This method will be called.
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Connection conn = MyUtils.getStoredConnection(request);
		Employee employee = null;
		String errorString = null;
		try {
			employee = new Employee.Builder(request.getParameter("firstName"), request.getParameter("lastName"))
					.setEmail(request.getParameter("email")).setPhone(request.getParameter("phone")).createEmployee()
					.setSalary(Double.parseDouble(request.getParameter("salary")))
					.setId(Integer.parseInt(request.getParameter("id"))).setPostString(request.getParameter("post"));
		} catch (IllegalArgumentException e) {
			errorString = e.getMessage();
		}
		int id = Integer.parseInt(request.getParameter("id"));

		if (errorString == null) {
			try {
				new DBUtils().insertEmployee(employee, id);
			} catch (SQLException | ClassNotFoundException e) {
				e.printStackTrace();
				errorString += e.getMessage();
			}
		}
		request.setAttribute("id",request.getParameter("id"));
		request.setAttribute("errorString", errorString);
		request.setAttribute("employee", employee);

		if (errorString != null) {
			RequestDispatcher dispatcher = request.getServletContext()
					.getRequestDispatcher("/WEB-INF/views/createEmployee.jsp");
			dispatcher.forward(request, response);
		} else {
			response.sendRedirect(request.getContextPath() + "/companyList");
		}
	}

}
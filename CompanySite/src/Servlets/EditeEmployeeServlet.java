package Servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

import Company.Company;

@WebServlet(urlPatterns = { "/editeEmployee" })
public class EditeEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public EditeEmployeeServlet() {
		super();
	}

	// Show product edit page.
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Connection conn = MyUtils.getStoredConnection(request);

		int id = Integer.parseInt(request.getParameter("id"));

		Employee employee = null;

		String errorString = null;

		try {
			employee = new DBUtils().findEmployee(id);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// If no error.
		// The product does not exist to edit.
		// Redirect to productList page.
		if (errorString != null && employee == null) {
			response.sendRedirect(request.getServletPath() + "/companyList");
			return;
		}

		// Store errorString in request attribute, before forward to views.
		request.setAttribute("errorString", errorString);
		request.setAttribute("employee", employee);

		RequestDispatcher dispatcher = request.getServletContext()
				.getRequestDispatcher("/WEB-INF/views/editeEmployee.jsp");
		dispatcher.forward(request, response);

	}

	// After the user modifies the product information, and click Submit.
	// This method will be executed.
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Employee employee = null;
		String errorString = null;
		try {
			employee = new Employee.Builder(request.getParameter("firstName"), request.getParameter("lastName"))
					.setEmail(request.getParameter("email")).setPhone(request.getParameter("phone")).createEmployee()
					.setSalary(Double.parseDouble(request.getParameter("salary")))
					.setId(Integer.parseInt(request.getParameter("id"))).setPostString(request.getParameter("post"));
			new DBUtils().updateEmployee(request,employee);
		} catch (ClassNotFoundException | SQLException  | IllegalArgumentException e) {
			e.printStackTrace();
			errorString = e.getMessage();
		}

		request.setAttribute("errorString", errorString);

		if (errorString != null) {
			RequestDispatcher dispatcher = request.getServletContext()
					.getRequestDispatcher("/WEB-INF/views/editeEmployee.jsp");
			dispatcher.forward(request, response);
		}

		else {
			response.sendRedirect(request.getContextPath() + "/companyList");
		}
	}

}
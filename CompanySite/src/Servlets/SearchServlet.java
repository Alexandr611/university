package Servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Statement;

import Company.Company;
import Company.Employee;
import Company.MySqlConnector;
import MyUtils.MyUtils;
import MyUtils.DBUtils;

@WebServlet(urlPatterns = { "/search" })
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SearchServlet() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Connection conn = MyUtils.getStoredConnection(request);

		String errorString = null;
		List<String> find = null;
		try {
			find = new DBUtils().findByTag(request.getParameter("search"));
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		request.setAttribute("errorString", errorString);
		request.setAttribute("find", find);

		RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/search.jsp");
		dispatcher.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
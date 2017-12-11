package Servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Company.Employee;
import Company.Company;
import Company.MySqlConnector;
import MyUtils.MyUtils;
import MyUtils.DBUtils;

@WebServlet(urlPatterns = { "/company" })
public class CompanyServlet extends HttpServlet {
   private static final long serialVersionUID = 1L;

   public CompanyServlet() {
       super();
   }

   @Override
   protected void doGet(HttpServletRequest request, HttpServletResponse response)
           throws ServletException, IOException {
       Connection conn = MyUtils.getStoredConnection(request);
       int id = Integer.parseInt(request.getParameter("id"));
       String errorString = null;
       Company company = new Company();
       company.setId(id);
       company.setName(request.getParameter("name"));
       try {
		company.setEmployees(new DBUtils().queryCompanyEmployees(id));
	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
       request.setAttribute("id", request.getParameter("id"));
       request.setAttribute("errorString", errorString);
       request.setAttribute("company", company);

       RequestDispatcher dispatcher = request.getServletContext()
               .getRequestDispatcher("/WEB-INF/views/companyEmployeesList.jsp");
       dispatcher.forward(request, response);
       
   }

   @Override
   protected void doPost(HttpServletRequest request, HttpServletResponse response)
           throws ServletException, IOException {
       doGet(request, response);
   }
}
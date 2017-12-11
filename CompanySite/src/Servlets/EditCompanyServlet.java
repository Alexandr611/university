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
import Company.MySqlConnector;
import MyUtils.MyUtils;
import MyUtils.DBUtils;

import Company.Company;
 
@WebServlet(urlPatterns = { "/editCompany" })
public class EditCompanyServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
 
    public EditCompanyServlet() {
        super();
    }
 
    // Show product edit page.
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Connection conn = MyUtils.getStoredConnection(request);
 
        int id =   Integer.parseInt(request.getParameter("id"));
 
        Company company = null;
 
        String errorString = null;
 
        try {
			company = new DBUtils().findCompany(id);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 
        // If no error.
        // The product does not exist to edit.
        // Redirect to productList page.
        if (errorString != null && company == null) {
            response.sendRedirect(request.getServletPath() + "/companyList");
            return;
        }
 
        // Store errorString in request attribute, before forward to views.
        request.setAttribute("errorString", errorString);
        request.setAttribute("company", company);
 
        RequestDispatcher dispatcher = request.getServletContext()
                .getRequestDispatcher("/WEB-INF/views/editCompany.jsp");
        dispatcher.forward(request, response);
 
    }
 
    // After the user modifies the product information, and click Submit.
    // This method will be executed.
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = (String) request.getParameter("name");
        int id = Integer.parseInt(request.getParameter("id"));
        Company company = new Company();
        company.setName(name); company.setId(id);
     
        String errorString = null;
        try {
			new DBUtils().updateCompany(company);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
      
        request.setAttribute("errorString", errorString);
        request.setAttribute("company", company);
    
        if (errorString != null) {
            RequestDispatcher dispatcher = request.getServletContext()
                    .getRequestDispatcher("/WEB-INF/views/editCompany.jsp");
            dispatcher.forward(request, response);
        }
     
        else {
            response.sendRedirect(request.getContextPath() + "/companyList");
        }
    }
 
}
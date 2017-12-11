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

import Company.MySqlConnector;
import MyUtils.MyUtils;
import MyUtils.DBUtils;
 
@WebServlet(urlPatterns = { "/deleteEmployee" })
public class DeleteEmployeeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
 
    public DeleteEmployeeServlet() {
        super();
    }
 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Connection conn = MyUtils.getStoredConnection(request);
 
        int id = Integer.parseInt(request.getParameter("id"));
 
        String errorString = null;
 
        try {
            new DBUtils().deleteEmployee(id);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            errorString = e.getMessage();
        } 
         
       
        if (errorString != null) {
       
            request.setAttribute("errorString", errorString);

            RequestDispatcher dispatcher = request.getServletContext()
                    .getRequestDispatcher("/WEB-INF/views/deleteEmployeeError.jsp");
            dispatcher.forward(request, response);
        }
     
        else {
            response.sendRedirect(request.getContextPath() + "/companyList");
        }
 
    }
 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
    
}

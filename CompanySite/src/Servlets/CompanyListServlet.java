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

import Company.Company;
import Company.MySqlConnector;
import MyUtils.MyUtils;
import MyUtils.DBUtils;

@WebServlet(urlPatterns = { "/companyList" })
public class CompanyListServlet extends HttpServlet {
   private static final long serialVersionUID = 1L;

   public CompanyListServlet() {
       super();
   }

   @Override
   protected void doGet(HttpServletRequest request, HttpServletResponse response)
           throws ServletException, IOException {
       Connection conn = MyUtils.getStoredConnection(request);

       String errorString = null;
       List<Company> list = null;
       try {
           list = new DBUtils().queryCompany();
       } catch (SQLException | ClassNotFoundException e) {
           e.printStackTrace();
           errorString = e.getMessage();
       }
       request.setAttribute("errorString", errorString);
       request.setAttribute("companyList", list);

       RequestDispatcher dispatcher = request.getServletContext()
               .getRequestDispatcher("/WEB-INF/views/companyList.jsp");
       dispatcher.forward(request, response);
   }

   @Override
   protected void doPost(HttpServletRequest request, HttpServletResponse response)
           throws ServletException, IOException {
       doGet(request, response);
   }
}
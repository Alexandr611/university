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
import javax.servlet.http.HttpSession;

import Company.MySqlConnector;
import Company.UserAccount;
import MyUtils.DBUtils;
import MyUtils.MyUtils;
 
@WebServlet(urlPatterns = { "/signUp" })
public class SignUpServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
 
    public SignUpServlet() {
        super();
    }
 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
        
        RequestDispatcher dispatcher //
                = this.getServletContext().getRequestDispatcher("/WEB-INF/views/signUp.jsp");
 
        dispatcher.forward(request, response);
 
    }
 
    // When the user enters userName & password, and click Submit.
    // This method will be executed.
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String userName = request.getParameter("userName");
        String gender = request.getParameter("gender");
        String password = request.getParameter("password");
        String repassword = request.getParameter("repassword");
        String rememberMeStr = request.getParameter("rememberMe");
        boolean remember = "Y".equals(rememberMeStr);
 
        UserAccount user = null;
        boolean hasError = false;
        String errorString = null;
        System.out.println(password != repassword);
        if (userName == null || password == null || userName.length() == 0 || password.length() == 0) {
            hasError = true;
            errorString = "Required username and password!";
        } else {
            Connection conn = MyUtils.getStoredConnection(request);
            try {
                // Find the user in the DB.
                user = new DBUtils().createUser(userName,password,gender);
 
                if (user == null) {
                    hasError = true;
                    errorString = "User Name or password invalid";
                }
            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
                hasError = true;
                errorString = e.getMessage();
            }
        }
        if (hasError) {
            user = new UserAccount();
            user.setUserName(userName);
            user.setPassword(password);
 
            request.setAttribute("errorString", errorString);
            request.setAttribute("user", user);
 
            RequestDispatcher dispatcher 
                    = this.getServletContext().getRequestDispatcher("/WEB-INF/views/signUp.jsp");
 
            dispatcher.forward(request, response);
        }
        else {
            HttpSession session = request.getSession();
            MyUtils.storeLoginedUser(session, user);
 
            if (remember) {
                MyUtils.storeUserCookie(response, user);
            }
            else {
                MyUtils.deleteUserCookie(response);
            }
 
            response.sendRedirect(request.getContextPath() + "/userInfo");
        }
    }
 
}
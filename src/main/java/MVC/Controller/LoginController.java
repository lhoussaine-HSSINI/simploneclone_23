package MVC.Controller;

import MVC.Dao_op.loginDao;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "LoginController", value = "/LoginController")
public class LoginController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        loginDao  loginDao=new loginDao();
        if(loginDao.insertAdmin(username,password))
        {
            System.out.println("mzyan alhousin");
            RequestDispatcher dispatcher = request.getRequestDispatcher("Dashboarda.jsp");
            dispatcher.forward(request, response);
        } else if (loginDao.inserformateur(username,password)) {
            System.out.println("mzyan alhousin");
            RequestDispatcher dispatcher = request.getRequestDispatcher("Homef.jsp");
            dispatcher.forward(request, response);

        } else {
            System.out.println("nnnn alhousin");
            RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
            dispatcher.forward(request, response);
        }

    }
}

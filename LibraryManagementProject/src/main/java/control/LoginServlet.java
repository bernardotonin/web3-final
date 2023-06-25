package control;

import domain.entities.User;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import service.BookService;
import service.UserService;

import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {

    private UserService us;
    private BookService bs;

    public LoginServlet(){
        this.us = new UserService();
        this.bs = new BookService();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (UserService.checkSession(request) == null){
            request.getRequestDispatcher("/").forward(request, response);
        }
        request.setAttribute("data", bs.readAll());
        request.getRequestDispatcher("list-books.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(us.validateLogin(request.getParameter("username"), request.getParameter("password")) != null){
            request.setAttribute("currentUser", us.validateLogin(request.getParameter("username"), request.getParameter("password")));
            request.setAttribute("data", bs.readAll());
            request.setAttribute("ErrorMsg", null);
            us.createSession(request, us.validateLogin(request.getParameter("username"), request.getParameter("password")));
            request.getRequestDispatcher("list-books.jsp").forward(request, response);
        }else{
            request.setAttribute("ErrorMsg", 1);
            request.getRequestDispatcher("/").forward(request, response);
        }
    }
}

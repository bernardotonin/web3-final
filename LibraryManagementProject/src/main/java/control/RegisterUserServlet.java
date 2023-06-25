package control;

import domain.entities.User;
import domain.enums.UserType;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import service.BookService;
import service.UserService;

import java.io.IOException;

@WebServlet(name = "RegisterUser", value = "/registeruser")
public class RegisterUserServlet extends HttpServlet {
    private UserService us;
    private BookService bs;

    public RegisterUserServlet(){
        this.us = new UserService();
        this.bs = new BookService();

    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (UserService.checkSession(request) == null){
            request.getRequestDispatcher("/").forward(request, response);
        }
        request.getRequestDispatcher("register-user.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User u = new User();
        u.setUsername(request.getParameter("username"));
        u.setPassword(request.getParameter("password"));
        u.setName(request.getParameter("name"));

        if(request.getParameter("admincheckbox") != null){
            u.setType(UserType.ADMINISTRATOR);
        }else{
            u.setType(UserType.CONSUMER);
        }
        us.create(u);
        request.setAttribute("data", us.readAll());
        request.getRequestDispatcher("list-users.jsp").forward(request, response);

    }
}

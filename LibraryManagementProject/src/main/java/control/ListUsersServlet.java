package control;

import domain.entities.User;
import domain.enums.UserType;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import service.BookService;
import service.UserService;

import java.io.IOException;

@WebServlet(name = "ListUsersServlet", value = "/listusers")
public class ListUsersServlet extends HttpServlet {
    private UserService us;
    private BookService bs;
    public ListUsersServlet(){
        this.us = new UserService();
        this.bs = new BookService();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (UserService.checkSession(request) == null){
            request.getRequestDispatcher("/").forward(request, response);
        }
        User currentUser = (User) request.getSession().getAttribute("user");
        if (currentUser.getType() == UserType.ADMINISTRATOR){
            request.setAttribute("data", us.readAll());
            request.getRequestDispatcher("list-users.jsp").forward(request, response);
        }else{
            request.setAttribute("data", bs.readAll());
            request.getRequestDispatcher("/listbooks").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

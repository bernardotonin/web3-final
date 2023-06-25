package control;

import domain.entities.User;
import domain.enums.UserType;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import service.UserService;

import java.io.IOException;

@WebServlet(name = "UpdateUserServlet", value = "/updateuser")
public class UpdateUserServlet extends HttpServlet {
    private UserService us;

    public UpdateUserServlet(){
        this.us = new UserService();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (UserService.checkSession(request) == null){
            request.getRequestDispatcher("/").forward(request, response);
        }
        request.setAttribute("user", us.readById(Integer.parseInt(request.getParameter("user_id"))));
        request.getRequestDispatcher("update-user.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User u = new User();
        u.setId(Integer.parseInt(request.getParameter("user_id")));
        u.setUsername(request.getParameter("username"));
        u.setPassword(request.getParameter("password"));
        u.setName(request.getParameter("name"));

        if(request.getParameter("admincheckbox") != null){
            u.setType(UserType.ADMINISTRATOR);
        }else{
            u.setType(UserType.CONSUMER);
        }
        us.update(u);
        request.setAttribute("data", us.readAll());
        request.getRequestDispatcher("list-users.jsp").forward(request, response);
    }
}

package control;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import service.UserService;

import java.io.IOException;

@WebServlet(name = "DeleteUserServlet", value = "/deleteuser")
public class DeleteUserServlet extends HttpServlet {
    private UserService us;
    public DeleteUserServlet(){
        this.us = new UserService();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (UserService.checkSession(request) == null){
            request.getRequestDispatcher("/").forward(request, response);
        }

        us.delete(us.readById(Integer.parseInt(request.getParameter("user_id"))));
        request.setAttribute("data", us.readAll());
        request.getRequestDispatcher("list-users.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

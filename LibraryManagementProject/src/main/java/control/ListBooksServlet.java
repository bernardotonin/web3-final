package control;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import service.BookService;
import service.UserService;

import java.io.IOException;

@WebServlet(name = "ListBooksServlet", value = "/listbooks")
public class ListBooksServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (UserService.checkSession(request) == null){
            request.getRequestDispatcher("/").forward(request, response);
        }
        request.getRequestDispatcher("list-books.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (UserService.checkSession(request) == null){
            request.getRequestDispatcher("/").forward(request, response);
        }
        request.getRequestDispatcher("list-books.jsp").forward(request, response);
    }
}

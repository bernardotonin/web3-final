package control;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import service.BookService;
import service.UserService;

import java.io.IOException;

@WebServlet(name = "DeleteBookServlet", value = "/deletebook")
public class DeleteBookServlet extends HttpServlet {
    private BookService bs;
    public DeleteBookServlet(){
        this.bs = new BookService();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (UserService.checkSession(request) == null){
            request.getRequestDispatcher("/").forward(request, response);
        }
        bs.delete(bs.readById(Integer.parseInt(request.getParameter("book_id"))));
        request.setAttribute("data", bs.readAll());
        request.getRequestDispatcher("/listbooks").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("data", bs.readAll());
        request.getRequestDispatcher("/listbooks").forward(request, response);
    }
}

package control;

import domain.entities.Book;
import domain.entities.User;
import domain.enums.BookStatus;
import domain.enums.UserType;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import service.BookService;
import service.UserService;

import java.io.IOException;

@WebServlet(name = "RegisterBook", value = "/registerbook")
public class RegisterBookServlet extends HttpServlet {
    private BookService bs;
    private UserService us;

    public RegisterBookServlet(){
        this.bs = new BookService();
        this.us = new UserService();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (UserService.checkSession(request) == null){
            request.getRequestDispatcher("/").forward(request, response);
        }
        User currentUser = (User) request.getSession().getAttribute("user");
        if (currentUser.getType() != UserType.ADMINISTRATOR){
            request.setAttribute("data", bs.readAll());
            request.getRequestDispatcher("/listbooks").forward(request, response);
        }
         request.getRequestDispatcher("register-book.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Book b = new Book();
        b.setName(request.getParameter("book_name"));
        b.setAuthor(request.getParameter("author_name"));
        // radio not checked validation
        if(request.getParameter("book_status") == null){
            request.setAttribute("data", bs.readAll());
            request.getRequestDispatcher("/listbooks").forward(request, response);
        }

        if(request.getParameter("book_status").equals("available")){
            b.setStatus(BookStatus.AVAILABLE);
        }
        if(request.getParameter("book_status").equals("unavailable")){
            b.setStatus(BookStatus.UNAVAILABLE);
        }
        if(request.getParameter("book_status").equals("rented")){
            b.setStatus(BookStatus.RENTED);
        }

        bs.create(b);
        request.setAttribute("data", bs.readAll());
        request.getRequestDispatcher("/listbooks").forward(request, response);
    }
}

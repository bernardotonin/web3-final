package control;

import domain.entities.Book;
import domain.enums.BookStatus;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import service.BookService;
import service.UserService;

import java.io.IOException;
import java.sql.Date;

@WebServlet(name = "UpdateBookServlet", value = "/updatebook")
public class UpdateBookServlet extends HttpServlet {
    private BookService bs;

    public UpdateBookServlet(){
        this.bs = new BookService();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (UserService.checkSession(request) == null){
            request.getRequestDispatcher("/").forward(request, response);
        }
        Book b = bs.readById(Integer.parseInt(request.getParameter("book_id")));
        request.setAttribute("book", b);
        request.getRequestDispatcher("update-book.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Book b = new Book();
        b.setId(Integer.parseInt(request.getParameter("id_book")));
        b.setName(request.getParameter("book_name"));
        b.setAuthor(request.getParameter("author_name"));

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
        b.setCreation_date(Date.valueOf(request.getParameter("creationdate")));
        bs.update(b);

        request.setAttribute("data", bs.readAll());
        request.getRequestDispatcher("/listbooks").forward(request, response);
    }
}

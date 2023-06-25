package service;

import domain.entities.Book;
import repositories.BookRepository;

import java.util.List;

public class BookService {
    private final BookRepository br;

    public BookService(){
        br = new BookRepository();
    }

    public Book readById(Integer id){
        return br.readById(id);
    }

    public List<Book> readAll(){
        return br.readAll();
    }

    public Book create(Book b){
        return br.create(b);
    }

    public Book update(Book b){
        return br.update(b);
    }

    public void delete(Book b){
        br.delete(b);
    }
}

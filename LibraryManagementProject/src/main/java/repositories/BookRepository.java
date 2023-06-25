package repositories;

import connection.ConnectionFactory;
import domain.entities.Book;
import exception.EntityIsNullException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;

import java.util.List;

public class BookRepository {
    private EntityManager em;

    public BookRepository(){
        this.em = ConnectionFactory.getConnection();
    }

    public Book create(Book b){
        em.getTransaction().begin();
        em.persist(b);
        em.getTransaction().commit();
        return b;
    }

    public Book update(Book b){
        em.getTransaction().begin();
        b = em.merge(b);
        em.getTransaction().commit();
        return b;
    }

    public Book readById(Integer id){
        Book b = em.find(Book.class, id);
        if (b == null){
            throw new EntityNotFoundException("Book not found in the database.");
        }
        return b;
    }

    public List<Book> readAll(){
        return em.createQuery("SELECT b FROM books b", Book.class).getResultList();
    }

    public void delete(Book b){

        if (b == null){
            throw new EntityIsNullException("Book is null");
        }

        b = em.find(Book.class, b.getId());

        if (b == null){
            throw new EntityNotFoundException("Book not found in the database.");
        }
        em.getTransaction().begin();
        em.remove(b);
        em.getTransaction().commit();
    }

}

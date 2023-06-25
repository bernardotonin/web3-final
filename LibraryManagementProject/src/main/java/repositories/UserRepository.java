package repositories;

import connection.ConnectionFactory;
import domain.entities.User;
import exception.EntityIsNullException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.NoResultException;

import java.util.List;

public class UserRepository {
    private EntityManager em;

    public UserRepository(){
        this.em = ConnectionFactory.getConnection();
    }
    public User create(User u){
        em.getTransaction().begin();
        em.persist(u);
        em.getTransaction().commit();
        return u;
    }

    public List<User> readAll(){
       return em.createQuery("select u from users u", User.class).getResultList();
    }

    public User readById(Integer id){
        User u = em.find(User.class, id);
        if (u == null){
            throw new EntityNotFoundException("User not Found in database");
        }
        return u;
    }

    public User readByUsername(String username){
        try {
            return  em.createQuery("SELECT u FROM users u WHERE u.username = :username", User.class)
                    .setParameter("username", username)
                    .getSingleResult();
        }catch (NoResultException e){
            return null;
        }
    }

    public User update(User u){
        em.getTransaction().begin();
        em.merge(u);
        em.getTransaction().commit();
        return u;
    }

    public void delete(User u){
        if (u == null){
            throw new EntityIsNullException("User is null");
        }

        u = em.find(User.class, u.getId());

        if (u == null){
            throw new EntityNotFoundException("User not found in database");
        }

        em.getTransaction().begin();
        em.remove(u);
        em.getTransaction().commit();
    }
}

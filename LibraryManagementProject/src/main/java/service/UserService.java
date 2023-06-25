package service;

import domain.entities.User;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import repositories.UserRepository;

import java.util.List;

public class UserService {
    private UserRepository ur;

    public UserService(){
        this.ur = new UserRepository();
    }
    public Boolean passwordMatch(String formPassword, String userPassword){
        return userPassword.equals(formPassword);
    }

    public User validateLogin(String username, String password){
        User u = ur.readByUsername(username);
        if (u == null){
            return null;
        }

        if(!passwordMatch(password, u.getPassword())){
            return null;
        }
        return u;
    }

    public User create(User u){
        return ur.create(u);
    }

    public List<User> readAll(){
        return ur.readAll();
    }

    public User readById(Integer id){
        return ur.readById(id);
    }

    public User readByUsername(String username){
        return ur.readByUsername(username);
    }

    public User update(User u){
        return ur.update(u);
    }

    public void delete(User u){
        ur.delete(u);
    }

    public void createSession(HttpServletRequest request, User u){
        HttpSession session = request.getSession(true);
        session.setMaxInactiveInterval(24 * 3600 * 15);
        session.setAttribute("user", u);
    }

    public static Object checkSession(HttpServletRequest request){
        return request.getSession(false);
    }

}

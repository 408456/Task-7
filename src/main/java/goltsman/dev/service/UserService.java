package goltsman.dev.service;

import goltsman.dev.DAO.UserDAO;
import goltsman.dev.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserDAO dao;

    public List<User> getAll(){
        return dao.getAll();
    }
    public User get(Long id){
        return dao.get(id);
    }
    public void save(User u){
        dao.save(u);
    }
    public void delete(Long id){
        dao.delete(id);
    }

}

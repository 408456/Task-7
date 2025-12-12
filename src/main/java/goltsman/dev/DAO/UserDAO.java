package goltsman.dev.DAO;

import goltsman.dev.model.User;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class UserDAO {
    @PersistenceContext
    private EntityManager manager;

    public List<User> getAll(){
        return manager.createQuery("From User", User.class).getResultList();
    }
    public User get(Long id){
        return manager.find(User.class, id);
    }
    public void save(User u){
        if (u.getId() == null) manager.persist(u);
        else manager.merge(u);
    }
    public void delete(Long id){
        User u = get(id);
        if (u != null) manager.remove(u);
    }
}

package ru.korenev;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;
import java.util.List;

/**
 * Created by k1per on 15.02.2016.
 */
@Service("userDao")
@Transactional
public class UserDao implements Dao {

    @Resource(name = "sessionFactory")
    SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public User getUserById(int id) {
       return (User)sessionFactory.getCurrentSession().get(User.class,id);
    }

    public List<User> getAllUsers(int pagination) {


        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("FROM User ");
        query.setFirstResult(pagination*10);
        query.setMaxResults(10);
        return query.list();
    }

    public void deleteUserById(int id) {
        User user = getUserById(id);
        sessionFactory.getCurrentSession().delete(user);
    }

    public void updateUser(User user) {
        sessionFactory.getCurrentSession().update(user);
    }

    public void addUser(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    public User getUserByName(String string) {
        Query query = sessionFactory.getCurrentSession().createQuery("from User where name = :name");
        query.setParameter("name",string);
        List<User> userList = (List<User>)query.list();
        if(userList.isEmpty()) return null;
        return userList.get(0);
    }
}

package com.tdm.demo.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.tdm.demo.domain.User;

@Component("userDAO")
public class UserDAO extends AbstractDAO<User> {

    public User save(User user){
        super.saveOrUpdate(user);
        return user;
    }
    
    @SuppressWarnings("unchecked")
    public List<User> list(){
        return getSession().createQuery("from User").list();
    }
    
    public User getById(int id){
        User user = (User)super.get(id);
        return user;
    }
    
    public User update(User user){
//        super.saveOrUpdate(user);
//        getSession().flush();
        getHibernateTemplate().update(user);
        return user;
    }
    
    public void delete(User user){
        getSession().delete(user);
    }
}

package com.tdm.demo.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.tdm.demo.dao.UserDAO;
import com.tdm.demo.domain.User;

public class UserDAOTest extends TestBase {

    @Autowired
    private UserDAO userDAO;
    
    @Test
    public void testUpdate(){
        User user = userDAO.getById(4);
        user.setName(user.getName() + "1");
        userDAO.update(user);
    }
    
    @Test
    public void testDelete(){
        User user = userDAO.getById(5);
        userDAO.delete(user);
    }
    
    
}

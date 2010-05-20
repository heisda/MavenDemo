package com.tdm.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tdm.demo.dao.UserDAO;
import com.tdm.demo.domain.User;
import com.tdm.demo.service.UserService;

@Transactional
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;
    
    public User persiste(User user) {
        return userDAO.save(user);
    }

    @Transactional(readOnly = true)
    public List<User> list() {
        return userDAO.list();
    }

    @Transactional(readOnly = true)
    public User getById(int id) {
        User user = userDAO.getById(id);
        return user;
    }

    public User update(User user) {
        return userDAO.update(user);
    }

    public void delete(User user) {
        this.userDAO.delete(user);
    }

}

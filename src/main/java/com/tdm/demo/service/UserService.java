package com.tdm.demo.service;

import java.util.List;

import com.tdm.demo.domain.User;


public interface UserService {

    User persiste(User user);
    
    List<User> list();
    
    User getById(int id);
    
    User update(User user);
    
    void delete(User user);
}

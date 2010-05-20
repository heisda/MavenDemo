package com.tdm.demo.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceTest extends TestBase {

    @Autowired
    private UserService userService;
    
    @Test
    public void testGet(){
        System.out.println(userService.getById(1).getName());
    }
    
    @Test
    public void testDelete(){
        userService.delete(userService.getById(6));
    }
}

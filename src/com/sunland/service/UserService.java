package com.sunland.service;

import com.sunland.dao.UserDao;
import com.sunland.po.User;
import org.springframework.beans.factory.annotation.Autowired;
public class UserService {
    //注解方式注入
    @Autowired
    private UserDao userDao;
    public void register(User user){
        userDao.save(user);
    }
}

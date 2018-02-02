package com.sunland.service;

import com.sunland.dao.UserDao;
import com.sunland.po.User;

public class UserService {
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void register(User user){
        userDao.save(user);
    }
}

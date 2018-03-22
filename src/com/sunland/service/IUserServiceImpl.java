package com.sunland.service;

import com.google.gson.Gson;
import com.sunland.dao.UserDao;
import com.sunland.dto.RetLogin;
import com.sunland.po.User;
import org.springframework.beans.factory.annotation.Autowired;

public class IUserServiceImpl implements IUserService {
    @Autowired
    private UserDao userDao;
    @Override
    public RetLogin login(String input) {
        RetLogin retLogin = new RetLogin();
        User user = new Gson().fromJson(input,User.class);
        if (userDao.findUser(user.getName(),user.getPassword())){
            retLogin.setName(user.getName());
        }else {
            retLogin.setName("用户名或密码错误");
        }
        return retLogin;
    }
}

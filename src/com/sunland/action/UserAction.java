package com.sunland.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.sunland.po.User;
import com.sunland.service.UserService;

public class UserAction extends ActionSupport implements ModelDriven<User> {
    private User user = new User();
    private UserService userService;
    private String name;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public String save(){
        System.out.println(user.getName());
        userService.register(user);
        return NONE;
    }

    @Override
    public User getModel() {
        return user;
    }


    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

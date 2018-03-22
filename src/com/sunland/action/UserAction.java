package com.sunland.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.sunland.bean.PageBean;
import com.sunland.po.User;
import com.sunland.service.UserService;
import javafx.application.Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;

import java.util.ArrayList;
import java.util.List;
@Scope("prototype")
public class UserAction extends ActionSupport implements ModelDriven<User> {
    private User user = new User();

    public void setUser(User user) {
        this.user = user;
    }

    @Autowired
    private UserService userService;

//    public void setUserService(UserService userService) {
//        this.userService = userService;
//    }


    public String save(){
        System.out.println(user.getName());
        userService.register(user);
        ActionContext.getContext().getValueStack().push(user);
        return NONE;
    }

    @Override
    public User getModel() {
        return user;
    }


    public String findAll(){
        PageBean<User> pageBean = new PageBean<>();
        List<User> users = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            User user = new User("admin",i+""+i+i);
            users.add(user);
        }
        pageBean.setList(users);
        pageBean.setCurPage(1);
        pageBean.setPageSize(10);
        pageBean.setTotalCount(100);
        pageBean.setTotalPage(10);

        ActionContext.getContext().getValueStack().push(pageBean);//前端访问pagebean的list属性遍历

//        ActionContext.getContext().getValueStack().set("users",users);//访问users遍历
//        ActionContext.getContext().getSession().put("users",users);//#session.users
        this.addFieldError("errors","数据不能为空");
        System.out.println("findAll 执行了"+this.hashCode());
        return SUCCESS;
    }

    public void register(User user){
        userService.register(user);
    }


}

package com.sunland.dao;

import com.sunland.po.User;
public class UserDao extends BaseDao {
    public void save(User user){
        this.getHibernateTemplate().save(user);
    }

    public void test(){
        System.out.println("test");
    }


}

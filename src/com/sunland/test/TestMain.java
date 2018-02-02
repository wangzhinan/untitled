package com.sunland.test;

import com.sunland.dao.UserDao;
import com.sunland.po.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class TestMain {
    public static void main(String[] args) {
        Logger logger = LogManager.getLogger();
        logger.error("this is a error",new Throwable("new Throwable"));
        testSpring();
//
    }

    private static void testSpring(){
        ApplicationContext context = new ClassPathXmlApplicationContext("config/applicationContext.xml");
        UserDao userDao = (UserDao) context.getBean("userDao");
        userDao.test();
        userDao.save(new User(111L,"系统管理员","123456"));



    }

    private static void testHibernate(){
        Configuration cfg=new Configuration();
        cfg.configure("config/hibernate.cfg.xml");//populates the data of the configuration file

        //creating seession factory object
        SessionFactory factory=cfg.buildSessionFactory();

        //creating session object
        Session session=factory.openSession();

        //creating transaction object
        Transaction t=session.beginTransaction();

        User user = new User("amdin","123456");


        session.persist(user);//persisting the object

        t.commit();//transaction is committed
        session.close();

        System.out.println("successfully saved");
    }
}

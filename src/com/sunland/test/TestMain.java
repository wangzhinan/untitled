package com.sunland.test;

import com.google.gson.Gson;
import com.sunland.action.UserAction;
import com.sunland.pkg.BasePkg;
import com.sunland.po.Book;
import com.sunland.po.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Calendar;

public class TestMain {
    public static void main(String[] args) {

//        logger.error("报错信息", new IllegalArgumentException("非法参数"));
        test1(2);
        System.out.println(System.getProperty("user.country"));
        BasePkg basePkg = new BasePkg();
        basePkg.setMethod("login");
        User user = new User();
        user.setId(1);
        user.setName("admin");
        user.setPassword("123456");
        basePkg.setParameter(new Gson().toJson(user));
        System.out.println(new Gson().toJson(basePkg));



//
    }

    public static void test1(int a) {
        Calendar calendar = Calendar.getInstance();
        System.out.println(Calendar.getInstance().getTimeInMillis()+"...."+System.currentTimeMillis());
        System.out.println(calendar.get(Calendar.MONTH));
        System.out.println(calendar.get(Calendar.YEAR));
        System.out.println(calendar.get(Calendar.HOUR_OF_DAY));
        System.out.println(calendar.get(Calendar.HOUR));


    }

    private static void testSpring() {
        ApplicationContext context = new ClassPathXmlApplicationContext("config/applicationContext.xml");
//        UserDao userDao = (UserDao) context.getBean("userDao");
        UserAction userAction = (UserAction) context.getBean("userAction");
//        UserAction.register(new User(1000,"myname","pass"));
        userAction.findAll();
        userAction = (UserAction) context.getBean("userAction");
        userAction.findAll();
//        userDao.test();
        Book book = new Book();
        book.setId(170);
        book.setName("shuming");
//        userDao.save(new User(1008,"系统管理员1","123456"));
//        userDao.save(book);
//        userDao.save(new User(101L,"系统管理员2","123456"));
//        userDao.save(new User(102L,"系统管理员3","123456"));
//        System.out.println("总数为："+userDao.findCount());

//        List<User> users = userDao.findByPage(0,10);
//        for (int i = 0; i < users.size(); i++) {
//            System.out.println(users.get(i).getId());
//        }


    }

    private static void testHibernate() {
        Configuration cfg = new Configuration();
        cfg.configure("config/hibernate.cfg.xml");//populates the data of the configuration file

        //creating seession factory object
        SessionFactory factory = cfg.buildSessionFactory();

        //creating session object
        Session session = factory.openSession();

        //creating transaction object
        Transaction t = session.beginTransaction();

        User user = new User("amdin", "123456");


        session.persist(user);//persisting the object

        t.commit();//transaction is committed
        session.close();

        System.out.println("successfully saved");
    }
}

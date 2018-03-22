package com.sunland.test;

import com.google.gson.Gson;
import com.sunland.action.UserAction;
import com.sunland.pkg.BasePkg;
import com.sunland.po.Book;
import com.sunland.po.User;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.time.Clock;
import java.time.LocalDate;
import java.util.*;

public class TestMain {
    private static final int a = 0;

    public static void main(String[] args) {

//        Logger logger = LogManager.getLogger();
//        logger.error("报错信息", new IllegalArgumentException("非法参数"));
//        test1(2);
//        System.out.println(System.getProperty("user.country"));
//        BasePkg basePkg = new BasePkg();
//        basePkg.setMethod("login");
//        User user = new User();
//        user.setId(1);
//        user.setName("admin");
//        user.setPassword("123456");
//        basePkg.setParameter(new Gson().toJson(user));
//        System.out.println(new Gson().toJson(basePkg));
        Calendar calendar = Calendar.getInstance();

/*** 定制每日2:00执行方法 ***/

//        calendar.set(Calendar.HOUR_OF_DAY, 20);
//        calendar.set(Calendar.MINUTE, 32);
        calendar.set(Calendar.SECOND, 0);

        Date date = calendar.getTime(); //第一次执行定时任务的时间

//如果第一次执行定时任务的时间 小于 当前的时间
//此时要在 第一次执行定时任务的时间 加一天，以便此任务在下个时间点执行。如果不加一天，任务会立即执行。
        if (date.before(new Date())) {
//            date = addDay(date, 1);
            System.out.println("before");
        } else {
            System.out.println("after");
        }

        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                DateFormat format = new SimpleDateFormat("yyyy年MM月dd日HH时mm分ss秒S毫秒");
                System.out.println(format.format(new Date()));
            }
        };
        timer.schedule(timerTask, date, 10000);


//
    }

    // 增加或减少天数
    public static Date addDay(Date date, int num) {
        Calendar startDT = Calendar.getInstance();
        startDT.setTime(date);
        startDT.add(Calendar.MINUTE, num);
        return startDT.getTime();
    }

    public static void test4(int a) {
        Calendar calendar = Calendar.getInstance();
        System.out.println(Calendar.getInstance().getTimeInMillis() + "...." + System.currentTimeMillis());
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

    public static boolean test1(int val) {
        System.out.println("test1(" + val + ")");
        System.out.println("result: " + (val < 1));
        return val < 1;
    }

    public static boolean test2(int val) {
        System.out.println("test2(" + val + ")");
        System.out.println("result: " + (val < 2));
        return val < 2;
    }

    public static boolean test3(int val) {
        System.out.println("test3(" + val + ")");
        System.out.println("result: " + (val < 3));
        return val < 3;
    }

    @Test
    public void test4() {
        if (test1(0) && test2(2) && test3(2))
            System.out.println("expression is true");
        else System.out.println("expression is false");
    }

    @Test
    public void testMove() {
        int i = 1;
        i >>>= 10;
        System.out.println(i);
        long l = -1;
        l >>>= 10;
        System.out.println(l);
        short s = -1;
        s >>>= 10;
        System.out.println(s);
        byte b = -1;
        b >>>= 10;
        System.out.println(b);
    }

    @Test
    public void test5(){
        int i = 1;

        while (i <= 10) {
            // 这样并不能达到效果,得到的结过为:
            // HelloWorld 1
            // HelloWorld 2
            // HelloWorld 3
            // 然后进入死循环..
            // 因为i==4后直接跳出本次循环,不会再进行i++的运算,但循环并未终止,将继续进行i<=10的判断
            // 为了达到需求的结果,可以利用23-26行的代码...
            if (i == 4) {
                continue;
            }
            // if (i==4){
            // i++;
            // continue;
            // }
            System.out.println("HelloWorld " + i);
            i++;
        }

    }
}


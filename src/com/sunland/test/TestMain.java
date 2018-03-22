package com.sunland.test;

import com.sunland.dao.UserDao;
import com.sunland.po.User;
import javafx.concurrent.Task;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.*;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.function.Function;
import java.util.function.Predicate;

public class TestMain {
    private static int a = 1;

    static {
        User user = new User();
    }
    {
        System.out.println("from");
    }

    public static void main(String[] args) {
//        Logger logger = LogManager.getLogger();
//        logger.error("this is a error", new Throwable("new Throwable"));
//        a++;
//        System.out.println(a);
//        testSpring();
        new TestMain();
//
    }


    private static void testSpring() {
        ApplicationContext context = new ClassPathXmlApplicationContext("config/applicationContext.xml");
        UserDao userDao = (UserDao) context.getBean("userDao");
        userDao.test();
        userDao.save(new User(111L, "系统管理员", "123456"));

    }


    public void testFile1() {
        File file = new File("");
        try (
                FileInputStream fileInputStream = new FileInputStream(file);
                FileOutputStream fileOutputStream = new FileOutputStream(file)
        ) {
            int length = fileInputStream.read(new byte[1024]);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testFile() throws Exception {
        File file = new File("D:/file/20171228104127.jpg");
        File file1 = new File("D:/file/test.txt");
        FileInputStream fileInputStream = new FileInputStream(file);
        FileOutputStream outputStream = new FileOutputStream(file1);
        StringWriter writer = new StringWriter();
        PrintWriter printWriter = new PrintWriter(file1);
        for (int i = 0; i < 10; i++) {
            printWriter.print(i);
        }
        printWriter.close();

    }

    @Test
    public void write() {
        File f = new File("D:/file/data.txt");
        try (
                FileOutputStream fos = new FileOutputStream(f);
                DataOutputStream dos = new DataOutputStream(fos);
        ) {
            dos.writeBoolean(true);
            dos.writeInt(300);
            dos.writeUTF("123 this is gareen");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void read() {
        File file = new File("D:/file/data.txt");
        try (
                FileInputStream fileInputStream = new FileInputStream(file);
                DataInputStream dataInputStream = new DataInputStream(fileInputStream)
        ) {
            System.out.println(dataInputStream.readBoolean());
            System.out.println(dataInputStream.readInt());
            System.out.println(dataInputStream.readUTF());

        } catch (Exception e) {
            e.printStackTrace();
        }
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

    @Test
    public void testThread() {
        System.out.println("初始中断状态：" + Thread.currentThread().isInterrupted());
        Thread.currentThread().interrupt();
        System.out.println("执行完interrupt方法后，中断状态：" + Thread.currentThread().isInterrupted());
        System.out.println("首次调用interrupted方法返回结果：" + Thread.interrupted());
        System.out.println("此时中断状态：" + Thread.currentThread().isInterrupted());
        System.out.println("第二次调用interrupted方法返回结果：" + Thread.interrupted());
        System.out.println("此时中断状态：" + Thread.currentThread().isInterrupted());
    }

    @Test
    public void testFiles() {
        try {
            Path path1 = Paths.get("C:/Users/Administrator/Desktop/台州/a.txt");
            Path path2 = Paths.get("C:/Users/Administrator/Desktop/台州/b.txt");
            Files.copy(path1, path2);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testRandomChar() {
        for (int i = 0; i < 10; i++) {
            double a = Math.random()*26+'a';
            char b = (char) a;
            int c = (int) a;
            System.out.println(String.format("%c年 %03d% f%%",b,c,a));

        }
    }

    @Test
    public void testEnum(){
        System.out.println(DataType.TEST.name());
    }

    @Test
    public void testString(){
        String s = "32.,;']p[}{";
        System.out.println(s.replaceAll("[.,;`'{}/\\[\\]]",""));

    }

    private String s ;
    @Test
    public void testOptional(){
        User user = new User("admin","123456");
        Optional<String> optional = Optional.ofNullable(user.getName());
        String name = optional.orElse("this is null");
        System.out.println(optional.get());
        Collections.emptyList();

    }

}


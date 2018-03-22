package com.sunland.test;

import com.sunland.dao.UserDao;
import com.sunland.po.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
    }


    private static void testSpring() {
        ApplicationContext context = new ClassPathXmlApplicationContext("config/applicationContext.xml");
        UserDao userDao = (UserDao) context.getBean("userDao");
        userDao.test();
        userDao.save(new User(111L, "系统管理员", "123456"));

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
    public void test5() {
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
            double a = Math.random() * 26 + 'a';
            char b = (char) a;
            int c = (int) a;
            System.out.println(String.format("%c年 %03d% f%%", b, c, a));

        }
    }

    @Test
    public void testEnum() {
        System.out.println(DataType.TEST.name());
    }

    @Test
    public void testString() {
        String s = "32.,;']p[}{";
        System.out.println(s.replaceAll("[.,;`'{}/\\[\\]]", ""));

    }

    @Test
    public void testOptional() {
        User user = new User("admin", "123456");
        Optional<String> optional = Optional.ofNullable(user.getName());
        String name = optional.orElse("this is null");
        System.out.println(optional.get());
        Collections.emptyList();

    }

}


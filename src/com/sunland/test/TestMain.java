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
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


public class TestMain {
    private static int a = 0;
    static boolean b = false;
    private static Person person = new Person("my");

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) throws IOException {
        Person person = new Person("admin");
        System.out.println(person);
    }


    @Test
    public void testClass() {
        try {
            Class<?> clazz = Class.forName("com.sunland.po.User");
            User user = (User) clazz.newInstance();
            user.setName("admin");
            System.out.println(user.getName());
        } catch (ClassNotFoundException
                | IllegalAccessException
                | InstantiationException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void testBitSet() {
        BitSet bits1 = new BitSet(16);
        BitSet bits2 = new BitSet(16);

        // set some bits
        for (int i = 0; i < 17; i++) {
            if ((i % 2) == 0) bits1.set(i);
            if ((i % 5) != 0) bits2.set(i);
        }
        for (int i = 0; i < bits1.length(); i++) {
            System.out.println("bits1 " + i + " = " + bits1.get(i));
        }
        for (int i = 0; i < bits2.length(); i++) {
            System.out.println("bits2 " + i + " = " + bits2.get(i));
        }
        System.out.println("Initial pattern in bits1: ");
        System.out.println(bits1);
        System.out.println(" Initial pattern in bits2: ");
        System.out.println(bits2);

        // AND bits
        bits2.and(bits1);
        System.out.println(" bits2 AND bits1: ");
        System.out.println(bits2);

        // OR bits
        bits2.or(bits1);
        System.out.println(" bits2 OR bits1: ");
        System.out.println(bits2);

        // XOR bits
        bits2.xor(bits1);
        System.out.println("bits2 XOR bits1: ");
        System.out.println(bits2);

        Vector<String> vector = new Vector<>();
        vector.addElement("fd");
        Enumeration elements = vector.elements();
        elements.hasMoreElements();
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
    public void testFiles() {
        try {
            Path path1 = Paths.get("C:/Users/Administrator/Desktop/台州/LoginActivity.java");
            Path path2 = Paths.get("C:/Users/Administrator/Desktop/台州/b.txt");
//            Files.copy(path1, path2);
            File file = new File("C:/Users/Administrator/Desktop/台州/b.txt");
            FileInputStream fileInputStream = new FileInputStream(file);
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String result = null;
            while ((result = reader.readLine()) != null) {
                System.out.println(result);
            }

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

    /**
     * http://tool.oschina.net/uploads/apidocs/jquery/regexp.html
     */
    @Test
    public void testRegex() {
        String input = "111111";
        String regex = "(\\w)\\1{6}";
        System.out.println(input.matches(regex));
        regex = "A?B?C?";
        input = "AAABBC";
        System.out.println(input.matches(regex));
        input = "AC";
        System.out.println(input.matches(regex));
        regex = "(1234|1235).*";
        System.out.println("123456".matches(regex));
        System.out.println("123543".matches(regex));
        System.out.println("1234".matches(regex));
        System.out.println("12".matches(regex));

    }

    @Test
    public void testSystemProperty() {
        String lineSeparator = java.security.AccessController.doPrivileged(
                new sun.security.action.GetPropertyAction("line.separator"));
        System.out.print("是" + System.getProperty("line.separator") + "不是");
    }


    public static void testTimerTask() {
        DateFormat format = new SimpleDateFormat("yyyy年MM月dd日HH时mm分ss秒S毫秒");

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

        System.out.println(Thread.currentThread().getName() + format.format(date));
        ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                System.out.println("tet");
                System.out.println(format.format(new Date()) + Thread.currentThread().getName());
                a++;
//                if (a > 5){
//                    scheduledExecutorService.shutdown();
//                    System.out.println("shut down");
//                }
            }
        };
//        timer.schedule(timerTask, date);
        scheduledExecutorService.scheduleAtFixedRate(timerTask, 0, 1, TimeUnit.SECONDS);
    }

    @Test
    public void testList() {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        for (String s : list) {
            if ("2".equals(s))
                list.remove(s);
        }

    }

    @Test
    public void testObject() {
        User user = new User("admins", "654321");
        testObject(user);
        System.out.println("user = " + user.getName());
    }

    public void testObject(User user) {
        user = new User("admin", "123456");
//        user.setName("admin");
        System.out.println(user.getName());
    }

    @Test
    public void testCalendar() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(dateFormat.format(calendar.getTime()));

        //当天
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        System.out.println("起始时间：" + dateFormat.format(calendar.getTime()));
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        System.out.println("结束时间：" + dateFormat.format(calendar.getTime()));

        //昨天
        calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, -1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        System.out.println("起始时间：" + dateFormat.format(calendar.getTime()));
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        System.out.println("结束时间：" + dateFormat.format(calendar.getTime()));

        //本周
        calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, -calendar.get(Calendar.DAY_OF_WEEK) + 2);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        System.out.println("开始时间：" + dateFormat.format(calendar.getTime()));
        calendar.add(Calendar.DAY_OF_MONTH, 6);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        System.out.println("结束时间：" + dateFormat.format(calendar.getTime()));

        //本月
        calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        System.out.println("开始时间：" + dateFormat.format(calendar.getTime()));
        calendar.add(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH) - 1);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        System.out.println("结束时间：" + dateFormat.format(calendar.getTime()));
    }

    @Test
    public void testSwitch(){
        testSwitch(1);
    }

    public void testSwitch(int i) {
        switch (i) {
            case 0:
                System.out.println("a");
            case 1:
                System.out.println("b");
            case 2:
                System.out.println("c");
            default:
                break;
        }
    }


}


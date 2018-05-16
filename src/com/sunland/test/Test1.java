package com.sunland.test;

import com.sunland.po.User;
import org.junit.Test;

import java.io.*;
import java.util.*;

/**
 * Author: wangzn
 * DateTime: 2018/4/15 12:09
 */
public class Test1<E> {
    private E e;
    static char ch;

    public static void main(String[] args) {
        String s = "null";
        System.out.println(s);
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        test(list);
        System.out.println("Arrays.toString(list.toArray()) = " + Arrays.toString(list.toArray()));
        Person.crateMan();
        Person person = new Person();
        LinkedList linkedList = new LinkedList();
        linkedList.peek();

    }

    public static <T> void test(List<T> list) {
        list.subList(1, 3);
    }


    @Test
    public void testCompare() {
        test(45, 36, 89);
    }


    public void test(int a, int b, int c) {
        boolean f = (compare1(b, a) | compare2(c, b)) & (compare3(c, a) | compare4(a, c));
        System.out.println("f = " + f);
    }

    public boolean compare1(int a, int b) {
        System.out.println("Test1.compare1 = " + (a > b));
        return a > b;
    }

    public boolean compare2(int a, int b) {
        System.out.println("Test1.compare2 = " + (a > b));
        return a > b;
    }

    public boolean compare3(int a, int b) {
        System.out.println("Test1.compare3 = " + (a > b));
        return a > b;
    }

    public boolean compare4(int a, int b) {
        System.out.println("Test1.compare4 = " + (a > b));
        return a > b;
    }

    static void swap1(int a, int b) {
        System.out.println("a = " + a + "  b = " + b);
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.println("a = " + a + "  b = " + b);
    }

    static void swap2(int a, int b) {
        System.out.println("a = " + a + "  b = " + b);
        a += b;
        b = a - b;
        a = a - b;
        System.out.println("a = " + a + "  b = " + b);
    }

    static String entry(String s, int p) {
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            char aChar = chars[i];
            char a = (char) (aChar ^ p);
            chars[i] = a;
            sb.append(a);
        }
        return sb.toString();
    }

    @Test
    public void testFile() {
        String file = "D:/我的坚果云/git.txt";
        File file1 = new File(file);
        System.out.println(file1.getName());
        System.out.println(file1.getParent());
        System.out.println(file1.getPath());
        System.out.println(file1.getAbsolutePath());
        System.out.println(file1.length());//字节
    }


    @Test
    public void test3() {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add("i = " + i);
        }
        System.out.println(list.size());
        clearList(list);
        System.out.println(list.size());
        String s = "test";
        s.replace("s", "S");
        System.out.println(s);

        StringBuilder sb = new StringBuilder("HelloWorld");
        sb.replace(0, 2, "AA");
        System.out.println(sb.toString());
    }

    @Test
    public void test4() {
        HashSet<StringBuilder> hs = new HashSet<StringBuilder>();
        StringBuilder sb1 = new StringBuilder("aaa");
        StringBuilder sb2 = new StringBuilder("aaabbb");
        hs.add(sb1);
        hs.add(sb2);    //这时候HashSet里是{"aaa","aaabbb"}

        StringBuilder sb3 = sb1;
        sb3.append("bbb");  //这时候HashSet里是{"aaabbb","aaabbb"}
        System.out.println(hs);
    }

    @Test
    public void test5() {
        String s = "Hello";
        String s1 = new String("Hello");
        String s2 = "Hello";
        System.out.println(s == s1);
        System.out.println(s == s2);

    }

    @Test
    public void test6() {
        User user1 = new User();
        user1.setName("admin");
        System.out.println(user1.getName());
    }

    public <T> void clearList(List<T> list) {
        list.clear();
    }

    @Test
    public void testSubList() {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add("Data" + i);
        }
        List<String> temp = list.subList(5, 10);
        temp.clear();
        for (String s : list) {
            System.out.println("s = " + s);
        }
        for (int i = 10; i < 20; i++) {
            temp.add("Data" + i);
        }
        System.out.println("-----------");
        for (String s : list) {
            System.out.println("s = " + s);
        }
    }

    @Test
    public void testClone1() {
        try {
            Person person = new Person("admin");
            System.out.println("person = " + person);
            Person person1 = person.clone();
            System.out.println("person1 = " + person1);

        } catch (CloneNotSupportedException e1) {
            e1.printStackTrace();
        }
    }

    @Test
    public void testClone2(){
        Person person = new Person("admin");
        System.out.println("person = " + person);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            ObjectOutputStream outputStream = new ObjectOutputStream(byteArrayOutputStream);
            outputStream.writeObject(person);
            outputStream.close();
            ObjectInputStream objectInputStream = new ObjectInputStream(
                    new ByteArrayInputStream(byteArrayOutputStream.toByteArray()));
            Person person1 = (Person) objectInputStream.readObject();
            System.out.println("person1 = " + person1);
            System.out.println("person1.name = " + person1.name);
        } catch (IOException e1) {
            e1.printStackTrace();
        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
        }


    }
}

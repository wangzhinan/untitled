package com.sunland.test.io;

import org.junit.Test;

import java.io.*;
import java.util.StringTokenizer;

/**
 * Author: wangzn
 * DateTime: 2018/4/27 19:38
 */
public class TestMain {
    public static void main(String[] args) throws IOException {

        String path = "D:/test/data.txt";
        File file = new File(path);
        FileWriter fileWriter = new FileWriter(file);
        for (int i = 0; i < 1024; i++) {
            fileWriter.write("王");
        }
        fileWriter.close();
        System.out.println(file.length());

    }

    @Test
    public void test1() {
        String path = "D:/test/data.txt";
        try {
            DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(path));
            dataOutputStream.writeInt(1);
            dataOutputStream.writeUTF("管理员");
            dataOutputStream.writeUTF("admin");
            dataOutputStream.writeBoolean(false);
            dataOutputStream.writeDouble(3.1415926);
            dataOutputStream.writeLong(546465L);
            dataOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test2(){
        String path = "D:/test/data.txt";
        try {
            DataInputStream dataInputStream = new DataInputStream(new FileInputStream(path));
            System.out.println(dataInputStream.readInt());
            System.out.println(dataInputStream.readUTF());
            System.out.println(dataInputStream.readUTF());
            System.out.println(dataInputStream.readBoolean());
            System.out.println(dataInputStream.readDouble());
            System.out.println(dataInputStream.readLong());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testSplit(){
        String fileName = "D:\\test\\ThinkinJava.pdf";
        try {
            split(fileName,102400);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testMerge(){
        String fileName = "D:/test/java编程思想.pdf";
        try {
            mergeFile(fileName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void split(String path,long size) throws Exception {
        File file = new File(path);
        FileInputStream fileInputStream = new FileInputStream(file);
        int number = (int) Math.ceil(file.length() / (double) size);
        System.out.println(file.length());
        for (int i = 0; i < number; i++) {
            String fileName = file.getParent() + "\\temp\\number" + i + ".temp";
            File file1 = new File(fileName);
            FileOutputStream fileOutputStream = new FileOutputStream(file1);

            if (i == number - 1) {
                size = file.length() - (number - 1) * size;
            }
            byte[] buffer = new byte[(int) size];
            fileInputStream.read(buffer);
            fileOutputStream.write(buffer);
            fileOutputStream.close();
        }
        fileInputStream.close();
    }

    public void mergeFile(String fileName) throws Exception {
        File file = new File(fileName);
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        for (int i = 0; i < 21; i++) {
            File file1 = new File("D:\\test\\temp\\number"+i+".temp");
            FileInputStream fileInputStream = new FileInputStream(file1);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = fileInputStream.read(buffer)) != -1){
                fileOutputStream.write(buffer,0,length);
            }
            fileInputStream.close();
        }
        fileOutputStream.close();
    }

    @Test
    public void testWriteRandomAccessFile() throws Exception {
        String fileName = "D:/test/random.txt";
        RandomAccessFile rdf = new RandomAccessFile(fileName,"rw");
        String name = null ;
        int age = 0 ;
        name = "zhangsan" ;         // 字符串长度为8
        age = 30 ;                  // 数字的长度为4
        rdf.writeBytes(name) ;      // 将姓名写入文件之中
        rdf.writeInt(age) ;         // 将年龄写入文件之中
        name = "lisi    " ;         // 字符串长度为8
        age = 31 ;                  // 数字的长度为4
        rdf.writeBytes(name) ;      // 将姓名写入文件之中
        rdf.writeInt(age) ;         // 将年龄写入文件之中
        name = "wangwu  " ;         // 字符串长度为8
        age = 32 ;                  // 数字的长度为4
        rdf.writeBytes(name) ;      // 将姓名写入文件之中
        rdf.writeInt(age) ;         // 将年龄写入文件之中
        rdf.close() ;               // 关闭
    }

    @Test
    public void testReadRandomAccessFile() throws Exception{
        File f = new File("D:/test/random.txt") ; // 指定要操作的文件
        RandomAccessFile rdf = null ;       // 声明RandomAccessFile类的对象
        rdf = new RandomAccessFile(f,"r") ;// 以只读的方式打开文件
        String name = null ;
        int age = 0 ;
        byte b[] = new byte[8] ;    // 开辟byte数组
        // 读取第二个人的信息，意味着要空出第一个人的信息
        rdf.skipBytes(12) ;     // 跳过第一个人的信息
        for(int i=0;i<b.length;i++){
            b[i] = rdf.readByte() ; // 读取一个字节
        }
        name = new String(b) ;  // 将读取出来的byte数组变为字符串
        age = rdf.readInt() ;   // 读取数字
        System.out.println("第二个人的信息 --> 姓名：" + name + "；年龄：" + age) ;
        // 读取第一个人的信息
        rdf.seek(0) ;   // 指针回到文件的开头
        for(int i=0;i<b.length;i++){
            b[i] = rdf.readByte() ; // 读取一个字节
        }
        name = new String(b) ;  // 将读取出来的byte数组变为字符串
        age = rdf.readInt() ;   // 读取数字
        System.out.println("第一个人的信息 --> 姓名：" + name + "；年龄：" + age) ;
        rdf.skipBytes(12) ; // 空出第二个人的信息
        for(int i=0;i<b.length;i++){
            b[i] = rdf.readByte() ; // 读取一个字节
        }
        name = new String(b) ;  // 将读取出来的byte数组变为字符串
        age = rdf.readInt() ;   // 读取数字
        System.out.println("第三个人的信息 --> 姓名：" + name + "；年龄：" + age) ;
        rdf.close() ;               // 关闭
    }

    @Test
    public void testFile() throws Exception{
        File file = new File("E:/logs/test2.txt");
        file.renameTo(new File("D:/test/test2.txt"));
    }

    @Test
    public void testStreamTokenizer(){
        String text = "Hello. This is a text that will be split "
                + "into tokens. 1+1=2";
        try {
            // create a new file with an ObjectOutputStream
            FileOutputStream out = new FileOutputStream("D:/test/streamTokenizer.txt");
            ObjectOutputStream oout = new ObjectOutputStream(out);

            // write something in the file
            oout.writeUTF(text);
            oout.flush();

            // create an ObjectInputStream for the file we created before
            ObjectInputStream ois =
                    new ObjectInputStream(new FileInputStream("D:/test/streamTokenizer.txt"));

            // create a new tokenizer
            Reader r = new BufferedReader(new InputStreamReader(ois));
            StreamTokenizer st = new StreamTokenizer(r);

            // set line change as significant
            st.eolIsSignificant(true);

            // print the current line number
            System.out.println("Line Number:" + st.lineno());

            // print the stream tokens
            boolean eof = false;
            do {

                int token = st.nextToken();
                switch (token) {
                    case StreamTokenizer.TT_EOF:
                        System.out.println("End of File encountered.");
                        eof = true;
                        break;
                    case StreamTokenizer.TT_EOL:
                        System.out.println("End of Line encountered.");
                        System.out.println("Line Number:" + st.lineno());
                        break;
                    case StreamTokenizer.TT_WORD:
                        System.out.println("Word: " + st.sval);
                        break;
                    case StreamTokenizer.TT_NUMBER:
                        System.out.println("Number: " + st.nval);
                        break;
                    default:
                        System.out.println((char) token + " encountered.");
                        if (token == '!') {
                            eof = true;
                        }
                }
            } while (!eof);


        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


    @Test
    public void testStringTokenizer(){
        String str = "hello,java,delphi,asp,php";
        StringTokenizer st=new StringTokenizer(str,",");
        while(st.hasMoreTokens()) {
            System.out.println(st.nextToken());
        }

    }

}

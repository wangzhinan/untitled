package com.sunland.test.io;

import org.junit.Test;

import java.io.*;
import java.util.StringTokenizer;
import java.util.zip.CRC32;
import java.util.zip.CheckedOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;


/**
 * Author: wangzn
 * DateTime: 2018/4/27 19:38
 */


public class TestMain {
    public static void main(String[] args) {

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
    public void testMerge() {
        String fileName = "D:/test/java编程思想.pdf";
        try {
            mergeFile(fileName);
        } catch (Exception e) {

        }
    }
    public void testFilePath() throws Exception {
        File file = new File("D:/test/test/test.txt");
        System.out.println("file.getAbsolutePath() = " + file.getAbsolutePath());
        System.out.println("file.getParent() = " + file.getParent());
        System.out.println("file.getName() = " + file.getName());
        System.out.println("file.getPath() = " + file.getPath());
        File parent = file.getParentFile();
        System.out.println("--------------");
        System.out.println("parent.getAbsolutePath() = " + parent.getAbsolutePath());
        System.out.println("parent.getParent() = " + parent.getParent());
        System.out.println("parent.getName() = " + parent.getName());
        System.out.println("parent.getPath() = " + parent.getPath());
    }

    @Test
    public void tetsFile() throws Exception {

    }

    public static void compress(String srcFilePath, String destFilePath) {
        File src = new File(srcFilePath);
        if (!src.exists()) {
            throw new RuntimeException(srcFilePath + "不存在");
        }
        File zipFile = new File(destFilePath);
        try {
            FileOutputStream fos = new FileOutputStream(zipFile);
            CheckedOutputStream cos = new CheckedOutputStream(fos, new CRC32());
            ZipOutputStream zos = new ZipOutputStream(cos);
            String baseDir = "";
            compressbyType(src, zos, baseDir);
            zos.close();

        } catch (Exception e) {
            // TODO Auto-generated catch block
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

    private static void compressbyType(File src, ZipOutputStream zos, String baseDir) {
        if (!src.exists())
            return;
        System.out.println("压缩" + baseDir + src.getName());
        if (src.isFile()) {
            compressFile(src, zos, baseDir);
        } else if (src.isDirectory()) {
            compressDir(src, zos, baseDir);
        }

    }

    private static void compressFile(File file, ZipOutputStream zos, String baseDir) {
        if (!file.exists())
            return;
        try {
            BufferedInputStream bis = new BufferedInputStream(
                    new FileInputStream(file));
            ZipEntry entry = new ZipEntry(baseDir + file.getName());
            zos.putNextEntry(entry);
            int count;
            byte[] buf = new byte[10240];
            while ((count = bis.read(buf)) != -1) {
                zos.write(buf, 0, count);
            }
            bis.close();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    /**
     * 压缩文件夹
     */

    private static void compressDir(File dir, ZipOutputStream zos, String baseDir) {
        if (!dir.exists())
            return;
        File[] files = dir.listFiles();
        if (files.length == 0) {
            try {
                zos.putNextEntry(new ZipEntry(baseDir + dir.getName()
                        + File.separator));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        for (File file : files) {
            compressbyType(file, zos, baseDir + dir.getName() + File.separator);
        }

    }


//    public static void decompress(String srcPath, String dest) throws Exception {
//
//        File file = new File(srcPath);
//        if (!file.exists()) {
//            throw new RuntimeException(srcPath + "所指文件不存在");
//        }
//        ZipFile zf = new ZipFile(file);
//
//        Enumeration entries = zf.getEntries();
//
//        ZipEntry entry = null;
//
//        while (entries.hasMoreElements()) {
//            entry = (ZipEntry) entries.nextElement();
//
//            System.out.println("解压" + entry.getName());
//
//            if (entry.isDirectory()) {
//
//                String dirPath = dest + File.separator + entry.getName();
//
//                File dir = new File(dirPath);
//
//                dir.mkdirs();
//
//            } else {
//                // 表示文件
//                File f = new File(dest + File.separator + entry.getName());
//                if (!f.exists()) {
//                    String dirs = FileUtils.getParentPath(f);
//                    File parentDir = new File(dirs);
//                    parentDir.mkdirs();
//                }
//                f.createNewFile();
//                // 将压缩文件内容写入到这个文件中
//                InputStream is = zf.getInputStream(entry);
//                FileOutputStream fos = new FileOutputStream(f);
//                int count;
//                byte[] buf = new byte[8192];
//                while ((count = is.read(buf)) != -1) {
//                    fos.write(buf, 0, count);
//                }
//                is.close();
//
//                fos.close();
//            }
//        }
//    }


}

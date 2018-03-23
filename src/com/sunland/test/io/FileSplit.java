package com.sunland.test.io;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.Properties;

public class FileSplit {
    private static int length = 8192;

    /**
     * 分割
     *
     * @param fileName 文件路径
     * @param Number   分块文件个数
     * @throws Exception
     */
    public void splitByNumber(String fileName, int Number) throws Exception {
        File oldFile = new File(fileName);
        String infoFilePath = this.getClass().getResource("").getPath();
        System.out.println(infoFilePath);

        File fileInfo = new File( "E:/result/info.properties");
        BufferedOutputStream outInfo = new BufferedOutputStream(new FileOutputStream(fileInfo));
        outInfo.write(("fileName=" + oldFile.getName() + "\n").getBytes());
        outInfo.write(("fileNumber=" + Number + "\n").getBytes());
        InputStream in = new FileInputStream(oldFile);
        System.out.println("分块前-->文件大小：" + oldFile.length() + "字节");
        int size = (int) oldFile.length() / Number;
        long position;
        for (int i = 0; i < Number; i++) {
            if (i == Number - 1) {
                size = (int) oldFile.length() - (Number - 1) * size;
            }
            String newFilePath = "E:/result/" + randNumber() + ".file";

            outInfo.write(("file" + i + "=" + newFilePath + "\n").getBytes());

            File newFile = new File(newFilePath);
            BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(newFile));

            byte[] buf = new byte[size];
            in.read(buf);
            out.write(buf);
            out.close();
        }

        in.close();
        outInfo.close();
    }

    /**
     * 文件合并
     *
     * @throws Exception
     */
    public void mergeByName() throws Exception {
//        Properties properties = Properties.loadProperties("info.properties");
        Properties properties = new Properties();
        InputStream inputStream = new FileInputStream("E:/result/info.properties");
        properties.load(new InputStreamReader(inputStream,"UTF-8"));

        int number = Integer.parseInt(properties.getProperty("fileNumber"));
        File oldFile = new File("E:/result/answer/" + properties.getProperty("fileName"));
        BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(oldFile));
        for (int i = 0; i < number; i++) {
            File smallFile = new File(properties.getProperty("file" + i));
            BufferedInputStream in = new BufferedInputStream(new FileInputStream(smallFile));
            byte[] buf = new byte[in.available()];
            in.read(buf);
            out.write(buf);
            in.close();
        }
        out.close();
    }

    /**
     * 随机数
     *
     * @return
     */
    public String randNumber() {
        double number = Math.random();
        String str = String.valueOf(number);
        str = str.replace(".", "");
        return str;
    }

    public static void main(String[] args) {
        try {
            //分块
            new FileSplit().splitByNumber("E:\\tests\\sw.jpg",10);
//            合并
            new FileSplit().mergeByName();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testFileSplit(){
//        try {
//            splitByNumber("E:/result/宁波协管通需求设计文档.doc",5);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        try {
            mergeByName();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test1(){
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile("E:","rw");
            randomAccessFile.seek(44);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

package com.sunland.test.io;

import org.junit.Test;

import java.io.*;
import java.nio.Buffer;
import java.nio.channels.Channel;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.zip.CRC32;
import java.util.zip.CheckedOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;


public class TestMain {
    public static void main(String[] args) {

    }

    @Test
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

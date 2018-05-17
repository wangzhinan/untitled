package com.sunland.test.thread;

public class Worker extends Thread {
    //工作者名
    private String name;
    //工作时间
    private long time;

    public Worker(String name, long time) {
        this.name = name;
        this.time = time;
    }

    @Override
    public void run() {
        // TODO 自动生成的方法存
        try {
            System.out.println(name + "开始工作");
            Thread.sleep(time);
            System.out.println(name + "工作完成，耗费时间=" + time);
        } catch (InterruptedException e) {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
        }
    }
}

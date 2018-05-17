package com.sunland.test.thread;



import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Author: wangzn
 * DateTime: 2018/4/23 20:26
 */
public class MyTimerTask extends TimerTask{
    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    @Override
    public void run() {
        Random random = new Random();
        int time = random.nextInt(10000);
        System.out.println(String.format("MyTimerTask.run %04d   %s",time,simpleDateFormat.format(new Date())));
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws ParseException {
        Timer timer = new Timer();
        MyTimerTask task = new MyTimerTask();
        Random random = new Random();
        int time = random.nextInt(10000);
        System.out.println(String.format("MyTimerTask.man %04d   %s",time,simpleDateFormat.format(new Date())));
        Date date = simpleDateFormat.parse("2018-04-23 21:14:00");

        timer.schedule(task,date,5000);
        timer.scheduleAtFixedRate(task,date,5000);
    }

    public static void testExecutors(){
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
        scheduledExecutorService.scheduleAtFixedRate(new MyTimerTask(),0,5, TimeUnit.SECONDS);
    }
}

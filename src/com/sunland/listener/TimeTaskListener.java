package com.sunland.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TimeTaskListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("TimeTaskListener.contextInitialized");
        doTimeTask();
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("TimeTaskListener.contextDestroyed");
    }

    public void doTimeTask(){
        DateFormat format = new SimpleDateFormat("yyyy年MM月dd日HH时mm分ss秒S毫秒");
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.SECOND,0);
        Date taskDate = calendar.getTime();
        if (new Date().after(taskDate)){
            calendar.add(Calendar.MINUTE,1);
            taskDate = calendar.getTime();
        }
        System.out.println("real task time "+format.format(taskDate));
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                System.out.println("run time"+format.format(new Date()));
            }
        };
        Timer timer = new Timer();
        timer.schedule(timerTask,taskDate,10000);
        ExecutorService service = Executors.newCachedThreadPool();

    }
}

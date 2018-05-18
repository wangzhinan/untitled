package com.sunland.test.thread;


import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.*;

public class TestMain {
    private static int n;
    private volatile CountDownWorker worker;


    public static void main(String[] args) throws Exception {

    }


    @Test
    public void testA() {
        Assert.assertEquals(test(3, 4), 0);
        Assert.assertEquals(test(3, 2), 1);
        Assert.assertEquals(test(3, 1), 1);
    }


    public int test(int a, int b) {
        return a / b;
    }

    public static void testInterruptSynchronized() throws Exception {
        Object lock = new Object();

        class A extends Thread {
            @Override
            public void run() {
                synchronized (lock) {
                    while (!Thread.currentThread().isInterrupted()) {
                    }
                }
                System.out.println("exit");
            }
        }

        synchronized (lock) {
            A a = new A();
            a.start();
            Thread.sleep(1000);

            a.interrupt();
        }
    }

    public static void testInterrupt() throws Exception {
        class MyThread extends Thread {
            public void run() {
                while (!this.isInterrupted()) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        this.interrupt();
                    }
                    if (Thread.currentThread().isInterrupted()) {
                        System.out.println("Someone interrupted me.");
                    } else {
                        System.out.println("Thread is Going...");
                    }
                }
            }
        }
        MyThread myThread = new MyThread();
        myThread.start();
        Thread.sleep(10000);
        myThread.interrupt();
    }

    public CountDownWorker getInstannce() {
        if (worker == null) {
            synchronized (this) {
                if (worker == null) {
                    worker = new CountDownWorker("", 0, null);
                }
            }
        }

        return worker;
    }

    public static void testIsAlive() throws InterruptedException {
        class MyThread extends Thread {
            @Override
            public void run() {
                System.out.println(this.isAlive());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        MyThread myThread = new MyThread();
        System.out.println(myThread.isAlive());
        myThread.start();
        myThread.join();
        myThread.wait();
        System.out.println(myThread.isAlive());
    }

    public static void testJoin() throws Exception {
        Worker worker0 = new Worker("worker0", (long) (Math.random() * 2000 + 3000));
        Worker worker1 = new Worker("worker1", (long) (Math.random() * 2000 + 3000));
        Worker worker2 = new Worker("worker2", (long) (Math.random() * 2000 + 3000));

        worker0.start();
        worker1.start();
        worker0.join();
        worker1.join();

        System.out.println("准备工作就绪");

        worker2.start();

    }

    public static void testCoundDownWorker() throws Exception {
        CountDownLatch countDownLatch = new CountDownLatch(2);
        CountDownWorker worker0 = new CountDownWorker("worker0", (long) (Math.random() * 2000 + 3000), countDownLatch);
        CountDownWorker worker1 = new CountDownWorker("worker1", (long) (Math.random() * 2000 + 3000), countDownLatch);
        CountDownWorker worker2 = new CountDownWorker("worker2", (long) (Math.random() * 2000 + 3000), countDownLatch);

        worker0.start();
        worker1.start();

        countDownLatch.await();
        System.out.println("准备工作就绪");
        worker2.start();
    }

    public static void testCoundDownWorker1() throws Exception {
        CountDownLatch countDownLatch = new CountDownLatch(2);
        CountDownWorker1 worker0 = new CountDownWorker1("worker0", (long) (Math.random() * 2000 + 3000), countDownLatch);
        CountDownWorker1 worker1 = new CountDownWorker1("worker1", (long) (Math.random() * 2000 + 3000), countDownLatch);
        CountDownWorker1 worker2 = new CountDownWorker1("worker2", (long) (Math.random() * 2000 + 3000), countDownLatch);

        worker0.start();
        worker1.start();

        countDownLatch.await();
        System.out.println("准备工作就绪");
        worker2.start();
    }

    public static void testThread() throws Exception {
        Thread thread = new Thread();
        ExecutorService service = Executors.newCachedThreadPool();
        Future<String> submit = service.submit(() -> {
            Thread.sleep(1000 * 10);
            System.out.println("thread end -------------");
            return "success";
        });
        System.out.println("start--------------");
        System.out.println(submit.get());
        System.out.println("end--------------");

    }

    public static void timerTask() {
        Timer timer = new Timer();
        ScheduledExecutorService service = Executors.newScheduledThreadPool(3);
        n = 6;
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                try {
                    n--;
                    System.out.println("n = " + n + " task1  " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
                    int c = 34 / n;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        TimerTask timerTask1 = new TimerTask() {
            @Override
            public void run() {
                System.out.println("n = " + n + " task2  " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));

            }
        };
        timer.schedule(timerTask, 0, 2000);
        timer.schedule(timerTask1, 0, 2000);

//        service.scheduleAtFixedRate(timerTask,0,2, TimeUnit.SECONDS);
//        service.scheduleAtFixedRate(timerTask1,0,2, TimeUnit.SECONDS);

    }

    public static void testCountDownCatch() {
        CountDownLatch latch = new CountDownLatch(2);
        Runnable runnable = () -> {
            try {
                System.out.println("子线程" + Thread.currentThread().getName() + "正在执行");
                Thread.sleep(3000);
                System.out.println("子线程" + Thread.currentThread().getName() + "执行完毕");
                latch.countDown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        new Thread(runnable).start();
        new Thread(runnable).start();

        try {
            System.out.println("等待2个子线程执行完毕...");
            latch.await();
            System.out.println("2个子线程已经执行完毕");
            System.out.println("继续执行主线程");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testThreadInterr() {
        System.out.println("初始中断状态：" + Thread.currentThread().isInterrupted());
        Thread.currentThread().interrupt();
        System.out.println("执行完interrupt方法后，中断状态：" + Thread.currentThread().isInterrupted());
        System.out.println("首次调用interrupted方法返回结果：" + Thread.interrupted());
        System.out.println("此时中断状态：" + Thread.currentThread().isInterrupted());
        System.out.println("第二次调用interrupted方法返回结果：" + Thread.interrupted());
        System.out.println("此时中断状态：" + Thread.currentThread().isInterrupted());
    }

}

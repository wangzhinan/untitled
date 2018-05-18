package com.sunland.test.thread;

public class SyncThread implements Runnable {
    private static int count;

    public static void main(String[] args) throws Exception {
        SyncThread syncThread1 = new SyncThread();
        SyncThread syncThread2 = new SyncThread();
        Thread thread1 = new Thread(syncThread1, "SyncThread1");
        Thread thread2 = new Thread(syncThread2, "SyncThread2");
        thread1.start();
        thread2.start();
    }

    public SyncThread() {
        count = 0;
    }

    public void run() {
        print();
    }


    public  void print() {
        synchronized (SyncThread.class) {
            for (int i = 0; i < 5; i++) {
                try {
                    System.out.println(Thread.currentThread().getName() + ":" + (count++));
                    Thread.sleep(100);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public int getCount() {
        return count;
    }


}

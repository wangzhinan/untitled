package com.sunland.test.thread;

/**
 * Author: wangzn
 * DateTime: 2018/5/19 11:36
 */
public class CallBackThread extends Thread {
    private Listener listener;

    public CallBackThread(Listener listener) {
        this.listener = listener;
    }

    @Override
    public void run() {
        System.out.println("start -------");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        listener.onResponse("success");
        System.out.println("end -------");
    }
}

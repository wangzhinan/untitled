package com.sunland.test.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestProducerCutomer {
    public static void main(String[] args) throws Exception {
        Storage storage = new Storage();
        ExecutorService service = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            Producer producer = new Producer(storage,"producer"+i);
            service.execute(producer);
        }
        for (int i = 0; i < 10; i++) {
            Consumer consumer = new Consumer(storage,"consumer"+i);
            service.execute(consumer);
        }
    }

}

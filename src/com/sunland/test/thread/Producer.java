package com.sunland.test.thread;

public class Producer implements Runnable {
    private String producer;
    private Storage storage;

    public Producer(Storage storage) {
        this.storage = storage;
    }

    public Producer(Storage storage, String producer) {
        this.producer = producer;
        this.storage = storage;
    }

    @Override
    public void run() {
        produce(producer);
    }

    public void produce(String producer) {
        storage.produce(producer);
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public Storage getStorage() {
        return storage;
    }

    public void setStorage(Storage storage) {
        this.storage = storage;
    }
}

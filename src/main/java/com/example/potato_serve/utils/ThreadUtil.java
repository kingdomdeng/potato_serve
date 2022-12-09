package com.example.potato_serve.utils;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.ReentrantLock;

@Slf4j
public class ThreadUtil implements Runnable {
    private Thread thread;

    private String threadName;

    private static int max = 50;

    private static int current = 0;

    private int threadCount = 0;

//    private CountDownLatch cdl;
    private static CountDownLatch cdl = new CountDownLatch(2);

    private static ReentrantLock rtn = new ReentrantLock(true);

    ThreadUtil(String name) {
        threadName = name;
    }

    @Override
     public void run() {
        try {
            cdl.await();


            while (true) {
                rtn.lock();

                if (current >= max) {
                    return;
                }

                current++;
                threadCount++;
                System.out.println("["+ threadName +"]" + current);

                rtn.unlock();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rtn.isLocked()) {
                rtn.unlock();
            }
            System.out.println("[threadCount: "+ threadName +"]" + threadCount);
        }
    }

    public void start() {
        System.out.println("thread start: " + threadName);
        if (thread == null) {
            thread = new Thread(this, threadName);
            thread.start();

            cdl.countDown();
        }
    }

    synchronized public void count() throws InterruptedException {
        while (current < max) {
            System.out.println("["+ threadName +"]" + current);
            current++;
            thread.sleep(100);
        }
    }
}

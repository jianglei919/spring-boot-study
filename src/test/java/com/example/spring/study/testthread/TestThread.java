package com.example.spring.study.testthread;

import org.junit.Test;

/**
 * Created by jianglei on 2019/12/16.
 */
public class TestThread {

    @Test
    public void test() throws InterruptedException {
        Worker t = new Worker();
        t.start();

        System.out.println("000000000");
        t.interrupt();

        System.out.println("111111111");
        Thread.sleep(2000);
        t.stop();

        System.out.println("222222222");
        Thread.sleep(2000);
        t.join();
        System.out.println("333333333");
    }

    class Worker extends Thread {

        @Override
        public void run() {
            int i = 0;
            while (i < 20) {
                if (Thread.currentThread().isInterrupted()) {
                    break;
                }
                ++ i;
                System.out.println(Thread.currentThread().getName() + ", i: " + i);

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
//                    Thread.currentThread().interrupt();
                }
            }
        }
    }
}

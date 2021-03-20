package com.javaguide.forquize.TestThread.ThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author EDZ
 * @description FixedThreadPoolDemo
 * @date 2021/3/20 13:48
 */
public class FixedThreadPoolDemo {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 10; i++) {
            service.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName()+"\t 办理业务");
                }
            });
        }
    }

}

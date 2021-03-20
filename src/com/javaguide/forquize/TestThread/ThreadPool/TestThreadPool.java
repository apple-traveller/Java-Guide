package com.javaguide.forquize.TestThread.ThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author maomin
 * @description TestThreadPool
 * @date 2021/3/10 15:59
 */
public class TestThreadPool {
    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newFixedThreadPool(5);
        for (int i = 0;i <= 10;i++){
            threadPool.execute(()->{
                System.out.println(Thread.currentThread().getName()+"\t办理业务");
            });
        }
    }

}

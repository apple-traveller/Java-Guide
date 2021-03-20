package com.javaguide.forquize.TestThread;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @author maomin
 * @description SemaphoreDemo
 * @date 2021/3/18 10:31
 */
public class SemaphoreDemo {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3);
        for (int i = 1; i <= 6 ; i++) {
            new Thread(()->{
                try {
                    semaphore.acquire();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+"\t抢到车位");
                try {
                    TimeUnit.MICROSECONDS.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+"\t抢到车位3秒后离开");
                semaphore.release();
            },String.valueOf(i)).start();
        }
    }
}

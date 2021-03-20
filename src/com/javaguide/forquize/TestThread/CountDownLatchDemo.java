package com.javaguide.forquize.TestThread;

import java.util.concurrent.CountDownLatch;

/**
 * @author maomin
 * @description CountDownLatchDemo
 * @date 2021/3/17 19:04
 */
public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(6);
        for (int i = 1; i < 7; i++) {
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"\t国被灭");
                countDownLatch.countDown();
            },CountryEnum.foreach_countryEnum(i).getRetMessage()).start();
        }
        countDownLatch.await();
        System.out.println(Thread.currentThread().getName()+"\t秦帝国，一统华夏");
    }

    public static void closeDoor() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(6);
        for (int i = 0; i < 7; i++) {
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"\t上完自习，离开教室");
                countDownLatch.countDown();
            },String.valueOf(i)).start();
        }
        countDownLatch.await();
        System.out.println(Thread.currentThread().getName()+"\t最后班长关门走人");
    }
}

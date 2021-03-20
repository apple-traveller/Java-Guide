package com.javaguide.forquize.TestThread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author maomin
 * @description CyclicBarrierDemo
 * @date 2021/3/17 20:16
 */
public class CyclicBarrierDemo {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(7,()->{
            System.out.println("*******召唤神龙");
        });

        for (int i = 1; i < 8; i++) {
            final int temInt = i;
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"\t 收集到第："+temInt+"龙族");
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            },String.valueOf(i)).start();
        }

    }

}

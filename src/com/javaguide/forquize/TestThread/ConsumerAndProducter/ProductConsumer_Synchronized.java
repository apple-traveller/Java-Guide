package com.javaguide.forquize.TestThread.ConsumerAndProducter;

import java.util.concurrent.TimeUnit;

/**
 * @author maomin
 * 生产者消费者交替执行
 *
 *  1、线程      操作     资源类
 *  2、判断      干活     通知
 *
 * @description ProductConsumer_Synchronized
 * @date 2021/3/19 9:44
 */
class ShareData2{
    private int number = 0;
    private boolean flag = false;
    public synchronized void increment() throws InterruptedException {
        try {
            while(true){
                if(flag){
                    //flag为true就等待
                    wait();
                }
                TimeUnit.SECONDS.sleep(1);
                number++;
                System.out.println(Thread.currentThread().getName()+"\t生产了一个商品"+number);
                flag = true;
                //通知唤醒
                notify();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void decrement() throws InterruptedException {
        try {
            while(true){
                if(!flag){
                    //flag为flase就等待
                    wait();
                }
                TimeUnit.SECONDS.sleep(1);
                flag = false;
                System.out.println(Thread.currentThread().getName()+"\t消费了一个商品"+number);
                //通知唤醒
                notify();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


public class ProductConsumer_Synchronized {
    public static void main(String[] args) {
        ShareData2 data = new ShareData2();

        new Thread(()->{
            try {
                data.increment();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"product").start();

        new Thread(()->{
            try {
                data.decrement();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"consumer").start();

    }
}

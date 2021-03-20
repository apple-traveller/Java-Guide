package com.javaguide.forquize.TestThread.ConsumerAndProducter;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


/**
 * @author maomin
 *
 * 一个初始值为0的变量，两个线程对其交替操作，一个加一一个减一，来五轮
 *
 * 1、线程      操作     资源类
 * 2、判断      干活     通知
 *
 * @description ProductConsumer_Tridition
 * @date 2021/3/18 20:12
 */
class ShareData{
    private int number = 0;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void increment() throws InterruptedException {
        lock.lock();
        try {
            while(true){
                if(number%2==0){
                    //number为偶数就等待
                    condition.await();
                }
                TimeUnit.MILLISECONDS.sleep(1000);
                number++;
                System.out.println(Thread.currentThread().getName()+"\t生产了一个商品"+number);
                //通知唤醒
                condition.signalAll();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }

    public void decrement() throws InterruptedException {
        lock.lock();
        try {
            while(true){
                if(number%2==1){
                    //number为奇数就等待
                    condition.await();
                }
                TimeUnit.MILLISECONDS.sleep(1000);
                number++;
                System.out.println(Thread.currentThread().getName()+"\t消费了一个商品"+number);
                //通知唤醒
                condition.signalAll();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

}


public class ProductConsumer_Condition {
    public static void main(String[] args) {
        ShareData data = new ShareData();

//        for (int i = 1; i <=5 ; i++) {
            new Thread(()->{
                try {
                    data.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            },"product").start();
//        }

//        for (int i = 1; i <= 5 ; i++) {
            new Thread(()->{
                try {
                    data.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            },"consumer").start();
//        }


    }
}

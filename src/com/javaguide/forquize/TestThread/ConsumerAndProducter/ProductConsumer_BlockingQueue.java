package com.javaguide.forquize.TestThread.ConsumerAndProducter;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author maomin
 *
 * 阻塞队列的形式写消费者生产者
 *
 * @description ProductConsumer_BlockingQueue
 * @date 2021/3/19 15:07
 */
class MyResource{
    private volatile boolean FLAG = true;
    private AtomicInteger atomicInteger = new AtomicInteger();
    BlockingQueue<String> blockingQueue = null;

    public MyResource(BlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
        System.out.println(blockingQueue.getClass().getName());
    }

    public void myPdoduct() throws InterruptedException {
        String data = null;
        boolean retValue;
        while(FLAG){
            data = atomicInteger.incrementAndGet()+"";
            retValue = blockingQueue.offer(data,2L, TimeUnit.SECONDS);
            if(retValue){
                System.out.println(Thread.currentThread().getName()+"\t 插入队列"+data+"成功");
            }else{
                System.out.println(Thread.currentThread().getName()+"\t 插入队列"+data+"失败");
            }
            TimeUnit.SECONDS.sleep(1);
        }
        System.out.println(Thread.currentThread().getName()+"\t大老板叫停了，表示FLAG为false，生产动作结束");
    }

    public void myConsumer() throws InterruptedException {
        String result = null;
        while(FLAG){
            TimeUnit.SECONDS.sleep(2);
            result = blockingQueue.poll(2L,TimeUnit.SECONDS);
            if(null ==result || result.equalsIgnoreCase("")){
                FLAG = false;
                System.out.println(Thread.currentThread().getName()+"\t超过两秒没有取到蛋糕，消费退出");
                System.out.println();
                System.out.println();
                return;
            }
            System.out.println(Thread.currentThread().getName()+"\t消费队列"+result+"成功");
        }
    }

}

public class ProductConsumer_BlockingQueue {
    public static void main(String[] args) {
        MyResource myResource = new MyResource(new ArrayBlockingQueue<>(10));
        new Thread(()->{
            System.out.println("生产者启动");
            try {
                myResource.myPdoduct();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"prod").start();

        new Thread(()->{
            System.out.println("消费者启动");
            try {
                myResource.myConsumer();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();


    }
}

package com.javaguide.forquize.TestThread;


import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class MyCache{
    private volatile Map<String,Object> map = new HashMap();
    private ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();

    public void put(String key,Object value) {

        rwLock.writeLock().lock();
        try{
            System.out.println(Thread.currentThread().getName()+"\t 正在写人："+key);
            //暂停一会儿线程
            try {
                TimeUnit.MICROSECONDS.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            map.put(key,value);
            System.out.println(Thread.currentThread().getName()+"\t 写人完成：");
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            rwLock.writeLock().unlock();
        }


    }

    public void get(String key){
        rwLock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName()+"\t 正在读取：");
            //暂停一会儿线程
            try {
                TimeUnit.MICROSECONDS.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Object result = map.get(key);
            System.out.println(Thread.currentThread().getName()+"\t 读取完成："+result);
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            rwLock.readLock().unlock();
        }

    }

}

/**
 * @author maomin
 * @description 读写锁
 * 读-读能共存
 * 读-写不能共存
 * 写-写不能共存
 *
 * 写操作：原子+独占 整个过程必须是一个完整的整体，中间不允许被分割，被打断
 *
 * @date 2021/3/16 20:25
 */
public class ReadWriteLockDemo {
    public static void main(String[] args) {
        MyCache myCache = new MyCache();
        //五个线程来写
        for (int i = 0;i<=5;i++){
            final int temp = i;
            new Thread(()->{
                myCache.put(temp+"",temp+"");
            },String.valueOf(i)).start();
        }

        //五个线程读取
        for (int i = 0;i<=5;i++){
            final int temp = i;
            new Thread(()->{
                myCache.get(temp+"");
            },String.valueOf(i)).start();
        }
    }
}

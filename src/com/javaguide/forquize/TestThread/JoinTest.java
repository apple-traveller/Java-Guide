package com.javaguide.forquize.TestThread;

/**
 * @author EDZ
 * @description YieldTest
 * @date 2020/11/12 17:45
 */
public class JoinTest {

    public static void main(String[] args) throws Exception {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                }catch (Exception e){

                }
                System.out.println("111");
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                }catch (Exception e){

                }

                System.out.println("222");
            }
        });
        t1.start();
        t2.start();
        t1.join();
        //t2.join();
        System.out.println("333");
    }
}

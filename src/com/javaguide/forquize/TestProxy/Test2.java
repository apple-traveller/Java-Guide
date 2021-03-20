package com.javaguide.forquize.TestProxy;

/**
 * @author EDZ
 * @description Test2
 * @date 2020/9/7 10:06
 */
public class Test2 {
    public static void main(String[] args) {
        final Business bussiness = new Business();
        Thread.interrupted();
       //子线程
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 3; i++) {
                    bussiness.subMethod();
                }
            }
        }).start();
        //主线程
        for (int i = 0; i < 3; i++) {
            bussiness.mainMethod();
        }
    }
}

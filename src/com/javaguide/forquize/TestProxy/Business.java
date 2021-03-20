package com.javaguide.forquize.TestProxy;

/**
 * @author EDZ
 * @description Business
 * @date 2020/9/7 15:39
 */
public class Business {
    private volatile boolean subFlag = true;
    public synchronized void mainMethod() {
        while (subFlag) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName()
                    + " : main thread running loop count -- " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        subFlag = true;
        this.notify();
    }
    public synchronized void subMethod() {
        while (!subFlag) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for (int i = 0; i < 10; i++) {
            System.err.println(Thread.currentThread().getName()
                    + " : sub thread running loop count -- " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        subFlag = false;
        this.notify();
    }
}

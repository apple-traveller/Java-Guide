package com.javaguide.forquize.TestThread;

/**
 * @author EDZ
 * @description YieldTest
 * @date 2020/11/12 17:54
 */
public class YieldTest {
    public static void main(String[] args) {
        Thread producer = new Producer();
        Thread consumer = new Consumer();

        producer.setPriority(Thread.MIN_PRIORITY); //Min Priority
        consumer.setPriority(Thread.MAX_PRIORITY); //Max Priority

        producer.start();
        consumer.start();
    }
}

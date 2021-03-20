package com.javaguide.forquize.TestThread;

import java.util.concurrent.Callable;

class MyThread implements Callable<Integer>{

    @Override
    public Integer call() throws Exception {
        System.out.println("Hello world!");
        return null;
    }
}


/**
 * @author maomin
 * @description CallableDemo
 * @date 2021/3/20 11:50
 */
public class CallableDemo {

}

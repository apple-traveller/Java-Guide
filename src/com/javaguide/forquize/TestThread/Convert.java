package com.javaguide.forquize.TestThread;

/**
 * @author maomin
 * @date 2021/3/17 14:33
 */
@FunctionalInterface
public interface Convert<F,T> {
    T convert(F from);
}


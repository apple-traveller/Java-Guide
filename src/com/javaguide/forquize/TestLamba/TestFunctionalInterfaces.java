package com.javaguide.forquize.TestLamba;

/**
 *
 * 测试函数式接口
 * @author maomin
 * @description TestFunctionalInterfaces
 * @date 2021/3/17 14:33
 */
public class TestFunctionalInterfaces {
    public static void main(String[] args) {
        Convert<String,Integer> convert = (from)-> Integer.valueOf(from);
        Integer converted = convert.convert("123");
        System.out.println(converted);
    }
}

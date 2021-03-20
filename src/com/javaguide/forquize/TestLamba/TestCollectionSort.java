package com.javaguide.forquize.TestLamba;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author maomin
 * @description TestCollectionSort
 * @date 2021/3/17 14:09
 */
public class TestCollectionSort {

    public static void main(String[] args) {
        List<String> names = Arrays.asList("peter","anna","mike","xenia");
//        Collections.sort(names, new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                return o2.compareTo(o1);
//            }
//        });
//        Collections.sort(names,(String a,String b)->{
//            return b.compareTo(a);
//        });
        Collections.sort(names,(String a,String b)->a.compareTo(b));
        System.out.println(names);
    }

}

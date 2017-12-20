package com.paul.ycolle_test;

import com.paul.ycolle.YLinkedList;
import org.junit.Test;

import java.util.LinkedList;

public class TestA {

    @Test
    public void test() {
        YLinkedList<String> list = new YLinkedList<>();
        list.add("123");
        list.add("456");
        list.add("789");

        list.addFirst("abc");

        System.out.println(list);
    }


}

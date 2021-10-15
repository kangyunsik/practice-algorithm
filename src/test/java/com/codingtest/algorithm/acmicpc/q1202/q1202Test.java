package com.codingtest.algorithm.acmicpc.q1202;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class q1202Test {

    @Test
    void test1(){
        int n = 2;
        int k = 1;
        long expected = 10;
        String[] jewel_orders = ("5 10\n" +
                "100 100").split("\n");
        String[] bag_orders = ("11").split("\n");

        Main main = new Main(n,k);
        for (String jewel_order : jewel_orders) {
            main.setJewel(jewel_order);
        }
        for (String bag_order : bag_orders) {
            main.setBag(bag_order);
        }
        main.run();
        assertThat(main.getAnswer()).isEqualTo(expected);
    }

    @Test
    void test2(){
        int n = 3;
        int k = 2;
        long expected = 164;
        String[] jewel_orders = ("1 65\n" +
                "5 23\n" +
                "2 99").split("\n");
        String[] bag_orders = ("10\n" +
                "2").split("\n");

        Main main = new Main(n,k);
        for (String jewel_order : jewel_orders) {
            main.setJewel(jewel_order);
        }
        for (String bag_order : bag_orders) {
            main.setBag(bag_order);
        }
        main.run();
        assertThat(main.getAnswer()).isEqualTo(expected);
    }
}
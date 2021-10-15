package com.codingtest.algorithm.acmicpc.q16928;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class q16928Test {
    @Test
    void test(){
        int n = 3;
        int m = 7;
        String[] strings = ("32 62\n" +
                "42 68\n" +
                "12 98\n" +
                "95 13\n" +
                "97 25\n" +
                "93 37\n" +
                "79 27\n" +
                "75 19\n" +
                "49 47\n" +
                "67 17").split("\n");

        Main main = new Main();
        main.init(n,m);
        for (String string : strings) {
            main.set(string);
        }
        main.run(1,0);
        assertThat(main.getAnswer()).isEqualTo(3);
    }

    @Test
    void test2(){
        int n = 4;
        int m = 9;
        String[] strings = ("8 52\n" +
                "6 80\n" +
                "26 42\n" +
                "2 72\n" +
                "51 19\n" +
                "39 11\n" +
                "37 29\n" +
                "81 3\n" +
                "59 5\n" +
                "79 23\n" +
                "53 7\n" +
                "43 33\n" +
                "77 21").split("\n");

        Main main = new Main();
        main.init(n,m);
        for (String string : strings) {
            main.set(string);
        }
        main.run(1,0);
        assertThat(main.getAnswer()).isEqualTo(5);
    }
}
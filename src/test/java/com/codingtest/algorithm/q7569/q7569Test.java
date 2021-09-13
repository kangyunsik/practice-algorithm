package com.codingtest.algorithm.q7569;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class q7569Test {
    @Test
    void test(){
        int n = 5, m = 3, h = 1;

        String[] strings = ("0 -1 0 0 0\n" +
                "-1 -1 0 1 1\n" +
                "0 0 0 1 1").split("\n");

        Main main = new Main();
        main.init(5,3,1);

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < m; j++) {
                main.set(strings[j+m*i],j,i);
            }
        }

        main.run();
        assertThat(main.getAnswer()).isEqualTo(-1);
    }

    @Test
    void test2(){
        int n = 5, m = 3, h = 2;

        String[] strings = ("0 0 0 0 0\n" +
                "0 0 0 0 0\n" +
                "0 0 0 0 0\n" +
                "0 0 0 0 0\n" +
                "0 0 1 0 0\n" +
                "0 0 0 0 0").split("\n");

        Main main = new Main();
        main.init(n,m,h);

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < m; j++) {
                main.set(strings[j+m*i],j,i);
            }
        }

        main.run();
        main.printTest();
        assertThat(main.getAnswer()).isEqualTo(4);
    }

    @Test
    void test3(){
        int n = 4, m = 3, h = 2;

        String[] strings = ("1 1 1 1\n" +
                "1 1 1 1\n" +
                "1 1 1 1\n" +
                "1 1 1 1\n" +
                "-1 -1 -1 -1\n" +
                "1 1 1 -1").split("\n");

        Main main = new Main();
        main.init(n,m,h);

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < m; j++) {
                main.set(strings[j+m*i],j,i);
            }
        }

        main.run();
        main.printTest();
        assertThat(main.getAnswer()).isEqualTo(0);
    }
}
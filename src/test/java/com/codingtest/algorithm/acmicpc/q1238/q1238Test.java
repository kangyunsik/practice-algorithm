package com.codingtest.algorithm.acmicpc.q1238;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class q1238Test {

    @Test
    void test(){
        int n = 4;
        int m = 8;
        int x = 2;
        int answer = 10;
        String[] strings = ("1 2 4\n" +
                "1 3 2\n" +
                "1 4 7\n" +
                "2 1 1\n" +
                "2 3 5\n" +
                "3 1 2\n" +
                "3 4 4\n" +
                "4 2 3").split("\n");
        Main main = new Main(n, m, x);
        for (String string : strings) {
            main.set(string);
        }
        main.run();
        assertThat(main.getAnswer()).isEqualTo(answer);
    }
}
package com.codingtest.algorithm.q1167;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class q1167Test {

    @Test
    void test(){
        int n = 5;
        String[] input = ("1 3 2 -1\n" +
                "2 4 4 -1\n" +
                "3 1 2 4 3 -1\n" +
                "4 2 4 3 3 5 6 -1\n" +
                "5 4 6 -1").split("\n");
        Main main = new Main(n);
        for (int i = 0; i < n; i++) {
            main.set(input[i]);
        }
        main.run();
        assertThat(main.getAnswer()).isEqualTo(11);
    }
}
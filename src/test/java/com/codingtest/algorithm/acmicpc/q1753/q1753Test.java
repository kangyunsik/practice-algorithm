package com.codingtest.algorithm.acmicpc.q1753;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class q1753Test {
    @Test
    void test(){
        int n = 5;
        int m = 6;
        int start = 1;
        String[] inputs = ("5 1 1\n" +
                "1 2 2\n" +
                "1 3 3\n" +
                "2 3 4\n" +
                "2 4 5\n" +
                "3 4 6").split("\n");

        String[] expected = ("0\n" +
                "2\n" +
                "3\n" +
                "7\n" +
                "INF").split("\n");
        Main main = new Main(n,m,start);
        for (int i = 0; i < m; i++) {
            main.set(inputs[i]);
        }
        main.run();
        assertThat(main.getAnswer()).isEqualTo(expected);
    }
}
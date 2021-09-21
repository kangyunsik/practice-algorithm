package com.codingtest.algorithm.q11660;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class q11660Test {
    @Test
    void test1(){
        int n = 4;
        int m = 3;
        int[] expected = {27,6,64};
        String[] inputs = ("1 2 3 4\n" +
                "2 3 4 5\n" +
                "3 4 5 6\n" +
                "4 5 6 7").split("\n");
        String[] runs = ("2 2 3 4\n" +
                "3 4 3 4\n" +
                "1 1 4 4").split("\n");
        Main main = new Main(n, m);
        for (int i = 0; i < n; i++) {
            main.set(i,inputs[i]);
        }
        for (int i = 0; i < m; i++) {
            main.run(i,runs[i]);
        }
        assertThat(main.getAnswer()).isEqualTo(expected);
    }

    @Test
    void test2(){
        int n = 2;
        int m = 4;
        int[] expected = {1,2,3,4};
        String[] inputs = ("1 2\n" +
                "3 4").split("\n");
        String[] runs = ("1 1 1 1\n" +
                "1 2 1 2\n" +
                "2 1 2 1\n" +
                "2 2 2 2").split("\n");
        Main main = new Main(n, m);
        for (int i = 0; i < n; i++) {
            main.set(i,inputs[i]);
        }
        for (int i = 0; i < m; i++) {
            main.run(i,runs[i]);
        }
        assertThat(main.getAnswer()).isEqualTo(expected);
    }
}
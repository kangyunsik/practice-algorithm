package com.codingtest.algorithm.q11403;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class q11403Test {

    @Test
    void test() {
        int n = 3;
        String[] strings = {"0 1 0",
                "0 0 1",
                "1 0 0"};

        int[][] expected = {{1, 1, 1},
                {1, 1, 1},
                {1, 1, 1}};


        Main main = new Main();
        main.init(n);
        for (int i = 0; i < n; i++) {
            main.set(i, strings[i]);
        }
        main.run();

        int[][] answer = main.getAnswer();
        assertThat(answer).isEqualTo(expected);
    }


    @Test
    void test2() {
        int n = 7;
        String[] strings = {"0 0 0 1 0 0 0",
                "0 0 0 0 0 0 1",
                "0 0 0 0 0 0 0",
                "0 0 0 0 1 1 0",
                "1 0 0 0 0 0 0",
                "0 0 0 0 0 0 1",
                "0 0 1 0 0 0 0"};

        int[][] expected = {
                {1,0,1,1,1,1,1},
                {0,0,1,0,0,0,1},
                {0,0,0,0,0,0,0},
                {1,0,1,1,1,1,1},
                {1,0,1,1,1,1,1},
                {0,0,1,0,0,0,1},
                {0,0,1,0,0,0,0}};


        Main main = new Main();
        main.init(n);
        for (int i = 0; i < n; i++) {
            main.set(i, strings[i]);
        }
        main.run();

        int[][] answer = main.getAnswer();
        assertThat(answer).isEqualTo(expected);
    }

}
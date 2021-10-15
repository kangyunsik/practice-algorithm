package com.codingtest.algorithm.acmicpc.q1780;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class q1780Test {

    @Test
    void basic_solution() {
        Main main = new Main();
        main.init(9);

        main.array = new int[][]{{0, 0, 0, 1, 1, 1, -1, -1, -1},
                {0, 0, 0, 1, 1, 1, -1, -1, -1},
                {0, 0, 0, 1, 1, 1, -1, -1, -1},
                {1, 1, 1, 0, 0, 0, 0, 0, 0},
                {1, 1, 1, 0, 0, 0, 0, 0, 0},
                {1, 1, 1, 0, 0, 0, 0, 0, 0},
                {0, 1, -1, 0, 1, -1, 0, 1, -1},
                {0, -1, 1, 0, 1, -1, 0, 1, -1},
                {0, 1, -1, 1, 0, -1, 0, 1, -1}};

        int[] answer = {10,12,11};
        main.run();
        assertThat(main.answer).isEqualTo(answer);
    }

    @Test
    void three_solution() {
        Main main = new Main();
        main.init(3);

        main.array = new int[][]{{0,1,1},
                {0,1,1},
                {0,0,-1}};

        int[] answer = {1,4,4};
        main.run();
        assertThat(main.answer).isEqualTo(answer);
    }

    @Test
    void one_solution() {
        Main main = new Main();
        main.init(1);

        main.array = new int[][]{{0}};

        int[] answer = {0,1,0};
        main.run();
        assertThat(main.answer).isEqualTo(answer);
    }
}
package com.codingtest.algorithm.programmers.q1829;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class q1829Test {
    @Test
    void test(){
        int m = 6;
        int n = 4;
        int[][] pic = {{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}};
        int[] exp = {4,5};
        Solution solution = new Solution();
        int[] result = solution.solution(m, n, pic);
        assertThat(result).isEqualTo(exp);
    }

    @Test
    void test2(){
        int m = 6;
        int n = 4;
        int[][] pic = {{1, 1, 1, 0}, {1, 1, 1, 0}, {0, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 1}};
        int[] exp = {2,6};
        Solution solution = new Solution();
        int[] result = solution.solution(m, n, pic);
        assertThat(result).isEqualTo(exp);
    }
}
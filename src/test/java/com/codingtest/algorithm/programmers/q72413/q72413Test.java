package com.codingtest.algorithm.programmers.q72413;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class q72413Test {
    @Test
    void pr_test() {
        int n = 6, s = 4, a = 6, b = 2;
        int exp = 82;
        int[][] fares = {{4, 1, 10}, {3, 5, 24}, {5, 6, 2}, {3, 1, 41}, {5, 1, 24}, {4, 6, 50}, {2, 4, 66}, {2, 3, 22}, {1, 6, 25}};
        Solution solution = new Solution();
        int result = solution.solution(n, s, a, b, fares);
        assertThat(result).isEqualTo(exp);
    }

    @Test
    void pr_test2() {
        int n = 7, s = 3, a = 4, b = 1;
        int exp = 14;
        int[][] fares = {{5, 7, 9}, {4, 6, 4}, {3, 6, 1}, {3, 2, 3}, {2, 1, 6}};
        Solution solution = new Solution();
        int result = solution.solution(n, s, a, b, fares);
        assertThat(result).isEqualTo(exp);
    }

    @Test
    void pr_test3() {
        int n = 6, s = 4, a = 5, b = 6;
        int exp = 18;
        int[][] fares = {{2, 6, 6}, {6, 3, 7}, {4, 6, 7}, {6, 5, 11}, {2, 5, 12}, {5, 3, 20}, {2, 4, 8}, {4, 3, 9}};
        Solution solution = new Solution();
        int result = solution.solution(n, s, a, b, fares);
        assertThat(result).isEqualTo(exp);
    }
}
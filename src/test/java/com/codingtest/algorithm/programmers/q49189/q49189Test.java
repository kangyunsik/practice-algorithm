package com.codingtest.algorithm.programmers.q49189;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class q49189Test {
    @Test
    void pr_test(){
        int n = 6;
        int[][] v = {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};
        int exp = 3;
        Solution solution = new Solution();
        int result = solution.solution(n, v);
        assertThat(result).isEqualTo(exp);
    }
}
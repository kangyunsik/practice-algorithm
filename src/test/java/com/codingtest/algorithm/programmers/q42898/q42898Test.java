package com.codingtest.algorithm.programmers.q42898;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class q42898Test {
    @Test
    void pr_test(){
        int n = 3;
        int m = 4;
        int[][] p = {{2,2}};
        int exp = 4;
        Solution solution = new Solution();
        int result = solution.solution(m, n, p);
        assertThat(result).isEqualTo(exp);
    }

    @Test
    void pr_test2(){
        int n = 3;
        int m = 4;
        int[][] p = {{1,2},{2,1}};
        int exp = 0;
        Solution solution = new Solution();
        int result = solution.solution(m, n, p);
        assertThat(result).isEqualTo(exp);
    }
}
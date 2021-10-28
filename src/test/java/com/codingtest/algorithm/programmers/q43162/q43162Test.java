package com.codingtest.algorithm.programmers.q43162;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class q43162Test {
    @Test
    void pr_test(){
        int n = 3;
        int[][] com = {{1,1,0},{1,1,0},{0,0,1}};
        int exp = 2;
        Solution solution = new Solution();
        int result = solution.solution(n, com);
        assertThat(result).isEqualTo(exp);
    }

    @Test
    void pr_test2(){
        int n = 3;
        int[][] com = {{1,1,0},{1,1,1},{0,1,1}};
        int exp = 1;
        Solution solution = new Solution();
        int result = solution.solution(n, com);
        assertThat(result).isEqualTo(exp);
    }
}
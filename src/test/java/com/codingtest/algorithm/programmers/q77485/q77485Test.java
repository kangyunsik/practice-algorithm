package com.codingtest.algorithm.programmers.q77485;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class q77485Test {
    @Test
    void pr_test(){
        int r = 6;
        int c = 6;
        int[][] q = {{2,2,5,4},{3,3,6,6},{5,1,6,3}};
        int[] exp = {8,10,25};
        Solution solution = new Solution();

        int[] result = solution.solution(r, c, q);
        assertThat(result).isEqualTo(exp);
    }

    @Test
    void pr_test2(){
        int r = 3;
        int c = 3;
        int[][] q = {{1,1,2,2},{1,2,2,3},{2,1,3,2},{2,2,3,3}};
        int[] exp = {1,1,5,3};
        Solution solution = new Solution();

        int[] result = solution.solution(r, c, q);
        assertThat(result).isEqualTo(exp);
    }

    @Test
    void pr_test3(){
        int r = 100;
        int c = 97;
        int[][] q = {{1,1,100,97}};
        int[] exp = {1};
        Solution solution = new Solution();

        int[] result = solution.solution(r, c, q);
        assertThat(result).isEqualTo(exp);
    }
}
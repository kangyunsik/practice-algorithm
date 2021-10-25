package com.codingtest.algorithm.programmers.q42862;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class q42862Test {
    @Test
    void pr_test1(){
        int n = 5;
        int[] lost = {2,4};
        int[] reserve = {1,3,5};
        int exp = 5;
        Solution solution = new Solution();
        int result = solution.solution(n, lost, reserve);
        assertThat(result).isEqualTo(exp);
    }

    @Test
    void pr_test2(){
        int n = 5;
        int[] lost = {2,4};
        int[] reserve = {3};
        int exp = 4;
        Solution solution = new Solution();
        int result = solution.solution(n, lost, reserve);
        assertThat(result).isEqualTo(exp);
    }

    @Test
    void pr_test3(){
        int n = 5;
        int[] lost = {2,4};
        int[] reserve = {3};
        int exp = 4;
        Solution solution = new Solution();
        int result = solution.solution(n, lost, reserve);
        assertThat(result).isEqualTo(exp);
    }

    @Test
    void pr_test4(){
        int n = 3;
        int[] lost = {1,2};
        int[] reserve = {2,3};
        int exp = 2;
        Solution solution = new Solution();
        int result = solution.solution(n, lost, reserve);
        assertThat(result).isEqualTo(exp);
    }
}
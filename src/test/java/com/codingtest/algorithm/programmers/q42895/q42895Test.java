package com.codingtest.algorithm.programmers.q42895;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class q42895Test {
    @Test
    void pr_test(){
        int N = 5;
        int number = 12;
        int exp = 4;
        Solution solution = new Solution();
        int result = solution.solution(N, number);
        assertThat(result).isEqualTo(exp);
    }

    @Test
    void pr_test2(){
        int N = 2;
        int number = 11;
        int exp = 3;
        Solution solution = new Solution();
        int result = solution.solution(N, number);
        assertThat(result).isEqualTo(exp);
    }

    @Test
    void pr_test3(){
        int N = 5;
        int number = 26;
        int exp = 4;
        Solution solution = new Solution();
        int result = solution.solution(N, number);
        assertThat(result).isEqualTo(exp);
    }
}
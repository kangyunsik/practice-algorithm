package com.codingtest.algorithm.programmers.q84512;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class q84512Test {
    @Test
    void pr_test1(){
        String word = "AAAAE";
        int exp = 6;
        Solution solution = new Solution();
        int result = solution.solution(word);
        assertThat(result).isEqualTo(exp);
    }

    @Test
    void pr_test2(){
        String word = "AAAE";
        int exp = 10;
        Solution solution = new Solution();
        int result = solution.solution(word);
        assertThat(result).isEqualTo(exp);
    }

    @Test
    void pr_test3(){
        String word = "I";
        int exp = 1563;
        Solution solution = new Solution();
        int result = solution.solution(word);
        assertThat(result).isEqualTo(exp);
    }

    @Test
    void pr_test4(){
        String word = "EIO";
        int exp = 1189;
        Solution solution = new Solution();
        int result = solution.solution(word);
        assertThat(result).isEqualTo(exp);
    }
}
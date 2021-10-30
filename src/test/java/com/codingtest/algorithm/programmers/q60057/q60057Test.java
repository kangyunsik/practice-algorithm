package com.codingtest.algorithm.programmers.q60057;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class q60057Test {
    @Test
    void pr_test() {
        String s = "aabbaccc";
        int exp = 7;
        Solution solution = new Solution();
        int result = solution.solution(s);
        assertThat(result).isEqualTo(exp);
    }

    @Test
    void pr_test2() {
        String s = "ababcdcdababcdcd";
        int exp = 9;
        Solution solution = new Solution();
        int result = solution.solution(s);
        assertThat(result).isEqualTo(exp);
    }

    @Test
    void pr_test3() {
        String s = "abcabcdede";
        int exp = 8;
        Solution solution = new Solution();
        int result = solution.solution(s);
        assertThat(result).isEqualTo(exp);
    }

    @Test
    void pr_test4() {
        String s = "abcabcabcabcdededededede";
        int exp = 14;
        Solution solution = new Solution();
        int result = solution.solution(s);
        assertThat(result).isEqualTo(exp);
    }

    @Test
    void pr_test5() {
        String s = "xababcdcdababcdcd";
        int exp = 17;
        Solution solution = new Solution();
        int result = solution.solution(s);
        assertThat(result).isEqualTo(exp);
    }

}
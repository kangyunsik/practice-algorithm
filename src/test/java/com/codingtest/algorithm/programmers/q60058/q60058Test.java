package com.codingtest.algorithm.programmers.q60058;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class q60058Test {
    @Test
    void pr_test1(){
        String p = "(()())()";
        String exp = "(()())()";
        Solution solution = new Solution();
        String result = solution.solution(p);
        assertThat(result).isEqualTo(exp);
    }

    @Test
    void pr_test2(){
        String p = ")(";
        String exp = "()";
        Solution solution = new Solution();
        String result = solution.solution(p);
        assertThat(result).isEqualTo(exp);
    }

    @Test
    void pr_test3(){
        String p = "()))((()";
        String exp = "()(())()";
        Solution solution = new Solution();
        String result = solution.solution(p);
        assertThat(result).isEqualTo(exp);
    }
}
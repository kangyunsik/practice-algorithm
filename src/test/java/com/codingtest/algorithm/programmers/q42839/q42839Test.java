package com.codingtest.algorithm.programmers.q42839;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class q42839Test {
    @Test
    void pr_test(){
        String number = "17";
        int expect = 3;
        Solution solution = new Solution();
        int result = solution.solution(number);
        assertThat(result).isEqualTo(expect);
    }

    @Test
    void pr_test2(){
        String number = "011";
        int expect = 2;
        Solution solution = new Solution();
        int result = solution.solution(number);
        assertThat(result).isEqualTo(expect);
    }

    @Test
    void pr_test3(){
        String number = "1";
        int expect = 0;
        Solution solution = new Solution();
        int result = solution.solution(number);
        assertThat(result).isEqualTo(expect);
    }
}

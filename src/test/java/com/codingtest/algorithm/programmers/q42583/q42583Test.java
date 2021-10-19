package com.codingtest.algorithm.programmers.q42583;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class q42583Test {
    @Test
    void pr_test1(){
        int b = 2;
        int w = 10;
        int[] tw = {7,4,5,6};
        int expect = 8;
        Solution solution = new Solution();
        int result = solution.solution(b, w, tw);
        assertThat(result).isEqualTo(expect);
    }

    @Test
    void pr_test2(){
        int b = 100;
        int w = 100;
        int[] tw = {10};
        int expect = 101;
        Solution solution = new Solution();
        int result = solution.solution(b, w, tw);
        assertThat(result).isEqualTo(expect);
    }

    @Test
    void pr_test3(){
        int b = 100;
        int w = 100;
        int[] tw = {10,10,10,10,10,10,10,10,10,10};
        int expect = 110;
        Solution solution = new Solution();
        int result = solution.solution(b, w, tw);
        assertThat(result).isEqualTo(expect);
    }
}
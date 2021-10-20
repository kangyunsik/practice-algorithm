package com.codingtest.algorithm.programmers.q42584;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class q42584Test {
    @Test
    void pr_test(){
        int[] prices = {1,2,3,2,3};
        int[] expect = {4,3,1,1,0};
        Solution solution = new Solution();
        int[] result = solution.solution(prices);
        assertThat(result).isEqualTo(expect);
    }

    @Test
    void pr_test2(){
        int[] prices = {2,3,2,1};
        int[] expect = {3,1,1,0};
        Solution solution = new Solution();
        int[] result = solution.solution(prices);
        assertThat(result).isEqualTo(expect);
    }

    @Test
    void pr_test3(){
        int[] prices = {1,2,2,2,2,1};
        int[] expect = {5,4,3,2,1,0};
        Solution solution = new Solution();
        int[] result = solution.solution(prices);
        assertThat(result).isEqualTo(expect);
    }

    @Test
    void pr_test4(){
        int[] prices = {1,2,3,2,3,1};
        int[] expect = {5,4,1,2,1,0};
        Solution solution = new Solution();
        int[] result = solution.solution(prices);
        assertThat(result).isEqualTo(expect);
    }

    @Test
    void pr_test5(){
        int[] prices = {1,2,3,1,2,3,2,1};
        int[] expect = {7,2,1,4,3,1,1,0};
        Solution solution = new Solution();
        int[] result = solution.solution(prices);
        assertThat(result).isEqualTo(expect);
    }


}
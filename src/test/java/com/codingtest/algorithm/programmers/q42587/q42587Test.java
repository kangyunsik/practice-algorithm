package com.codingtest.algorithm.programmers.q42587;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class q42587Test {
    @Test
    void test(){
        int[] pri = {2,1,3,2};
        int loc = 2;
        int expect = 1;
        Solution solution = new Solution();
        int result = solution.solution(pri, loc);
        assertThat(result).isEqualTo(expect);
    }

    @Test
    void test2(){
        int[] pri = {1,1,9,1,1,1};
        int loc = 0;
        int expect = 5;
        Solution solution = new Solution();
        int result = solution.solution(pri, loc);
        assertThat(result).isEqualTo(expect);
    }

    @Test
    void test3(){
        int[] pri = {1};
        int loc = 0;
        int expect = 1;
        Solution solution = new Solution();
        int result = solution.solution(pri, loc);
        assertThat(result).isEqualTo(expect);
    }

}
package com.codingtest.algorithm.programmers.q42578;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class q42578Test {
    @Test
    void pr_test1(){
        String[][] clothes = {{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"},{"green_turban", "headgear"}};
        int expect = 5;

        Solution solution = new Solution();
        int result = solution.solution(clothes);
        assertThat(result).isEqualTo(expect);
    }

    @Test
    void pr_test2(){
        String[][] clothes = {{"crowmask", "face"},{"bluesunglasses", "face"},{"smoky_makeup", "face"}};
        int expect = 3;

        Solution solution = new Solution();
        int result = solution.solution(clothes);
        assertThat(result).isEqualTo(expect);
    }
}
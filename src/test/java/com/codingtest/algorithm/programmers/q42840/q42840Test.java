package com.codingtest.algorithm.programmers.q42840;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class q42840Test {
    @Test
    void pr_test(){
        int[] answer = {1,2,3,4,5};
        int[] exp = {1};
        Solution solution = new Solution();
        int[] result = solution.solution(answer);
        assertThat(result).isEqualTo(exp);
    }

    @Test
    void pr_test2(){
        int[] answer = {1,3,2,4,2};
        int[] exp = {1,2,3};
        Solution solution = new Solution();
        int[] result = solution.solution(answer);
        assertThat(result).isEqualTo(exp);
    }
}

package com.codingtest.algorithm.programmers.q42626;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class q42626Test {
    @Test
    void pr_test(){
        int[] scov = {1,2,3,9,10,12};
        int k = 7;
        int expect = 2;

        Solution solution = new Solution();
        int result = solution.solution(scov,k);
        assertThat(result).isEqualTo(expect);
    }
}
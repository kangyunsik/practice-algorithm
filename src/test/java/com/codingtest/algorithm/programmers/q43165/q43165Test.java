package com.codingtest.algorithm.programmers.q43165;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class q43165Test {

    @Test
    void pr_test() {
        int[] numbers = {1,1,1,1,1};
        int target = 3;
        int expect = 5;
        Solution solution = new Solution();
        int result = solution.solution(numbers, target);
        assertThat(result).isEqualTo(expect);
    }
}
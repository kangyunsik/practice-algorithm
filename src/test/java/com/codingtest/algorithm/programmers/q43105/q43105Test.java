package com.codingtest.algorithm.programmers.q43105;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class q43105Test {
    @Test
    void pr_test(){
        int[][] triangle = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
        int expect = 30;
        Solution solution = new Solution();
        int result = solution.solution(triangle);
        assertThat(result).isEqualTo(expect);
    }
}
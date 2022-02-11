package com.codingtest.algorithm.programmers.q92343;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class q92343Test {
    @Test
    void pr_test(){
        int[] info = {0, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1};
        int[][] edges = {{0, 1}, {1, 2}, {1, 4}, {0, 8}, {8, 7}, {9, 10}, {9, 11}, {4, 3}, {6, 5}, {4, 6}, {8, 9}};
        int exp = 5;
        Solution solution = new Solution();
        int ret = solution.solution(info, edges);
        Assertions.assertThat(ret).isEqualTo(exp);

    }

}
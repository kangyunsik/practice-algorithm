package com.codingtest.algorithm.programmers.q60059;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class q60059Test {
    @Test
    void pr_test(){
        int[][] key = {{0,0,0},{1,0,0},{0,1,1}};
        int[][] lock = {{1,1,1},{1,1,0},{1,0,1}};
        boolean exp = true;
        Solution solution = new Solution();
        boolean result = solution.solution(key, lock);
        Assertions.assertThat(result).isEqualTo(exp);
    }
}
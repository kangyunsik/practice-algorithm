package com.codingtest.algorithm.programmers.q87946;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class q87946Test {
    @Test
    void pr_test(){
        int k = 80;
        int[][] d = {{80,20},{50,40},{30,10}};
        int exp = 3;
        Solution solution = new Solution();
        int result = solution.solution(k, d);
        assertThat(result).isEqualTo(exp);
    }
}
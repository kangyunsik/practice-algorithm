package com.codingtest.algorithm.programmers.q12973;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;

class q12973Test {
    @Test
    void pr_test(){
        int exp = 0;
        Solution solution = new Solution();
        int result = solution.solution("a".repeat(1000000) + "b");
        assertThat(result).isEqualTo(exp);
    }

    @Test
    void pr_test2(){
        int exp = 0;
        Solution solution = new Solution();
        int result = solution.solution("b".repeat(3));
        assertThat(result).isEqualTo(exp);
    }
}
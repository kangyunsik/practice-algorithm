package com.codingtest.algorithm.programmers.q49994;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class q49994Test {

    @BeforeEach
    void beforeEach(){
        Solution.clear();
    }

    @Test
    void test_pr1(){
        int expected = 7;
        Solution solution = new Solution();
        int result = solution.solution("ULURRDLLU");
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @Test
    void test_pr2(){
        int expected = 7;
        Solution solution = new Solution();
        int result = solution.solution("LULLLLLLU");
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @Test
    void test_pr3(){
        int expected = 1;
        Solution solution = new Solution();
        int result = solution.solution("LR");
        Assertions.assertThat(result).isEqualTo(expected);
    }
}
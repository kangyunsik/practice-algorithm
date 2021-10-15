package com.codingtest.algorithm.codility.lessons.lesson2.oddoccurrencesinarray;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class taskTest {
    @Test
    void pr_test1(){
        int[] array = new int[]{9,3,9,3,9,7,9};
        int expect = 7;
        Solution solution = new Solution();
        assertThat(solution.solution(array)).isEqualTo(expect);
    }
}
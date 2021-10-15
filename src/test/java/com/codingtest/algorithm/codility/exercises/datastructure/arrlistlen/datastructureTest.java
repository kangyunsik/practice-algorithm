package com.codingtest.algorithm.codility.exercises.datastructure.arrlistlen;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class datastructureTest {
    @Test
    void pr_test(){
        int[] array = new int[]{1,4,-1,3,2};
        Solution solution = new Solution();
        assertThat(solution.solution(array)).isEqualTo(4);
    }

    @Test
    void one_test(){
        int[] array = new int[]{-1};
        Solution solution = new Solution();
        assertThat(solution.solution(array)).isEqualTo(1);
    }

    @Test
    void zero_test(){
        int[] array = new int[]{};
        Solution solution = new Solution();
        assertThat(solution.solution(array)).isEqualTo(0);
    }
}
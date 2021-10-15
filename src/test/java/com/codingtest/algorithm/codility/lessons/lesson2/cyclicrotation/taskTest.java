package com.codingtest.algorithm.codility.lessons.lesson2.cyclicrotation;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class taskTest {
    @Test
    void pr_test1(){
        int[] array = {3, 8, 9, 7, 6};
        int k = 3;
        int[] expect = {9, 7, 6, 3, 8};

        Solution solution = new Solution();
        assertThat(solution.solution(array,k)).isEqualTo(expect);
    }

    @Test
    void pr_test2(){
        int[] array = {0,0,0};
        int k = 1;
        int[] expect = {0,0,0};

        Solution solution = new Solution();
        assertThat(solution.solution(array,k)).isEqualTo(expect);
    }

    @Test
    void pr_test3(){
        int[] array = {1,2,3,4};
        int k = 4;
        int[] expect = {1,2,3,4};

        Solution solution = new Solution();
        assertThat(solution.solution(array,k)).isEqualTo(expect);
    }

    @Test
    void null_test(){
        int[] array = {};
        int k = 4;
        int[] expect = {};

        Solution solution = new Solution();
        assertThat(solution.solution(array,k)).isEqualTo(expect);
    }
}
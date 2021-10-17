package com.codingtest.algorithm.programmers.q42586;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class q42586Test {

    @Test
    void test(){
        int[] progress = {93,30,55};
        int[] speed = {1,30,5};
        int[] expect = {2,1};
        Solution solution = new Solution();
        int[] result = solution.solution(progress, speed);
        assertThat(result).isEqualTo(expect);
    }

    @Test
    void test2(){
        int[] progress = {95, 90, 99, 99, 80, 99};
        int[] speed = {1,1,1,1,1,1};
        int[] expect = {1,3,2};
        Solution solution = new Solution();
        int[] result = solution.solution(progress, speed);
        assertThat(result).isEqualTo(expect);
    }

    @Test
    void test3(){
        int[] progress = {1,1,1};
        int[] speed = {1,2,3};
        int[] expect = {3};
        Solution solution = new Solution();
        int[] result = solution.solution(progress, speed);
        assertThat(result).isEqualTo(expect);
    }
}
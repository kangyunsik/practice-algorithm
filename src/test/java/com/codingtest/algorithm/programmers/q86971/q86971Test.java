package com.codingtest.algorithm.programmers.q86971;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class q86971Test {
    @Test
    void test_pr1(){
        int n = 9;
        int[][] wires = {{1,3},{2,3},{3,4},{4,5},{4,6},{4,7},{7,8},{7,9}};
        int expect = 3;

        Solution solution = new Solution();
        assertThat(solution.solution(n,wires)).isEqualTo(expect);
    }

    @Test
    void test_pr2(){
        int n = 4;
        int[][] wires ={{1,2},{2,3},{3,4}};
        int expect = 0;

        Solution solution = new Solution();
        assertThat(solution.solution(n,wires)).isEqualTo(expect);
    }

    @Test
    void test_pr3(){
        int n = 7;
        int[][] wires = {{1,2},{2,7},{3,7},{3,4},{4,5},{6,7}};
        int expect = 1;

        Solution solution = new Solution();
        assertThat(solution.solution(n,wires)).isEqualTo(expect);
    }
}
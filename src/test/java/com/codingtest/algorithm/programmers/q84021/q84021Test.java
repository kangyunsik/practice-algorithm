package com.codingtest.algorithm.programmers.q84021;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

import static org.assertj.core.api.Assertions.assertThat;

class q84021Test {
    @BeforeEach
    void beforeEach(){
        Solution.answer = 0;
    }

    @Test
    void pr_test1(){
        int[][] game = {{1,1,0,0,1,0},{0,0,1,0,1,0},{0,1,1,0,0,1},{1,1,0,1,1,1},{1,0,0,0,1,0},{0,1,1,1,0,0}};
        int[][] table = {{1,0,0,1,1,0},{1,0,1,0,1,0},{0,1,1,0,1,1},{0,0,1,0,0,0},{1,1,0,1,1,0},{0,1,0,0,0,0}};
        int expect = 14;
        Solution solution = new Solution();
        assertThat(solution.solution(game,table)).isEqualTo(expect);
    }

    @Test
    void pr_test2(){
        int[][] game = {{0,0,0},{1,1,0},{1,1,1}};
        int[][] table = {{1,1,1},{1,0,0},{0,0,0}};
        int expect = 0;
        Solution solution = new Solution();
        assertThat(solution.solution(game,table)).isEqualTo(expect);
    }

}
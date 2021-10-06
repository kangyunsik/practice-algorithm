package com.codingtest.algorithm.programmers.q83201;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class q83201Test {
    @Test
    void pr_test1(){
        int[][] scores = {{50,90},{50,87}};
        Solution solution = new Solution();
        assertThat(solution.solution(scores)).isEqualTo("DA");
    }

    @Test
    void pr_test2(){
        int[][] scores = {{70,49,90},{68,50,38},{73,31,100}};
        Solution solution = new Solution();
        assertThat(solution.solution(scores)).isEqualTo("CFD");
    }

    @Test
    void pr_test3(){
        int[][] scores = {{90,90,90,90},{70,70,70,70},{90,90,90,90},{70,70,70,70}};
        Solution solution = new Solution();
        assertThat(solution.solution(scores)).isEqualTo("BBBB");
    }

    @Test
    void pr_test4(){
        int[][] scores = {{75,50,100},{75,100,20},{100,100,20}};
        Solution solution = new Solution();
        assertThat(solution.solution(scores)).isEqualTo("BBF");
    }

    @Test
    void pr_test5(){
        int[][] scores = {{50,51,49},{49,50,51},{51,49,50}};
        Solution solution = new Solution();
        assertThat(solution.solution(scores)).isEqualTo("DDD");
    }

    @Test
    void pr_test6(){
        int[][] scores = {{100,90,98,88,65},{50,45,99,85,77},{47,88,95,80,67},{61,57,100,80,65},{24,90,94,75,65}};
        Solution solution = new Solution();
        assertThat(solution.solution(scores)).isEqualTo("FBABD");
    }
}
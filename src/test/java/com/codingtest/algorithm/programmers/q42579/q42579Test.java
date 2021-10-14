package com.codingtest.algorithm.programmers.q42579;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.assertj.core.api.Assertions.assertThat;

class q42579Test {

    @BeforeEach
    void beforeEach(){
        Solution.sumMap = new HashMap<>();
        Solution.cntMap = new HashMap<>();
    }

    @Test
    void pr_test1(){
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};
        int[] expect = {4, 1, 3, 0};

        Solution solution = new Solution();
        int[] result = solution.solution(genres, plays);
        assertThat(result).isEqualTo(expect);
    }

    @Test
    void pr_test2(){
        String[] genres = {"a", "a", "a"};
        int[] plays = {500, 600, 50};
        int[] expect = {1,0};

        Solution solution = new Solution();
        int[] result = solution.solution(genres, plays);
        assertThat(result).isEqualTo(expect);
    }

    @Test
    void pr_test3(){
        String[] genres = {"a", "b", "a"};
        int[] plays = {500, 600, 100};
        int[] expect = {1,0,2};

        Solution solution = new Solution();
        int[] result = solution.solution(genres, plays);
        assertThat(result).isEqualTo(expect);
    }

    @Test
    void pr_test4(){
        String[] genres = {"classic","classic","classic","classic","pop"};
        int[] plays = {500,150,800,800,2500};
        int[] expect = {4,2,3};

        Solution solution = new Solution();
        int[] result = solution.solution(genres, plays);
        assertThat(result).isEqualTo(expect);
    }
}
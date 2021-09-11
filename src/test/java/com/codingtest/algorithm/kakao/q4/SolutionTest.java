package com.codingtest.algorithm.kakao.q4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void test(){
        Solution solution = new Solution();
        for (int i : solution.solution(5, new int[]{2, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0})) {
            System.out.print(i+" ");
        }
    }
}
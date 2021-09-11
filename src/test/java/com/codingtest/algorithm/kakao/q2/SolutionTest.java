package com.codingtest.algorithm.kakao.q2;

import com.codingtest.algorithm.kakao.q2.Solution;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {
    @Test
    void test() {
        Solution solution = new Solution();
        assertThat(solution.solution(437674,3)).isEqualTo(3);
    }

    @Test
    void test2() {
        Solution solution = new Solution();
        assertThat(solution.solution(110011,10)).isEqualTo(2);
    }

    @Test
    void test2_1() {
        Solution solution = new Solution();
        assertThat(solution.solution(110011000,10)).isEqualTo(2);
    }

    @Test
    void test3() {
        Solution solution = new Solution();
        assertThat(solution.solution(2,10)).isEqualTo(1);
    }

    @Test
    void test3_2() {
        Solution solution = new Solution();
        assertThat(solution.solution(994913,10)).isEqualTo(1);
    }

    @Test
    void test3_3() {
        Solution solution = new Solution();
        assertThat(solution.solution(990999,10)).isEqualTo(0);
    }

    @Test
    void test3_4() {
        Solution solution = new Solution();
        assertThat(solution.solution(797161*3+2,3)).isEqualTo(0);
    }

    @Test
    void printList(){
        Solution solution = new Solution();
        solution.initEratos();
        System.out.println(solution.list.toString());
    }
}
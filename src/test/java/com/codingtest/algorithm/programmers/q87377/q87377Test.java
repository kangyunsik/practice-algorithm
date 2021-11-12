package com.codingtest.algorithm.programmers.q87377;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class q87377Test {
    @Test
    void pr_test(){
        int[][] line = {{2, -1, 4}, {-2, -1, 4}, {0, -1, 1}, {5, -8, -12}, {5, 8, 12}};
        String[] exp = {"....*....", ".........", ".........", "*.......*", ".........", ".........", ".........", ".........", "*.......*"};
        Solution solution = new Solution();
        String[] result = solution.solution(line);
        assertThat(result).isEqualTo(exp);
    }

    @Test
    void pr_test2(){
        int[][] line = {{0, 1, -1}, {1, 0, -1}, {1, 0, 1}};
        String[] exp = {"*.*"};
        Solution solution = new Solution();
        String[] result = solution.solution(line);
        assertThat(result).isEqualTo(exp);
    }

    @Test
    void pr_test3(){
        int[][] line = {{1, -1, 0}, {2, -1, 0}};
        String[] exp = {"*"};
        Solution solution = new Solution();
        String[] result = solution.solution(line);
        assertThat(result).isEqualTo(exp);
    }

    @Test
    void pr_test4(){
        int[][] line = {{1, -1, 0}, {2, -1, 0}, {4, -1, 0}};
        String[] exp = {"*"};
        Solution solution = new Solution();
        String[] result = solution.solution(line);
        assertThat(result).isEqualTo(exp);
    }
}
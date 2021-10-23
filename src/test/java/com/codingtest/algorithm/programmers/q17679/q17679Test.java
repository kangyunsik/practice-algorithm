package com.codingtest.algorithm.programmers.q17679;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class q17679Test {
    @Test
    void test(){
        int m = 4;
        int n = 5;
        String[] board = {"CCBDE", "AAADE", "AAABF", "CCBBF"};
        int expect = 14;

        Solution solution = new Solution();
        int result = solution.solution(m, n, board);
        assertThat(result).isEqualTo(expect);
    }

    @Test
    void test2(){
        int m = 6;
        int n = 6;
        String[] board = {"TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"};
        int expect = 15;

        Solution solution = new Solution();
        int result = solution.solution(m, n, board);
        assertThat(result).isEqualTo(expect);
    }
}
package com.codingtest.algorithm.programmers.q43163;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class q43163Test {

    @Test
    void pr_test(){
        String b = "hit";
        String t = "cog";
        String[] w = {"hot", "dot", "dog", "lot", "log", "cog"};
        int exp = 4;
        Solution solution = new Solution();
        int result = solution.solution(b, t, w);
        assertThat(result).isEqualTo(exp);
    }

    @Test
    void pr_test2(){
        String b = "hit";
        String t = "cog";
        String[] w = {"hot", "dot", "dog", "lot", "log"};
        int exp = 0;
        Solution solution = new Solution();
        int result = solution.solution(b, t, w);
        assertThat(result).isEqualTo(exp);
    }
}
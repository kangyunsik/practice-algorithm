package com.codingtest.algorithm.programmers.q17677;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class q17677Test {
    @Test
    void pr_test(){
        String s1 = "FRANCE";
        String s2 = "french";
        int exp = 16384;
        Solution solution = new Solution();
        int result = solution.solution(s1,s2);
        assertThat(result).isEqualTo(exp);
    }

    @Test
    void pr_test2(){
        String s1 = "E=M*C^2";
        String s2 = "e=m*c^2";
        int exp = 65536;
        Solution solution = new Solution();
        int result = solution.solution(s1,s2);
        assertThat(result).isEqualTo(exp);
    }
}
package com.codingtest.algorithm.programmers.q42577;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class q42577Test {

    @Test
    void pr_test1(){
        String[] given = {"119", "97674223", "1195524421"};
        boolean expect = false;

        Solution solution = new Solution();
        boolean result = solution.solution(given);
        assertThat(result).isEqualTo(expect);
    }

    @Test
    void pr_test2(){
        String[] given = {"123","456","789"};
        boolean expect = true;

        Solution solution = new Solution();
        boolean result = solution.solution(given);
        assertThat(result).isEqualTo(expect);
    }

    @Test
    void pr_test3(){
        String[] given = {"12","123","1235","567","88"};
        boolean expect = false;

        Solution solution = new Solution();
        boolean result = solution.solution(given);
        assertThat(result).isEqualTo(expect);
    }
}
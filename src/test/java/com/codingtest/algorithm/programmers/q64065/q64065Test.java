package com.codingtest.algorithm.programmers.q64065;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class q64065Test {
    @Test
    void pr_test(){
        String s = "{{2},{2,1},{2,1,3},{2,1,3,4}}";

        int[] exp = {2,1,3,4};
        Solution solution = new Solution();
        int[] result = solution.solution(s);
        assertThat(result).isEqualTo(exp);
    }

    @Test
    void pr_test2(){
        String s = "{{1,2,3},{2,1},{1,2,4,3},{2}}";

        int[] exp = {2,1,3,4};
        Solution solution = new Solution();
        int[] result = solution.solution(s);
        assertThat(result).isEqualTo(exp);
    }

    @Test
    void pr_test3(){
        String s = "{{20,111},{111}}";

        int[] exp = {111,20};
        Solution solution = new Solution();
        int[] result = solution.solution(s);
        assertThat(result).isEqualTo(exp);
    }
}
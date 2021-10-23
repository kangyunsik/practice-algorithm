package com.codingtest.algorithm.programmers.q17684;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class q17684Test {
    @Test
    void pr_Test(){
        String msg = "KAKAO";
        int[] expect = {11,1,27,15};
        Solution solution = new Solution();
        int[] result = solution.solution(msg);
        assertThat(result).isEqualTo(expect);
    }

    @Test
    void pr_Test2(){
        String msg = "TOBEORNOTTOBEORTOBEORNOT";
        int[] expect = {20, 15, 2, 5, 15, 18, 14, 15, 20, 27, 29, 31, 36, 30, 32, 34};
        Solution solution = new Solution();
        int[] result = solution.solution(msg);
        assertThat(result).isEqualTo(expect);
    }

    @Test
    void pr_Test3(){
        String msg = "ABABABABABABABAB";
        int[] expect = {1, 2, 27, 29, 28, 31, 30};
        Solution solution = new Solution();
        int[] result = solution.solution(msg);
        assertThat(result).isEqualTo(expect);
    }

    @Test
    void pr_Test4(){
        String msg = "A";
        int[] expect = {1};
        Solution solution = new Solution();
        int[] result = solution.solution(msg);
        assertThat(result).isEqualTo(expect);
    }

    @Test
    void nullTest(){
        String msg = "AA";
        assertThat(msg.substring(0,0)).isEqualTo("");
    }
}
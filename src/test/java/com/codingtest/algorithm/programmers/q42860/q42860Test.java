package com.codingtest.algorithm.programmers.q42860;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class q42860Test {
    @Test
    void pr_test(){
        String s = "JEROEN";
        int exp = 56;
        Solution solution = new Solution();
        int result = solution.solution(s);
        assertThat(result).isEqualTo(exp);
    }

    @Test
    void pr_test2(){
        String s = "JAN";
        int exp = 23;
        Solution solution = new Solution();
        int result = solution.solution(s);
        assertThat(result).isEqualTo(exp);
    }

    @Test
    void pr_test3(){
        String s = "AAA";
        int exp = 0;
        Solution solution = new Solution();
        int result = solution.solution(s);
        assertThat(result).isEqualTo(exp);
    }

    @Test
    void pr_test4(){
        String s = "BAAAAAA";
        int exp = 1;
        Solution solution = new Solution();
        int result = solution.solution(s);
        assertThat(result).isEqualTo(exp);
    }

    @Test
    void pr_test5(){
        String s = "ZAAAAAA";
        int exp = 1;
        Solution solution = new Solution();
        int result = solution.solution(s);
        assertThat(result).isEqualTo(exp);
    }

    @Test
    void pr_test6(){
        String s = "AAAAB";
        int exp = 2;
        Solution solution = new Solution();
        int result = solution.solution(s);
        assertThat(result).isEqualTo(exp);
    }

    @Test
    void pr_test7(){
        String s = "ABA";
        int exp = 2;
        Solution solution = new Solution();
        int result = solution.solution(s);
        assertThat(result).isEqualTo(exp);
    }

    @Test
    void pr_test8(){
        String s = "ACCAAAA";
        int exp = 6;
        Solution solution = new Solution();
        int result = solution.solution(s);
        assertThat(result).isEqualTo(exp);
    }

    @Test
    void pr_test9(){
        String s = "A";
        int exp = 0;
        Solution solution = new Solution();
        int result = solution.solution(s);
        assertThat(result).isEqualTo(exp);
    }

    @Test
    void pr_test10(){
        String s = "C";
        int exp = 2;
        Solution solution = new Solution();
        int result = solution.solution(s);
        assertThat(result).isEqualTo(exp);
    }

    @Test
    void pr_test11(){
        String s = "ZZA";
        int exp = 3;
        Solution solution = new Solution();
        int result = solution.solution(s);
        assertThat(result).isEqualTo(exp);
    }

    @Test
    void pr_test12(){
        String s = "BBBBAABBB";
        int exp = 15;
        Solution solution = new Solution();
        int result = solution.solution(s);
        assertThat(result).isEqualTo(exp);
    }

    @Test
    void pr_test13(){
        String s = "ZAAAZZZZZZZ";
        int exp = 15;
        Solution solution = new Solution();
        int result = solution.solution(s);
        assertThat(result).isEqualTo(exp);
    }

    @Test
    void pr_test14(){
        String s = "ZZAAAZZ";
        int exp = 8;
        Solution solution = new Solution();
        int result = solution.solution(s);
        assertThat(result).isEqualTo(exp);
    }
}
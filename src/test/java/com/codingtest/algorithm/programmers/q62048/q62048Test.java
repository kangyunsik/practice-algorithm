package com.codingtest.algorithm.programmers.q62048;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class q62048Test {
    @Test
    void doubleTest(){
        double result = Math.floor(1.999f);
        System.out.println("result = " + result);
        result = Math.floor(2.000f);
        System.out.println("result = " + result);

        System.out.println("Math.ceil(0.0) = " + Math.ceil(0.0));
    }

    @Test
    void pr_test(){
        int w = 8;
        int h = 12;
        int exp = 80;
        Solution solution = new Solution();
        long result = solution.solution(w, h);
        assertThat(result).isEqualTo(exp);
    }

    @Test
    void pr_test2(){
        int w = 1;
        int h = 1;
        int exp = 0;
        Solution solution = new Solution();
        long result = solution.solution(w, h);
        assertThat(result).isEqualTo(exp);
    }

    @Test
    void pr_test3(){
        int w = 1;
        int h = 2;
        int exp = 0;
        Solution solution = new Solution();
        long result = solution.solution(w, h);
        assertThat(result).isEqualTo(exp);
    }

    @Test
    void pr_test4(){
        int w = 2;
        int h = 4;
        int exp = 4;
        Solution solution = new Solution();
        long result = solution.solution(w, h);
        assertThat(result).isEqualTo(exp);
    }

    @Test
    void pr_test5(){
        int w = 100000000;
        int h = 999999999;
        long exp = 99999998800000002L;
        Solution solution = new Solution();
        long result = solution.solution(w, h);
        assertThat(result).isEqualTo(exp);
    }

    @Test
    void pr_test6(){
        int w = 10;
        int h = 9;
        long exp = 72;
        Solution solution = new Solution();
        long result = solution.solution(w, h);
        assertThat(result).isEqualTo(exp);
    }
}
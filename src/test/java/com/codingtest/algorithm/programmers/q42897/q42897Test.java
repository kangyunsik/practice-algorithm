package com.codingtest.algorithm.programmers.q42897;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class q42897Test {
    @Test
    void pr_test() {
        int[] money = {1, 2, 3, 1};
        int expect = 4;
        Solution solution = new Solution();
        int result = solution.solution(money);
        assertThat(result).isEqualTo(expect);
    }

    @Test
    void pr_test2() {
        int[] money = {10, 1, 10};
        int expect = 10;
        Solution solution = new Solution();
        int result = solution.solution(money);
        assertThat(result).isEqualTo(expect);
    }

    @Test
    void pr_test3() {
        int[] money = {10, 1, 1, 10};
        int expect = 11;
        Solution solution = new Solution();
        int result = solution.solution(money);
        assertThat(result).isEqualTo(expect);
    }

    @Test
    void pr_test4() {
        int[] money = {1, 3, 10, 0};
        int expect = 11;
        Solution solution = new Solution();
        int result = solution.solution(money);
        assertThat(result).isEqualTo(expect);
    }

    @Test
    void pr_test5() {
        int[] money = {2, 10, 8, 0};
        int expect = 10;
        Solution solution = new Solution();
        int result = solution.solution(money);
        assertThat(result).isEqualTo(expect);
    }

    @Test
    void pr_test6() {
        int[] money = {1, 2, 3, 1};
        int expect = 4;
        Solution solution = new Solution();
        int result = solution.solution(money);
        assertThat(result).isEqualTo(expect);
    }

    @Test
    void pr_test7() {
        int[] money = {1, 1, 4, 1, 4};
        int expect = 8;
        Solution solution = new Solution();
        int result = solution.solution(money);
        assertThat(result).isEqualTo(expect);
    }

    @Test
    void pr_test8() {
        int[] money = {1000, 0, 1000, 0, 0, 1000, 0, 0, 1000};
        int expect = 3000;
        Solution solution = new Solution();
        int result = solution.solution(money);
        assertThat(result).isEqualTo(expect);
    }

    @Test
    void pr_test9() {
        int[] money = {10, 1, 0, 1, 2, 10, 0};
        int expect = 21;
        Solution solution = new Solution();
        int result = solution.solution(money);
        assertThat(result).isEqualTo(expect);
    }

    @Test
    void pr_test10() {
        int[] money = {10, 0, 0, 10, 0, 0, 10};
        int expect = 20;
        Solution solution = new Solution();
        int result = solution.solution(money);
        assertThat(result).isEqualTo(expect);
    }

    @Test
    void pr_test11() {
        int[] money = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int expect = 30;
        Solution solution = new Solution();
        int result = solution.solution(money);
        assertThat(result).isEqualTo(expect);
    }

    @Test
    void pr_test12() {
        int[] money = {0, 0, 0, 0, 100, 0, 0, 100, 0, 0, 1, 1};
        int expect = 201;
        Solution solution = new Solution();
        int result = solution.solution(money);
        assertThat(result).isEqualTo(expect);
    }

    @Test
    void pr_test13() {
        int[] money = {11, 0, 2, 5, 100, 100, 85, 1};
        int expect = 198;
        Solution solution = new Solution();
        int result = solution.solution(money);
        assertThat(result).isEqualTo(expect);
    }

    @Test
    void pr_test14() {
        int[] money = {1,2,3};
        int expect = 3;
        Solution solution = new Solution();
        int result = solution.solution(money);
        assertThat(result).isEqualTo(expect);
    }

    @Test
    void pr_test15() {
        int[] money = {91,90,5,7,5,7};
        int expect = 104;
        Solution solution = new Solution();
        int result = solution.solution(money);
        assertThat(result).isEqualTo(expect);
    }
    @Test
    void pr_test16() {
        int[] money = {90,0,0,95,1,1};
        int expect = 185;
        Solution solution = new Solution();
        int result = solution.solution(money);
        assertThat(result).isEqualTo(expect);
    }

    @Test
    void pr_test17() {
        int[] money = {1,2,3,4};
        int expect = 6;
        Solution solution = new Solution();
        int result = solution.solution(money);
        assertThat(result).isEqualTo(expect);
    }

    @Test
    void copy_array_test(){
        int[] ints = {5,10,15};
        int[] p = Arrays.copyOfRange(ints,1,3);
        for (int i : p) {
            System.out.println("i = " + i);
        }
    }
}
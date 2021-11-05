package com.codingtest.algorithm.programmers.q72411;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class q72411Test {
    @Test
    void pr_test(){
        String[] orders = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
        int[] c = {2,3,4};
        String[] exp = {"AC", "ACDE", "BCFG", "CDE"};
        Solution solution = new Solution();
        String[] result = solution.solution(orders, c);
        assertThat(result).isEqualTo(exp);
    }

    @Test
    void pr_test2(){
        String[] orders = {"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"};
        int[] c = {2,3,5};
        String[] exp = {"ACD", "AD", "ADE", "CD", "XYZ"};
        Solution solution = new Solution();
        String[] result = solution.solution(orders, c);
        assertThat(result).isEqualTo(exp);
    }

    @Test
    void pr_test3(){
        String[] orders = {"XYZ", "XWY", "WXA"};
        int[] c = {2,3,4};
        String[] exp = {"WX", "XY"};
        Solution solution = new Solution();
        String[] result = solution.solution(orders, c);
        assertThat(result).isEqualTo(exp);
    }

    @Test
    void pr_test4(){
        String[] orders = {"ABCD","ABCD","ABCD"};
        int[] c = {2,3,4};
        String[] exp = {"AB", "ABC", "ABCD", "ABD", "AC", "ACD", "AD", "BC", "BCD", "BD", "CD"};
        Solution solution = new Solution();
        String[] result = solution.solution(orders, c);
        assertThat(result).isEqualTo(exp);
    }
}
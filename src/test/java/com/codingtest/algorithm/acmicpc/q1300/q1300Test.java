package com.codingtest.algorithm.acmicpc.q1300;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class q1300Test {
    @Test
    void pr_test(){
        int n = 4;
        int[] input = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16};
        int[] exp = {1,2,2,3,3,4,4,4,6,6,8,8,9,12,12,16};

        for (int i = 0; i < input.length; i++) {
            assertThat(Main.solve(n,input[i])).isEqualTo(exp[i]);
        }
    }

}
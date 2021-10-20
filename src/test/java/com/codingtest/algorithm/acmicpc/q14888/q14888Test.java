package com.codingtest.algorithm.acmicpc.q14888;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class q14888Test {

    @Test
    void test1(){
        int n = 2;
        int[] array = {5,6};
        int[] op = {0,0,1,0};
        int[] expect = {30,30};

        Main main = new Main();
        int[] result = main.solution(n, array, op);
        assertThat(result).isEqualTo(expect);
    }

    @Test
    void test2(){
        int n = 3;
        int[] array = {3,4,5};
        int[] op = {1,0,1,0};
        int[] expect = {35,17};

        Main main = new Main();
        int[] result = main.solution(n, array, op);
        assertThat(result).isEqualTo(expect);
    }

    @Test
    void test3(){
        int n = 6;
        int[] array = {1,2,3,4,5,6};
        int[] op = {2,1,1,1};
        int[] expect = {54,-24};

        Main main = new Main();
        int[] result = main.solution(n, array, op);
        assertThat(result).isEqualTo(expect);
    }
}
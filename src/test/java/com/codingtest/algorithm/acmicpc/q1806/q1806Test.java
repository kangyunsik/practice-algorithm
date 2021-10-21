package com.codingtest.algorithm.acmicpc.q1806;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class q1806Test {
    @Test
    void test(){
        int n = 10;
        int s = 15;
        int[] array = {5,1,3,5,10,7,4,9,2,8};
        int expect = 2;

        Main main = new Main();
        int result = main.solution(n, s, array);
        assertThat(result).isEqualTo(expect);
    }

    @Test
    void test2(){
        int n = 10;
        int s = 1;
        int[] array = {2,2,2,2,2,2,2,2,2,2};
        int expect = 1;

        Main main = new Main();
        int result = main.solution(n, s, array);
        assertThat(result).isEqualTo(expect);
    }

    @Test
    void test3(){
        int n = 10;
        int s = 21;
        int[] array = {11,2,5,6,8,9,2,3,10,9,10};
        int expect = 3;

        Main main = new Main();
        int result = main.solution(n, s, array);
        assertThat(result).isEqualTo(expect);
    }

    @Test
    void test4(){
        int n = 10;
        int s = 10;
        int[] array = {1,1,1,1,1,1,1,1,1,10};
        int expect = 1;

        Main main = new Main();
        int result = main.solution(n, s, array);
        assertThat(result).isEqualTo(expect);
    }

    @Test
    void test5(){
        int n = 10;
        int s = 10;
        int[] array = {3,3,3,3,3,3,3,3,3,3};
        int expect = 4;

        Main main = new Main();
        int result = main.solution(n, s, array);
        assertThat(result).isEqualTo(expect);
    }

    @Test
    void test6(){
        int n = 4;
        int s = 5;
        int[] array = {1,2,2,3};
        int expect = 2;

        Main main = new Main();
        int result = main.solution(n, s, array);
        assertThat(result).isEqualTo(expect);
    }

    @Test
    void test7(){
        int n = 8;
        int s = 9;
        int[] array = {1,1,1,1,1,1,1,8};
        int expect = 2;

        Main main = new Main();
        int result = main.solution(n, s, array);
        assertThat(result).isEqualTo(expect);
    }

    @Test
    void test8(){
        int n = 10;
        int s = 100;
        int[] array = {32,23,42,2,94,3,1,45,37,4};
        int expect = 3;

        Main main = new Main();
        int result = main.solution(n, s, array);
        assertThat(result).isEqualTo(expect);
    }

    @Test
    void test9(){
        int n = 10;
        int s = 271;
        int[] array = {17,50,83,12,28,34,59,74,90,5};
        int expect = 5;

        Main main = new Main();
        int result = main.solution(n, s, array);
        assertThat(result).isEqualTo(expect);
    }
}
package com.codingtest.algorithm.q16953;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class q16953Test {
    @Test
    void test1(){
        int a = 2;
        int b = 162;
        int expected = 5;
        Main main = new Main(a,b);
        main.run();
        assertThat(main.getAnswer()).isEqualTo(expected);
    }

    @Test
    void test2(){
        int a = 4;
        int b = 42;
        int expected = -1;
        Main main = new Main(a,b);
        main.run();
        assertThat(main.getAnswer()).isEqualTo(expected);
    }

    @Test
    void test3(){
        int a = 100;
        int b = 40021;
        int expected = 5;
        Main main = new Main(a,b);
        main.run();
        assertThat(main.getAnswer()).isEqualTo(expected);
    }

    @Test
    void test4(){
        int a = 1;
        int b = 1000000000;
        int expected = -1;
        Main main = new Main(a,b);
        main.run();
        assertThat(main.getAnswer()).isEqualTo(expected);
    }
}
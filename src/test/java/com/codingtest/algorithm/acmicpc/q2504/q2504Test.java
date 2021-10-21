package com.codingtest.algorithm.acmicpc.q2504;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class q2504Test {
    @Test
    void pr_test(){
        String s = "(()[[]])([])";
        int expect = 28;
        Main main = new Main();
        int result = main.solution(s);
        assertThat(result).isEqualTo(expect);
    }

    @Test
    void pr_test2(){
        String s = "[][]((])";
        int expect = 0;
        Main main = new Main();
        int result = main.solution(s);
        assertThat(result).isEqualTo(expect);
    }

    @Test
    void pr_test3(){
        String s = "[";
        int expect = 0;
        Main main = new Main();
        int result = main.solution(s);
        assertThat(result).isEqualTo(expect);
    }

    @Test
    void pr_test4(){
        String s = "]";
        int expect = 0;
        Main main = new Main();
        int result = main.solution(s);
        assertThat(result).isEqualTo(expect);
    }

    @Test
    void pr_test5(){
        String s = "]()";
        int expect = 0;
        Main main = new Main();
        int result = main.solution(s);
        assertThat(result).isEqualTo(expect);
    }

    @Test
    void pr_test6(){
        String s = "(())[[]])";
        int expect = 0;
        Main main = new Main();
        int result = main.solution(s);
        assertThat(result).isEqualTo(expect);
    }

    @Test
    void pr_test7(){
        String s = "()(";
        int expect = 0;
        Main main = new Main();
        int result = main.solution(s);
        assertThat(result).isEqualTo(expect);
    }
}
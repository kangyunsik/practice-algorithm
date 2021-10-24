package com.codingtest.algorithm.acmicpc.q1036;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class q1036Test {
    @Test
    void reverseTest(){
        Main main  = new Main();
        assertThat(main.getReverseValue('H')).isEqualTo('I');
    }

    @Test
    void addTest(){
        String s = "TO";
        String b = "BE";
        String exp = "152";
        Main main = new Main();
        assertThat(main.myAdd(s,b,false)).isEqualTo(exp);
    }

    @Test
    void pr_test1(){
        int n = 5;
        int k = 7;
        String[] strings = new String("GOOD\n" +
                "LUCK\n" +
                "AND\n" +
                "HAVE\n" +
                "FUN").split("\n");
        String exp = "31YUB";
        Main main = new Main();
        String result = main.solution(n, strings, k);
        assertThat(result).isEqualTo(exp);
    }

    @Test
    void pr_test2(){
        int n = 1;
        int k = 2;
        String[] strings = new String("HELLO").split("\n");
        String exp = "ZZLLO";
        Main main = new Main();
        String result = main.solution(n, strings, k);
        assertThat(result).isEqualTo(exp);
    }

    @Test
    void pr_test3(){
        int n = 5;
        int k = 5;
        String[] strings = new String("500\n" +
                "POINTS\n" +
                "FOR\n" +
                "THIS\n" +
                "PROBLEM").split("\n");
        String exp = "1100TC85";
        Main main = new Main();
        String result = main.solution(n, strings, k);
        assertThat(result).isEqualTo(exp);
    }

    @Test
    void pr_test4(){
        int n = 6;
        int k = 0;
        String[] strings = new String("TO\n" +
                "BE\n" +
                "OR\n" +
                "NOT\n" +
                "TO\n" +
                "BE").split("\n");
        String exp = "QNO";
        Main main = new Main();
        String result = main.solution(n, strings, k);
        assertThat(result).isEqualTo(exp);
    }

    @Test
    void pr_test5(){
        int n = 1;
        int k = 36;
        String[] strings = new String("KEQUALS36").split("\n");
        String exp = "ZZZZZZZZZ";
        Main main = new Main();
        String result = main.solution(n, strings, k);
        assertThat(result).isEqualTo(exp);
    }

    @Test
    void pr_test6(){
        int n = 2;
        int k = 10;
        String[] strings = {"A","B"};
        String exp = "L";
        Main main = new Main();
        String result = main.solution(n, strings, k);
        assertThat(result).isEqualTo(exp);
    }
}
package com.codingtest.algorithm.acmicpc.q2143;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class q2143Test {

    @Test
    void test1(){
        int t = 5;
        int n = 4;
        int m = 3;
        long answer = 7;
        String as = ("1 3 1 2");
        String bs = ("1 3 2");
        Main main = new Main(t);
        main.setA(n,as);
        main.setB(m,bs);
        main.run();
        assertThat(main.getAnswer()).isEqualTo(answer);
    }

    @Test
    void test2(){
        int t = 500;
        int n = 1000;
        int m = 1000;
        long answer = 1682421;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n-1; i++) {
            sb.append(i + 1).append(" ");
        }
        sb.append("1000");
        String as = sb.toString();

        sb = new StringBuilder();
        for (int i = 0; i < m - 1; i++) {
            if(i%2 == 0)
                sb.append(-(i + 1)).append(" ");
            else
                sb.append(i + 1).append(" ");
        }
        sb.append("999");
        String bs = sb.toString();

        Main main = new Main(t);
        main.setA(n,as);
        main.setB(m,bs);
        main.run();
        assertThat(main.getAnswer()).isEqualTo(answer);
    }
}
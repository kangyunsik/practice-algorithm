package com.codingtest.algorithm.acmicpc.q1043;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class q1043Test {

    @Test
    void test1(){
        int n = 4;
        int m = 3;
        int answer = 3;
        String init = "0";
        String[] strings = ("2 1 2\n" +
                "1 3\n" +
                "3 2 3 4").split("\n");
        Main main = new Main(n,m);
        main.setKnow(init);
        for (int i = 0; i < m; i++) {
            main.set(i,strings[i]);
        }
        main.run();
        assertThat(main.getAnswer()).isEqualTo(answer);
    }

    @Test
    void test2(){
        int n = 4;
        int m = 1;
        int answer = 0;
        String init = "1 1";
        String[] strings = ("4 1 2 3 4").split("\n");
        Main main = new Main(n,m);
        main.setKnow(init);
        for (int i = 0; i < m; i++) {
            main.set(i,strings[i]);
        }
        main.run();
        assertThat(main.getAnswer()).isEqualTo(answer);
    }

    @Test
    void test3(){
        int n = 4;
        int m = 1;
        int answer = 1;
        String init = "0";
        String[] strings = ("4 1 2 3 4").split("\n");
        Main main = new Main(n,m);
        main.setKnow(init);
        for (int i = 0; i < m; i++) {
            main.set(i,strings[i]);
        }
        main.run();
        assertThat(main.getAnswer()).isEqualTo(answer);
    }

    @Test
    void test4(){
        int n = 4;
        int m = 5;
        int answer = 2;
        String init = "1 1";
        String[] strings = ("1 1\n" +
                "1 2\n" +
                "1 3\n" +
                "1 4\n" +
                "2 4 1").split("\n");
        Main main = new Main(n,m);
        main.setKnow(init);
        for (int i = 0; i < m; i++) {
            main.set(i,strings[i]);
        }
        main.run();
        assertThat(main.getAnswer()).isEqualTo(answer);
    }

    @Test
    void test5(){
        int n = 10;
        int m = 9;
        int answer = 4;
        String init = "4 1 2 3 4";
        String[] strings = ("2 1 5\n" +
                "2 2 6\n" +
                "1 7\n" +
                "1 8\n" +
                "2 7 8\n" +
                "1 9\n" +
                "1 10\n" +
                "2 3 10\n" +
                "1 4").split("\n");
        Main main = new Main(n,m);
        main.setKnow(init);
        for (int i = 0; i < m; i++) {
            main.set(i,strings[i]);
        }
        main.run();
        assertThat(main.getAnswer()).isEqualTo(answer);
    }

    @Test
    void test6(){
        int n = 8;
        int m = 5;
        int answer = 5;
        String init = "3 1 2 7";
        String[] strings = ("2 3 4\n" +
                "1 5\n" +
                "2 5 6\n" +
                "2 6 8\n" +
                "1 8").split("\n");
        Main main = new Main(n,m);
        main.setKnow(init);
        for (int i = 0; i < m; i++) {
            main.set(i,strings[i]);
        }
        main.run();
        assertThat(main.getAnswer()).isEqualTo(answer);
    }

    @Test
    void test7(){
        int n = 3;
        int m = 4;
        int answer = 0;
        String init = "1 3";
        String[] strings = ("1 1\n" +
                "1 2\n" +
                "2 1 2\n" +
                "3 1 2 3").split("\n");
        Main main = new Main(n,m);
        main.setKnow(init);
        for (int i = 0; i < m; i++) {
            main.set(i,strings[i]);
        }
        main.run();
        assertThat(main.getAnswer()).isEqualTo(answer);
    }
}
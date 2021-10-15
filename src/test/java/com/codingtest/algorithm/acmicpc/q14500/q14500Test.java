package com.codingtest.algorithm.acmicpc.q14500;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class q14500Test {
    @Test
    void test(){
        int n = 5;
        int m = 5;
        String[] input = ("1 2 3 4 5\n" +
                "5 4 3 2 1\n" +
                "2 3 4 5 6\n" +
                "6 5 4 3 2\n" +
                "1 2 1 2 1").split("\n");
        Main main = new Main(n,m);
        for (int i = 0; i < n; i++) {
            main.set(i,input[i]);
        }
        main.run();
        assertThat(main.getAnswer()).isEqualTo(19);
    }

    @Test
    void test2(){
        int n = 4;
        int m = 5;
        String[] input = ("1 2 3 4 5\n" +
                "1 2 3 4 5\n" +
                "1 2 3 4 5\n" +
                "1 2 3 4 5").split("\n");
        Main main = new Main(n,m);
        for (int i = 0; i < n; i++) {
            main.set(i,input[i]);
        }
        main.run();
        assertThat(main.getAnswer()).isEqualTo(20);
    }

    @Test
    void test3(){
        int n = 4;
        int m = 10;
        String[] input = ("1 2 1 2 1 2 1 2 1 2\n" +
                "2 1 2 1 2 1 2 1 2 1\n" +
                "1 2 1 2 1 2 1 2 1 2\n" +
                "2 1 2 1 2 1 2 1 2 1").split("\n");
        Main main = new Main(n,m);
        for (int i = 0; i < n; i++) {
            main.set(i,input[i]);
        }
        main.run();
        assertThat(main.getAnswer()).isEqualTo(7);
    }

    @Test
    void init_test(){
        Main main = new Main(4,5);
        testPrint(main.puzzle.states);
    }

    void testPrint(List<int[][]> states) {
        for (int r = 0; r < states.size(); r++) {
            System.out.println("r = " + r);
            for (int i = 0; i < states.get(r).length; i++) {
                for (int j = 0; j < states.get(r)[i].length; j++) {
                    System.out.print(states.get(r)[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println("-------------------------");
        }
    }
}
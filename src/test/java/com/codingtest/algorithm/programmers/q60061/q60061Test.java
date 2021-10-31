package com.codingtest.algorithm.programmers.q60061;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class q60061Test {
    @Test
    void pr_test1(){
        int n = 5;
        int[][] builds = {{1,0,0,1},{1,1,1,1},{2,1,0,1},{2,2,1,1},{5,0,0,1},{5,1,0,1},{4,2,1,1},{3,2,1,1}};
        int[][] exp = {{1,0,0},{1,1,1},{2,1,0},{2,2,1},{3,2,1},{4,2,1},{5,0,0},{5,1,0}};

        Solution solution = new Solution();
        int[][] result = solution.solution(n, builds);
        assertThat(result).isEqualTo(exp);
        for (int[] ints : result) {
            for(int p : ints){
                System.out.print(p+" ");
            }
            System.out.println();
        }
    }

    @Test
    void pr_test2(){
        int n = 5;
        int[][] builds = {{0,0,0,1},{2,0,0,1},{4,0,0,1},{0,1,1,1},{1,1,1,1},{2,1,1,1},{3,1,1,1},{2,0,0,0},{1,1,1,0},{2,2,0,1}};
        int[][] exp = {{0,0,0},{0,1,1},{1,1,1},{2,1,1},{3,1,1},{4,0,0}};

        Solution solution = new Solution();
        int[][] result = solution.solution(n, builds);
        assertThat(result).isEqualTo(exp);
        for (int[] ints : result) {
            for(int p : ints){
                System.out.print(p+" ");
            }
            System.out.println();
        }
    }
}
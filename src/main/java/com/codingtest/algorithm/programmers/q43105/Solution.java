package com.codingtest.algorithm.programmers.q43105;

import java.util.Arrays;

class Solution {
    int[][] dp;
    int[][] matrix;

    public int solution(int[][] triangle) {

        int lx = triangle.length;
        int ly = triangle[lx - 1].length;
        dp = new int[lx][ly];
        matrix = triangle;

        // Init DP array
        for (int[] ints : dp) Arrays.fill(ints, -1);
        for (int i = 0; i < dp[ly-1].length; i++) {
            dp[lx - 1][i] = triangle[lx - 1][i];
        }
        // GetAnswer by recursion
        return getAnswer(0, 0);
    }

    private int getAnswer(int i, int j) {
        if (dp[i][j] == -1)
            dp[i][j] = matrix[i][j] + Math.max(getAnswer(i + 1, j), getAnswer(i + 1, j + 1));
        return dp[i][j];
    }
}
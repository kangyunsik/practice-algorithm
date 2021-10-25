package com.codingtest.algorithm.programmers.q42898;

import java.util.Arrays;

class Solution {
    int[][] matrix;
    private final int mod = 1000000007;

    public int solution(int m, int n, int[][] puddles) {
        matrix = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(matrix[i], -1);
        }
        matrix[0][0] = 1;

        for (int[] puddle : puddles) {
            matrix[puddle[1] - 1][puddle[0] - 1] = 0;
        }

        return getDP(n - 1, m - 1);
    }

    public int getDP(int a, int b) {
        if (matrix[a][b] != -1)
            return matrix[a][b];
        else if (matrix[a][b] == 0)
            return 0;

        if(a==0)
            matrix[a][b] = getDP(a,b-1);
        else if(b==0)
            matrix[a][b] = getDP(a-1,b);
        else
            matrix[a][b] = (getDP(a - 1, b) + getDP(a, b - 1)) % mod;

        return matrix[a][b];
    }
}
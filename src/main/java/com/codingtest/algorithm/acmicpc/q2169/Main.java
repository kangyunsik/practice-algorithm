package com.codingtest.algorithm.acmicpc.q2169;

import java.io.*;
import java.util.*;

public class Main {

    static int n, m;
    static int[][] v;
    static int[][][] mem; // [0] = by Up, [1] = by Left, [2] = by Right
    static final int MIN = -1000000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = new int[n][m];
        mem = new int[n][m][3];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                Arrays.fill(mem[i][j], MIN);
            }
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                v[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        rightSlash(0, 0, 0);
        for (int i = 1; i < n; i++) {
            getMaxByUpper(i);
            rightSlash(i, 1, mem[i][0][0]);
            leftSlash(i, m - 2, mem[i][m - 1][0]);
        }

        int[] temp = mem[n - 1][m - 1];
        int ans = Math.max(temp[0], Math.max(temp[1], temp[2]));
        System.out.println(ans);
    }

    private static void leftSlash(int row, int col, int score) {
        if(col < 0) return;

        mem[row][col][2] = Math.max(Math.max(mem[row][col][2], mem[row][col][0]), score + v[row][col]);
        leftSlash(row, col - 1, mem[row][col][2]);
    }

    private static void rightSlash(int row, int col, int score) {
        if (col >= m) return;

        mem[row][col][1] = Math.max(Math.max(mem[row][col][1], mem[row][col][0]), score + v[row][col]);
        rightSlash(row, col + 1, mem[row][col][1]);
    }

    private static void getMaxByUpper(int row) {
        for (int col = 0; col < m; col++) {
            mem[row][col][0] = Math.max(mem[row - 1][col][0],
                    Math.max(mem[row - 1][col][1], mem[row - 1][col][2]));
            mem[row][col][0] += v[row][col];
        }
    }
}
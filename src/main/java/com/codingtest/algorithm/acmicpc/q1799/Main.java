package com.codingtest.algorithm.acmicpc.q1799;

import java.io.*;
import java.util.*;

public class Main {
    static int[][] board;
    static int[] dia, revDia;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        board = new int[n][n];
        dia = new int[n * 2];
        revDia = new int[n * 2];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(backtrack(0, 0) + backtrack(1, 0));
    }

    private static int backtrack(int cur, int num) {
        if (cur >= n * n) {
            return num;
        }

        int row = cur / n;
        int col = cur % n;
        int nextCur = getNextCur(cur);
        int ret = backtrack(nextCur, num);
        if (board[row][col] == 1 && isPutable(row, col)) {
            putQueen(row, col);
            ret = Math.max(ret, backtrack(nextCur, num + 1));
            popQueen(row, col);
        }
        return ret;
    }

    private static int getNextCur(int cur) {
        if ((n & 1) == 0 && cur % n >= n - 2) {
            return cur + 3 - (cur & 1) * 2;
        }else{
            return cur + 2;
        }
    }

    private static boolean isPutable(int row, int col) {
        return dia[getDirIdx(row, col)] == 0 && revDia[getRevDirIdx(row, col)] == 0;
    }

    private static void putQueen(int row, int col) {
        dia[getDirIdx(row, col)]++;
        revDia[getRevDirIdx(row, col)]++;
    }

    private static void popQueen(int row, int col) {
        dia[getDirIdx(row, col)]--;
        revDia[getRevDirIdx(row, col)]--;
    }

    private static int getRevDirIdx(int row, int col) {
        return row + col;
    }

    private static int getDirIdx(int row, int col) {
        return col - row + n;
    }
}
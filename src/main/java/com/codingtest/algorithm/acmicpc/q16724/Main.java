package com.codingtest.algorithm.acmicpc.q16724;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static String[] board;
    static int[][] divisor;
    static int n, m, divCnt;
    static final char[] dirMapper = new char[100];
    static final int[] dr = {-1, 0, 1, 0};
    static final int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new String[n];
        divisor = new int[n][m];
        dirMapper['U'] = 0;
        dirMapper['R'] = 1;
        dirMapper['D'] = 2;
        dirMapper['L'] = 3;
        for (int i = 0; i < n; i++) {
            board[i] = br.readLine();
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (divisor[i][j] > 0) continue;
                find(i, j, 0);
            }
        }
        System.out.println(divCnt);
    }

    private static int find(int r, int c, int depth) {
        if (divisor[r][c] > 0) return divisor[r][c];
        if (divisor[r][c] == -1) return ++divCnt;
        divisor[r][c] = -1;
        int dir = dirMapper[board[r].charAt(c)];
        return divisor[r][c] = find(r + dr[dir], c + dc[dir], depth + 1);
    }
}

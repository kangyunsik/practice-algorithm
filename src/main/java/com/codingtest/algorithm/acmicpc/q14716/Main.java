package com.codingtest.algorithm.acmicpc.q14716;

import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int[][] board;
    static final int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
    static final int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.println(findAns());
    }

    private static int findAns() {
        int ret = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] == 0) continue;
                ret++;
                checkDFS(i, j);
            }
        }
        return ret;
    }

    private static void checkDFS(int R, int C) {
        if(isInvalidRange(R, C) || board[R][C] == 0) return;
        board[R][C] = 0;
        for (int dir = 0; dir < dr.length; dir++) {
            checkDFS(R + dr[dir], C + dc[dir]);
        }
    }

    private static boolean isInvalidRange(int r, int c) {
        return r < 0 || c < 0 || r >= N || c >= M;
    }
}

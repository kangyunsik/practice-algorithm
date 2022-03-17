package com.codingtest.algorithm.acmicpc.q17136;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static final int BOARD_SIZE = 10;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int[][] board = new int[BOARD_SIZE][BOARD_SIZE];
        for (int i = 0; i < BOARD_SIZE; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < BOARD_SIZE; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int ans = dfs(0, board, new int[]{5, 5, 5, 5, 5}, 0);
        if (ans == Integer.MAX_VALUE) ans = -1;
        bw.write(String.valueOf(ans));
        bw.flush();
    }

    private static int dfs(int seq, int[][] board, int[] remain, int cost) {
        if (seq == BOARD_SIZE * BOARD_SIZE) {
            return cost;
        }

        int row = seq / BOARD_SIZE;
        int col = seq % BOARD_SIZE;
        if (board[row][col] == 0) {
            return dfs(seq + 1, board, remain, cost);
        } else {
            int ret = Integer.MAX_VALUE;
            for (int i = 5; i > 0; i--) {
                if (!isValidRange(row + i, col + i)) continue;
                if (!isFullOne(board, row, col, i)) continue;
                if (remain[i - 1] == 0) continue;
                fillBoard(board, row, col, i, 0);
                remain[i - 1]--;
                ret = Math.min(ret, dfs(seq + 1, board, remain, cost + 1));
                fillBoard(board, row, col, i, 1);
                remain[i - 1]++;
            }
            return ret;
        }
    }

    private static boolean isFullOne(int[][] board, int r, int c, int dist) {
        for (int i = r; i < r + dist; i++) {
            for (int j = c; j < c + dist; j++) {
                if (board[i][j] == 0) return false;
            }
        }
        return true;
    }

    private static void fillBoard(int[][] board, int r, int c, int dist, int target) {
        for (int i = r; i < r + dist; i++) {
            for (int j = c; j < c + dist; j++) {
                board[i][j] = target;
            }
        }
    }

    private static boolean isValidRange(int r, int c) {
        return r <= BOARD_SIZE && c <= BOARD_SIZE;
    }
}

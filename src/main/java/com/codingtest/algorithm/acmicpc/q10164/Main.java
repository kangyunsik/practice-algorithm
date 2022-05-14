package com.codingtest.algorithm.acmicpc.q10164;

import java.io.*;
import java.util.*;

public class Main {

    static long[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        board = new long[n + 1][m + 1];
        int r = (k - 1) / m + 1;
        int c = (k - 1) % m + 1;
        for (int i = 1; i <= c; i++) {
            board[1][i] = 1;
        }
        for (int i = 1; i <= r; i++) {
            board[i][1] = 1;
        }

        for (int i = 1; i <= r; i++) {
            for (int j = 1; j <= c; j++) {
                if (board[i][j] == 0) {
                    board[i][j] = board[i - 1][j] + board[i][j - 1];
                }
            }
        }

        for (int i = r; i <= n; i++) {
            for (int j = c; j <= m; j++) {
                if(board[i][j] > 0) continue;

                if (i > 0) {
                    board[i][j] += board[i - 1][j];
                }
                if (j > 0) {
                    board[i][j] += board[i][j - 1];
                }
            }
        }
        System.out.println(board[n][m]);
    }
}
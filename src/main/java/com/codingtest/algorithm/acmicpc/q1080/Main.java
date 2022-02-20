package com.codingtest.algorithm.acmicpc.q1080;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static boolean[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        board = new boolean[n][m];
        String input;
        for (int i = 0; i < n; i++) {
            input = br.readLine();
            for (int j = 0; j < m; j++) {
                if (input.charAt(j) == '1') board[i][j] = true;
            }
        }

        for (int i = 0; i < n; i++) {
            input = br.readLine();
            for (int j = 0; j < m; j++) {
                if (input.charAt(j) == '1') board[i][j] = !board[i][j];
            }
        }

        int ans = 0;
        for (int i = 0; i < n - 2; i++) {
            for (int j = 0; j < m - 2; j++) {
                if (board[i][j]) {
                    reverse(i, j);
                    ans++;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j]) {
                    ans = -1;
                    break;
                }
            }
        }

        bw.write(String.valueOf(ans));
        bw.flush();
    }

    private static void reverse(int x, int y) {
        for (int i = x; i < x + 3; i++) {
            for (int j = y; j < y + 3; j++) {
                board[i][j] = !board[i][j];
            }
        }
    }
}

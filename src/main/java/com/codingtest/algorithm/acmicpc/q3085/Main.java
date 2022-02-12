package com.codingtest.algorithm.acmicpc.q3085;

import java.io.*;

public class Main {
    static char[][] board;
    static int n, ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        board = new char[n][];
        for (int i = 0; i < n; i++) {
            board[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j + 1 < n && board[i][j] != board[i][j + 1]) {
                    swap(i, j, i, j + 1);
                    updateAns();
                    swap(i, j, i, j + 1);
                }
                if (i + 1 < n && board[i][j] != board[i + 1][j]) {
                    swap(i, j, i + 1, j);
                    updateAns();
                    swap(i, j, i + 1, j);
                }

            }
        }
        bw.write(String.valueOf(ans));
        bw.flush();
    }

    private static void updateAns() {
        char row;
        char col;
        for (int i = 0, rowIdx = 0, colIdx = 0; i < n; i++) {
            row = '?';
            col = '?';
            for (int j = 0; j < n; j++) {
                if(row == board[i][j]){
                    ans = Math.max(ans, ++rowIdx);
                }else{
                    row = board[i][j];
                    rowIdx = 1;
                }

                if(col == board[j][i]){
                    ans = Math.max(ans, ++colIdx);
                }else{
                    col = board[j][i];
                    colIdx = 1;
                }
            }
        }

    }

    private static void swap(int x1, int y1, int x2, int y2) {
        char temp = board[x1][y1];
        board[x1][y1] = board[x2][y2];
        board[x2][y2] = temp;
    }
}

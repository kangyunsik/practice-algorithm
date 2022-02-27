package com.codingtest.algorithm.acmicpc.q10993;

import java.io.*;
import java.util.Arrays;

public class Main {
    static char[][] board;
    static int C;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        C = (1 << (n + 1)) - 3;
        board = new char[(1 << n) - 1][C];
        for (char[] chars : board) {
            Arrays.fill(chars, ' ');
        }
        if (n % 2 == 0) {
            drawEven(n, board.length - 1);
            for (int i = 0; i < board.length; i++) {
                bw.write(new String(board[i]).substring(0, board[i].length - i));
                bw.newLine();
            }
        } else {
            drawOdd(n, 0);
            for (int i = 0; i < board.length; i++) {
                bw.write(new String(board[i]).substring(0, C / 2 + 1 + i));
                bw.newLine();
            }
        }
        bw.flush();
    }

    private static void drawOdd(int n, int row) {
        int midCol = C / 2;
        for (int i = 0; i < ((1 << (n + 1)) - 3) / 2 + 1; i++) {
            board[row + i][midCol + i] = '*';
            board[row + i][midCol - i] = '*';
        }
        for (int i = 0; i < ((1 << (n + 1)) - 3) / 2; i++) {
            board[row + (1 << n) - 2][midCol + i] = '*';
            board[row + (1 << n) - 2][midCol - i] = '*';
        }
        drawEven(n - 1, row + ((1 << n) - 1) - 2);
    }

    private static void drawEven(int n, int row) {
        if (n == 0) return;
        int midCol = C / 2;
        for (int i = 0; i < (1 << n) - 1; i++) {
            board[row - i][midCol + i] = '*';
            board[row - i][midCol - i] = '*';
        }
        for (int i = 0; i < ((1 << (n + 1)) - 3) / 2; i++) {
            board[row - (1 << n) + 2][midCol + i] = '*';
            board[row - (1 << n) + 2][midCol - i] = '*';
        }
        drawOdd(n - 1, row - ((1 << n) - 1) + 2);
    }
}

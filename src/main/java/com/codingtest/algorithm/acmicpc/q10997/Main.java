package com.codingtest.algorithm.acmicpc.q10997;

import java.io.*;

public class Main {
    static char[][] board;
    static final int[] dr = {0, 1, 0, -1};
    static final int[] dc = {-1, 0, 1, 0};

    static int row, col;
    static int direct = 0;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        if (N == 1) {
            bw.append("*");
            bw.flush();
        } else {
            row = 4 * N - 1;
            col = 4 * N - 3;
            board = new char[row][col];
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    board[i][j] = ' ';
                }
            }
            queue();
            printBoard();
        }
    }

    private static void printBoard() throws IOException {
        for (char[] chars : board) {
            bw.write(new String(chars).trim());
            bw.newLine();
        }
        bw.flush();
    }

    private static void queue() {
        for (int r = 0, c = col - 1; r != row / 2 + 1 || c != col / 2; ) {
            board[r][c] = '*';
            int nextR = r + dr[direct];
            int nextC = c + dc[direct];
            if (!isValidRange(nextR, nextC)
                    || isNextAlready(nextR + dr[direct], nextC + dc[direct])) {
                direct = (direct + 1) % 4;
                nextR = r + dr[direct];
                nextC = c + dc[direct];
            }
            r = nextR;
            c = nextC;
        }
        board[row / 2 + 1][col / 2] = '*';
    }

    private static boolean isNextAlready(int r, int c) {
        return isValidRange(r, c) && board[r][c] == '*';
    }

    private static boolean isValidRange(int r, int c) {
        return r >= 0 && c >= 0 && r < row && c < col;
    }
}

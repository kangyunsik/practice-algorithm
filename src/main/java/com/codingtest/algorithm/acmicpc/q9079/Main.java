package com.codingtest.algorithm.acmicpc.q9079;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int ans;
    static char[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int test_case = 0; test_case < T; test_case++) {
            board = new char[3][3];
            ans = Integer.MAX_VALUE;
            for (int i = 0; i < 3; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < 3; j++) {
                    board[i][j] = st.nextToken().charAt(0);
                }
            }

            for (int i = 0; i < (1 << 8); i++) {
                reverseBySeq(i);
                if (isAllMatch()) ans = Math.min(ans, Integer.bitCount(i));
                reverseBySeq(i);
            }

            if (ans == Integer.MAX_VALUE) ans = -1;
            bw.append(String.valueOf(ans));
            bw.newLine();
        }
        bw.flush();
    }

    private static boolean isAllMatch() {
        char one = board[0][0];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (one != board[i][j]) return false;
            }
        }
        return true;
    }

    private static void reverseBySeq(int flag) {
        for (int i = 0; flag > 0; i++, flag /= 2) {
            if ((flag & 1) == 0) continue;
            if (i >= 6) reverseDiagonal(i - 6);
            else if (i >= 3) reverseCol(i - 3);
            else reverseRow(i);
        }
    }

    private static void reverseDiagonal(int opt) {
        if (opt == 0) {
            for (int i = 0; i < 3; i++) {
                board[i][i] = (char) ('H' + 'T' - board[i][i]);
            }
        } else {
            for (int i = 0; i < 3; i++) {
                board[2 - i][i] = (char) ('H' + 'T' - board[2 - i][i]);
            }
        }
    }

    private static void reverseCol(int colNum) {
        for (int i = 0; i < 3; i++) {
            board[i][colNum] = (char) ('H' + 'T' - board[i][colNum]);
        }
    }

    private static void reverseRow(int rowNum) {
        for (int i = 0; i < 3; i++) {
            board[rowNum][i] = (char) ('H' + 'T' - board[rowNum][i]);
        }
    }
}

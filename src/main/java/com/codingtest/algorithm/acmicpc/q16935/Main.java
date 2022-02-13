package com.codingtest.algorithm.acmicpc.q16935;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int[][] board;
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine(), " ");
        while (st.hasMoreTokens()) {
            int opt = Integer.parseInt(st.nextToken());
            switch (opt) {
                case 1:
                    function1();
                    break;
                case 2:
                    function2();
                    break;
                case 3:
                    function3();
                    break;
                case 4:
                    function4();
                    break;
                case 5:
                    function5();
                    break;
                case 6:
                    function6();
                    break;
            }
        }
        for (int[] temp : board) {
            for (int v : temp) {
                sb.append(v).append(" ");
            }
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }

    private static void function6() {
        int[][] leftTop = new int[n / 2][m / 2];
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < m / 2; j++) {
                leftTop[i][j] = board[i][j];
            }
        }

        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < m / 2; j++) {
                board[i][j] = board[i][j + m / 2];
                board[i][j + m / 2] = board[i + n / 2][j + m / 2];
                board[i + n / 2][j + m / 2] = board[i + n / 2][j];
                board[i + n / 2][j] = leftTop[i][j];
            }
        }
    }

    private static void function5() {
        int[][] leftTop = new int[n / 2][m / 2];
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < m / 2; j++) {
                leftTop[i][j] = board[i][j];
            }
        }

        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < m / 2; j++) {
                board[i][j] = board[i + n / 2][j];
                board[i + n / 2][j] = board[i + n / 2][j + m / 2];
                board[i + n / 2][j + m / 2] = board[i][j + m / 2];
                board[i][j + m / 2] = leftTop[i][j];
            }
        }
    }

    private static void function4() {
        int[][] temp = new int[m][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                temp[m - 1 - j][i] = board[i][j];
            }
        }
        board = temp;
        m = n;
        n = temp.length;
    }

    private static void function3() {
        int[][] temp = new int[m][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                temp[j][n - 1 - i] = board[i][j];
            }
        }
        board = temp;
        m = n;
        n = temp.length;
    }

    private static void function2() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m / 2; j++) {
                int temp = board[i][j];
                board[i][j] = board[i][m - 1 - j];
                board[i][m - 1 - j] = temp;
            }
        }
    }

    private static void function1() {
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < m; j++) {
                int temp = board[i][j];
                board[i][j] = board[n - 1 - i][j];
                board[n - 1 - i][j] = temp;
            }
        }
    }
}

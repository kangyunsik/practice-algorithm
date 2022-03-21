package com.codingtest.algorithm.acmicpc.q18428;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static char[][] board;
    static int n;
    static boolean ans;
    static final int[] dr = {0, 0, 1, -1};
    static final int[] dc = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        board = new char[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                board[i][j] = st.nextToken().charAt(0);
            }
        }
        findCases(0, 0);
        bw.write(ans ? "YES" : "NO");
        bw.flush();
    }

    private static void findCases(int depth, int cnt) {
        if (cnt == 3) {
            if (isValidBoard()) ans = true;
            return;
        }
        if (depth == n * n) return;
        int row = depth / n;
        int col = depth % n;
        findCases(depth + 1, cnt);
        if (board[row][col] == 'X') {
            board[row][col] = 'O';
            findCases(depth + 1, cnt + 1);
            board[row][col] = 'X';
        }
    }

    private static boolean isValidBoard() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] != 'T') continue;
                for (int k = 0; k < 4; k++) {
                    if (findWay(i, j, k)) return false;
                }
            }
        }
        return true;
    }

    private static boolean findWay(int r, int c, int dir) {
        int nextR = r + dr[dir];
        int nextC = c + dc[dir];
        if (isValidRange(nextR, nextC)) {
            if (board[nextR][nextC] == 'S') return true;
            if (board[nextR][nextC] != 'O') return findWay(nextR, nextC, dir);
        }
        return false;
    }

    private static boolean isValidRange(int r, int c) {
        return r >= 0 && c >= 0 && r < n && c < n;
    }
}

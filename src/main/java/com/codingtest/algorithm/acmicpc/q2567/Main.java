package com.codingtest.algorithm.acmicpc.q2567;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static boolean[][] board;
    static int[][] checked;
    //    static final int[] dx = {1, 1, 1, -1, -1, -1, 0, 0};
//    static final int[] dy = {1, 0, -1, 1, 0, -1, 1, -1};
    static final int[] dx = {0, 0, 1, -1};
    static final int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int x, y;
        int n = Integer.parseInt(br.readLine());
        board = new boolean[101][101];
        checked = new int[101][101];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            draw(x, y);
        }
        calc();
        int cnt = 0;
        for (int i = 0; i <= 100; i++) {
            for (int j = 0; j <= 100; j++) {
                cnt += checked[i][j];
            }
        }
        bw.write(String.valueOf(cnt));
        bw.flush();
    }

    private static void calc() {
        for (int i = 0; i <= 100; i++) {
            for (int j = 0; j <= 100; j++) {
                if (board[i][j]) continue;
                check(i, j);
            }
        }
    }

    private static void check(int x, int y) {
        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];
            if (isValidRange(nextX, nextY) && board[nextX][nextY]) {
                checked[nextX][nextY]++;
            }
        }
    }

    private static boolean isValidRange(int x, int y) {
        return x >= 0 && y >= 0 && x <= 100 && y <= 100;
    }

    private static void draw(int x, int y) {
        for (int i = x; i < x + 10; i++) {
            for (int j = y; j < y + 10; j++) {
                board[i][j] = true;
            }
        }
    }
}

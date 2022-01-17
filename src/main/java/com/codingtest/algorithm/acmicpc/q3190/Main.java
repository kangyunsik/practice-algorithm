package com.codingtest.algorithm.acmicpc.q3190;

import java.io.*;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
    static int[][] board;   // 0 : default / 1 : apple / 2 : snake
    static final int[] dx = {1, 0, -1, 0};    // D -> ++ / C -> --
    static final int[] dy = {0, -1, 0, 1};
    static int n, direct = 3;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int a, x, y, k, changeIdx = 0, ans = 0;
        int[][] change;
        ArrayDeque<Position> deque = new ArrayDeque<>();

        n = Integer.parseInt(br.readLine());
        a = Integer.parseInt(br.readLine());
        board = new int[n][n];
        for (int i = 0; i < a; i++) {
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken()) - 1;
            y = Integer.parseInt(st.nextToken()) - 1;
            board[x][y] = 1;
        }

        k = Integer.parseInt(br.readLine());
        change = new int[k][2];
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            change[i][0] = Integer.parseInt(st.nextToken());
            change[i][1] = st.nextToken().equals("D") ? 1 : -1;
        }

        x = 0;
        y = 0;
        int px = x + dx[direct];
        int py = y + dy[direct];
        while (inRange(px, py) && board[px][py] != 2) {
            ans++;
            board[x][y] = 2;
            deque.addLast(new Position(x, y));
            x = px;
            y = py;
            if (board[x][y] == 0) {
                board[deque.getFirst().x][deque.getFirst().y] = 0;
                deque.removeFirst();
            }
            if (changeIdx < k && change[changeIdx][0] == ans) {
                direct = (direct + 4 + change[changeIdx++][1]) % 4;
            }

            px = x + dx[direct];
            py = y + dy[direct];
        }

        bw.write((ans + 1) + "\n");
        bw.flush();
    }

    private static boolean inRange(int x, int y) {
        return x >= 0 && y >= 0 && x < n && y < n;
    }

    static class Position {
        int x;
        int y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
